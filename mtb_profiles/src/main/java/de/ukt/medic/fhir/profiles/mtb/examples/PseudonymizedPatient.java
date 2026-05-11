package de.ukt.medic.fhir.profiles.mtb.examples;


import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import de.ukt.medic.fhir.profiling.Profiled;
import de.ukt.medic.fhir.profiling.Util;


/**
 * Profiled FHIR Patient representing a pseudonymized patient record.
 *
 * <p>This class represents a patient with pseudonymized identifying information, suitable
 * for use in research and clinical data exchange where patient privacy must be protected.
 * Only essential demographic data (gender, birth date, death date) is included, with no
 * directly identifying information such as names or addresses.</p>
 *
 * <p>This class enforces the structure defined in the MII (Medical Informatics Initiative)
 * base module for pseudonymized patient records. The profile is designed to meet German
 * data protection requirements while enabling medical research.</p>
 *
 * <p>Note: Birth date is represented as YearMonth (year and month only) to provide
 * additional de-identification while retaining sufficient precision for most medical purposes.</p>
 *
 * @see <a href="https://simplifier.net/mii-basismodul-person-2024/mii_pr_person_patientpseudonymisiert">MII Pseudonymized Patient Profile</a>
 */
public class PseudonymizedPatient extends Profiled<Patient>
{

  /**
   * The canonical URI of the MII pseudonymized patient profile.
   */
  public static final String PROFILE_URI =
    "https://www.medizininformatik-initiative.de/fhir/core/modul-person/StructureDefinition/PatientPseudonymisiert";


  /**
   * Private constructor that initializes the patient with the profile URI.
   *
   * <p>This constructor is private to enforce the use of the static factory method {@link #of},
   * which provides better control over object creation and ensures all required fields are provided.</p>
   *
   * @param patient the HAPI-FHIR Patient to wrap
   */
  private PseudonymizedPatient(Patient patient){
    super(
      patient,
      PROFILE_URI
    );
  }


  /**
   * Creates a new pseudonymized patient.
   *
   * <p>This static factory method is preferred over a public constructor as it provides
   * better control over object creation, clearer naming, and the ability to return cached
   * instances if needed in the future. See "Effective Java" by Joshua Bloch, Item 1.</p>
   *
   * @param id the unique pseudonymized identifier for this patient
   * @param gender the administrative gender of the patient
   * @param birthDate the year and month of birth (day is omitted for privacy)
   * @param dateOfDeath optional date of death if the patient is deceased
   * @return a new PseudonymizedPatient instance
   * @todo Additional attributes may be needed as the profile is further developed
   */
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


  /**
   * Gets the administrative gender of the patient.
   *
   * @return the patient's gender
   */
  public AdministrativeGender gender(){ 
    return this.resource.getGender();
  }

  /**
   * Gets the birth date of the patient as year and month.
   *
   * @return the patient's birth year and month
   */
  public YearMonth birthDate(){
    return Util.yearMonth(this.resource.getBirthDate());   
  }

  /**
   * Gets the date of death if the patient is deceased.
   *
   * @return an Optional containing the date of death if present, or empty if the patient is alive or status unknown
   */
  public Optional<LocalDate> dateOfDeath(){
    return Optional.ofNullable(
      this.resource.getDeceasedDateTimeType()).map(dt -> Util.localDate(dt.getValue())
    );
  }

}
