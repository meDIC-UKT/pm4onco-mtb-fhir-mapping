package de.ukt.medic.fhir.mappings.mtb;


import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import scala.util.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import de.ekut.tbi.generators.Gen;
import de.dnpm.dip.mtb.gens.Generators$;
import de.dnpm.dip.util.Completer;
import de.dnpm.dip.model.Gender$;
import de.dnpm.dip.model.Patient;
import de.dnpm.dip.mtb.model.MTBPatientRecord;
import de.dnpm.dip.mtb.model.MTBPatientRecord$;
import de.dnpm.dip.mtb.model.Completers$;
import play.api.libs.json.Json;
import static de.ukt.medic.fhir.mappings.mtb.Mappings.*;


class Tests
{

  private static final Random RND = new Random();

  private static final Gen<MTBPatientRecord> PATIENT_RECORDS = Generators$.MODULE$.genPatientRecord();

  public static final Completer<MTBPatientRecord> PATIENT_RECORD_COMPLETER = Completers$.MODULE$.mtbPatientRecordCompleter();

  private static MTBPatientRecord patientRecord;

  private static List<MTBPatientRecord> patientRecords;


  @BeforeAll
  static void init(){ 

    // System property to configure the local site running DIP components,
    // required among others to initialize the local/managing site in Patient objects
    System.setProperty("dnpm.dip.site","UKx:Musterhausen");


    // Here how to get a generated DTO instance...
    patientRecord = PATIENT_RECORDS.next(RND);

    // ... or how to get a whole List of generated DTO instances.
    patientRecords = 
      Stream.generate(() -> PATIENT_RECORDS.next(RND))
        .limit(42)
        .map(PATIENT_RECORD_COMPLETER::apply) // Apply the Completer<MTBPatientRecord> to each
        .collect(toList());
  }


  @Test 
  public void testGenderMapping(){

    // Ensure that each Gender value from the source model is mapped
    assertTrue(
      Gender$.MODULE$.values().forall(ADMINISTRATIVE_GENDER::containsKey)
    );

    // Ensure that each AdministrativeGender value is mapped to
    assertTrue(
      Stream.of(AdministrativeGender.values())
        .filter(gender -> gender != AdministrativeGender.NULL) // Required because HAPI-FHIR introduced the fantasy value AdministrativeGender.NULL for which no mapping exists
        .allMatch(ADMINISTRATIVE_GENDER::containsValue)
    );

  }


  @Test
  public void testCompletion(){

    // Assert that all gender display values have been initialized
    assertTrue(
      patientRecords.stream()
        .map(record -> record.patient().gender())
        .allMatch(gender -> gender.display().isDefined())
    );

    // Assert that all ICD-10 coding display values have been initialized
    assertTrue(
      patientRecords.stream()
        .map(
          record ->
            record.diagnoses()
              .toList()
              .map(diag -> diag.code())
              .forall(coding -> coding.display().isDefined())
        )
        .allMatch(b -> true)
    );
  }


  @Test 
  public void testPatientMappingVariant1(){

    var patient = patientRecord.patient();

    var fhirPatient = toFHIR(patient);

    // Ensure that each attribute present on the input Patient is defined on the output FHIR Patient
    assertNotNull(fhirPatient.id());
    assertNotNull(fhirPatient.birthDate());
    assertNotNull(fhirPatient.gender());
    assertTrue(patient.dateOfDeath().isDefined() ? fhirPatient.dateOfDeath().isPresent() : true);

  }


  @Test 
  public void testPatientMappingVariant2(){

    assertTrue(
      patientRecords
        .stream()
        .map(MTBPatientRecord::patient)
        .allMatch(
          patient -> {
            var fhirPatient = toFHIR(patient);

            // Ensure that each attribute present on the input Patient is defined on the output FHIR Patient
            //TODO: if dateOfDeath was defined on the input Patient, it must be non-null on the FHIR Patient, etc...
            
            return (fhirPatient.id() != null) && (fhirPatient.birthDate() != null ) && (fhirPatient.gender() != null);
          }
        )
    );

  }

}
