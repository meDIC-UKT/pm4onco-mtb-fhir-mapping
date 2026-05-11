package de.ukt.medic.fhir.profiles.mtb.examples;


import java.time.LocalDate;

import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;
import de.ukt.medic.fhir.profiling.LiteralRef;
import de.ukt.medic.fhir.profiling.Profiled;
import de.ukt.medic.fhir.profiling.QualifiedCoding;
import de.ukt.medic.fhir.profiling.Systems;
import de.ukt.medic.fhir.profiling.Util;


/**
 * Profiled FHIR Observation representing an ECOG Performance Status assessment.
 *
 * <p>The ECOG Performance Status is a standard way of measuring how a disease affects
 * a patient's daily living abilities. It is widely used in oncology to assess patient
 * functional status and to determine treatment suitability.</p>
 *
 * <p>This class enforces the structure defined in the MII (Medical Informatics Initiative)
 * profile for MTB (Molecular Tumor Board) ECOG Performance Status observations.</p>
 *
 * <p>The observation code is dual-coded with both LOINC and SNOMED CT codes as required
 * by the profile.</p>
 *
 * @see <a href="https://simplifier.net/medizininformatikinitiative-modulonkologie/mii_pr_onko_allgemeiner_leistungszustand_ecog">MII ECOG Profile</a>
 */
public class ECOGStatus extends Profiled<Observation>
{

  /**
   * The canonical URI of the MII MTB ECOG Performance Status profile.
   */
  public static final String PROFILE_URI =
    "https://simplifier.net/mii-erweiterungsmodul-molekulares-tumorboard/mii_pr_mtb_ecogStatusnose_primaertumor";


  /**
   * The LOINC coding for ECOG Performance Status (code: 89262-0).
   */
  public static final QualifiedCoding LOINC_CODING =
    QualifiedCoding.of("89262-0",Systems.LOINC);

  /**
   * The SNOMED CT coding for ECOG Performance Status (code: 423740007).
   */
  public static final QualifiedCoding SNOMED_CODING =
    QualifiedCoding.of("423740007",Systems.SNOMEDCT);


  /**
   * The dual-coded observation code containing both LOINC and SNOMED CT codings.
   */
  private static final CodeableConcept CODE =
    new CodeableConcept(LOINC_CODING.coding()).addCoding(SNOMED_CODING.coding());


  /**
   * Private constructor that initializes the ECOG observation with the profile URI and code.
   *
   * <p>This constructor is private to enforce the use of the static factory method {@link #of},
   * which provides better control over object creation and ensures all required fields are provided.</p>
   *
   * @param ecog the HAPI-FHIR Observation to wrap
   */
  private ECOGStatus(Observation ecog){ 
    super(
      ecog,
      PROFILE_URI
    );
    ecog.setCode(CODE);
  }


  /**
   * Creates a new ECOG Performance Status observation.
   *
   * <p>This static factory method is preferred over a public constructor as it provides
   * better control over object creation, clearer naming, and the ability to return cached
   * instances if needed in the future. See "Effective Java" by Joshua Bloch, Item 1.</p>
   *
   * @param id the unique identifier for this observation
   * @param subject reference to the patient this observation is about
   * @param date the date when this performance status was assessed
   * @param ecogValue the ECOG value as a coded concept (typically 0-5)
   * @return a new ECOGStatus instance with status set to FINAL
   */
  public static ECOGStatus of(
    String id,
    LiteralRef<Patient> subject,
    LocalDate date,
    QualifiedCoding ecogValue
  ){ 
    var ecog = new Observation();
    ecog.setStatus(ObservationStatus.FINAL);
    ecog.setSubject(subject.reference());
    ecog.setEffective(new DateTimeType(Util.toDate(date)));
    ecog.setValue(new CodeableConcept(ecogValue.coding()));
    return new ECOGStatus(ecog);
  }

}
