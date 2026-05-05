package de.ukt.medic.fhir.profiles.mtb;


import java.time.LocalDate;
import java.util.Optional;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Patient;
import de.ukt.medic.fhir.profiling.Profiled;
import de.ukt.medic.fhir.profiling.QualifiedCoding;
import de.ukt.medic.fhir.profiling.LiteralRef;
import de.ukt.medic.fhir.profiling.Util;


/**
 * Condition specialization to enforce the attributes of a tumor diagnosis, e.g.:
 * ICD-10-GM Coding
 * ICD-O-3 Coding
 * etc...
 */
public class TumorDiagnosis extends Profiled<Condition>
{

  // TODO: Simplifier Profile https://simplifier.net/mii-erweiterungsmodul-molekulares-tumorboard/mii_pr_mtb_diagnose_primaertumor wasn't resolvable
  public static final String PROFILE_URI =
     "https://simplifier.net/mii-erweiterungsmodul-molekulares-tumorboard/mii_pr_mtb_diagnose_primaertumor";


  private TumorDiagnosis(Condition condition){ 
    super(
      condition,
      PROFILE_URI
    );
  }


  // Better use a static factory method together with a private constructor, instead of exposing the constructor
  // See: "J. Bloch - Effective Java, 3rd Ed.", Item 1
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
