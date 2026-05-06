package de.ukt.medic.fhir.profiles.mtb;


import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import de.ukt.medic.fhir.profiling.Profiled;
import de.ukt.medic.fhir.profiling.QualifiedCoding;
import de.ukt.medic.fhir.profiling.LiteralRef;
import de.ukt.medic.fhir.profiling.Util;


public class PseudonymizedPatient extends Profiled<Patient>
{

  // Origin: Simplifier MII Profile: https://simplifier.net/mii-basismodul-person-2024/mii_pr_person_patientpseudonymisiert
  public static final String PROFILE_URI =
    "https://www.medizininformatik-initiative.de/fhir/core/modul-person/StructureDefinition/PatientPseudonymisiert";


  private PseudonymizedPatient(Patient patient){
    super(
      patient,
      PROFILE_URI
    );
  }


  // Better use a static factory method together with a private constructor, instead of exposing the constructor
  // See: "J. Bloch - Effective Java, 3rd Ed.", Item 1
  public static PseudonymizedPatient of(
    String id,
    AdministrativeGender gender,
    YearMonth birthDate,   
    Optional<LocalDate> dateOfDeath
    //TODO: Other attributes as needed 
  ){ 
    var patient = new Patient();
    patient.setId(id);
    patient.setGender(gender);
    patient.setBirthDate(Util.toDate(birthDate));

    // Set Patient.deceased if dateOfDeath is defined
    dateOfDeath.map(Util::toDate).ifPresent(d -> patient.setDeceased(new DateTimeType(d)));

    return new PseudonymizedPatient(patient);
  }


  public AdministrativeGender gender(){ 
    return this.resource.getGender();
  }

  public YearMonth birthDate(){
    return Util.yearMonth(this.resource.getBirthDate());   
  }

  public Optional<LocalDate> dateOfDeath(){
    return Optional.ofNullable(
      this.resource.getDeceasedDateTimeType()).map(dt -> Util.localDate(dt.getValue())
    );
  }

}
