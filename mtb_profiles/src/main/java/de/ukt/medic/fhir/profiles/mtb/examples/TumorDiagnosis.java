package de.ukt.medic.fhir.profiles.mtb.examples;


import java.time.LocalDate;
import java.util.Optional;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Patient;
import de.ukt.medic.fhir.profiling.Profiled;
import de.ukt.medic.fhir.profiling.QualifiedCoding;
import de.ukt.medic.fhir.profiling.LiteralRef;
import de.ukt.medic.fhir.profiling.Util;


/**
 * Profiled FHIR Condition representing a tumor diagnosis for Molecular Tumor Board (MTB) use cases.
 *
 * <p>This class represents a primary tumor diagnosis with appropriate coding systems for oncology:
 * <ul>
 *   <li><b>ICD-10-GM</b>: The primary diagnosis code using the German modification of ICD-10</li>
 *   <li><b>ICD-O-3</b>: Optional topography coding using the International Classification of Diseases for Oncology, 3rd edition</li>
 * </ul>
 * </p>
 *
 * <p>This class enforces the structure defined in the MII (Medical Informatics Initiative)
 * profile for MTB primary tumor diagnoses.</p>
 *
 * @see <a href="https://simplifier.net/mii-erweiterungsmodul-molekulares-tumorboard/mii_pr_mtb_diagnose_primaertumor">MII MTB Diagnosis Profile</a>
 */
public class TumorDiagnosis extends Profiled<Condition>
{

  /**
   * The canonical URI of the MII MTB primary tumor diagnosis profile.
   * TODO: Simplifier Profile URL wasn't resolvable at time of implementation
   */
  public static final String PROFILE_URI =
     "https://simplifier.net/mii-erweiterungsmodul-molekulares-tumorboard/mii_pr_mtb_diagnose_primaertumor";


  /**
   * Private constructor that initializes the tumor diagnosis with the profile URI.
   *
   * <p>This constructor is private to enforce the use of the static factory method {@link #of},
   * which provides better control over object creation and ensures all required fields are provided.</p>
   *
   * @param condition the HAPI-FHIR Condition to wrap
   */
  private TumorDiagnosis(Condition condition){ 
    super(
      condition,
      PROFILE_URI
    );
  }


  /**
   * Creates a new tumor diagnosis.
   *
   * <p>This static factory method is preferred over a public constructor as it provides
   * better control over object creation, clearer naming, and the ability to return cached
   * instances if needed in the future. See "Effective Java" by Joshua Bloch, Item 1.</p>
   *
   * @param id the unique identifier for this diagnosis
   * @param subject reference to the patient this diagnosis is about
   * @param diagnosisDate the date when this diagnosis was recorded
   * @param icd10Coding the ICD-10-GM code for the diagnosis
   * @param icdO3TCoding optional ICD-O-3 topography code specifying the tumor location
   * @return a new TumorDiagnosis instance
   * @todo Additional attributes may be needed as the profile is further developed
   */
  public static TumorDiagnosis of(
    String id,
    LiteralRef<Patient> subject,
    LocalDate diagnosisDate,
    QualifiedCoding icd10Coding,
    Optional<QualifiedCoding> icdO3TCoding
    //TODO: Other attributes as needed 
  ){ 
    var diag = new Condition(subject.reference());
    diag.setRecordedDate(Util.toDate(diagnosisDate));
    diag.getCode().addCoding(icd10Coding.coding());
    icdO3TCoding.ifPresent(c -> diag.addBodySite().addCoding(c.coding()));

    return new TumorDiagnosis(diag);
  }

}
