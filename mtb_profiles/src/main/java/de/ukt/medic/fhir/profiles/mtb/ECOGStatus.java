package de.ukt.medic.fhir.profiles.mtb;


import java.time.LocalDate;
import java.util.Optional;
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
 * Observation specialization to enforce the attributes of ECOG Performance Status
 */
public class ECOGStatus extends Profiled<Observation>
{

  public static final String PROFILE_URI =
    "https://simplifier.net/mii-erweiterungsmodul-molekulares-tumorboard/mii_pr_mtb_ecogStatusnose_primaertumor";


  // Source: https://simplifier.net/medizininformatikinitiative-modulonkologie/mii_pr_onko_allgemeiner_leistungszustand_ecog
  public static final QualifiedCoding LOINC_CODING =
    QualifiedCoding.of("89262-0",Systems.LOINC);

  public static final QualifiedCoding SNOMED_CODING =
    QualifiedCoding.of("423740007",Systems.SNOMEDCT);


  private static final CodeableConcept CODE =
    new CodeableConcept(LOINC_CODING.coding()).addCoding(SNOMED_CODING.coding());


  private ECOGStatus(Observation ecog){ 
    super(
      ecog,
      PROFILE_URI
    );
    ecog.setCode(CODE);
  }


  // Better use a static factory method together with a private constructor, instead of exposing the constructor
  // See: "J. Bloch - Effective Java, 3rd Ed.", Item 1
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
