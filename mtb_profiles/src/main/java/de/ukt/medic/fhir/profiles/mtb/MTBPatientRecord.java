package de.ukt.medic.fhir.profiles.mtb;


import java.util.List;

import de.ukt.medic.fhir.profiles.mtb.examples.ECOGStatus;
import de.ukt.medic.fhir.profiles.mtb.examples.PseudonymizedPatient;
import de.ukt.medic.fhir.profiles.mtb.examples.TumorDiagnosis;
import org.hl7.fhir.r4.model.Bundle;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Bundle representing a complete Molecular Tumor Board (MTB) patient record.
 *
 * <p>This class aggregates all clinical resources related to a single patient's molecular
 * tumor board case into a single FHIR Bundle. The bundle includes:</p>
 * <ul>
 *   <li>The pseudonymized patient demographic information</li>
 *   <li>Tumor diagnoses with ICD-10 and ICD-O-3 coding</li>
 *   <li>ECOG performance status observations</li>
 *   <li>Additional clinical and molecular data (to be added)</li>
 * </ul>
 *
 * <p>This bundle structure facilitates the exchange of complete patient records between
 * different MTB systems and supports comprehensive molecular tumor board workflows.</p>
 *
 * @see PseudonymizedPatient
 * @see TumorDiagnosis
 * @see ECOGStatus
 */
public class MTBPatientRecord extends Profiled<Bundle>
{

  /**
   * The canonical URI of the MTB patient record bundle profile.
   * TODO: Profile URI needs to be determined and documented
   */
  public static final String PROFILE_URI =
    "TODO";


  /**
   * Private constructor that initializes the bundle with the profile URI.
   *
   * <p>This constructor is private to enforce the use of the static factory method {@link #of},
   * which provides better control over object creation and ensures all required resources are included.</p>
   *
   * @param bundle the HAPI-FHIR Bundle to wrap
   */
  private MTBPatientRecord(Bundle bundle){
    super(
      bundle,
      PROFILE_URI
    );
  }


  /**
   * Creates a new MTB patient record bundle.
   *
   * <p>This method aggregates all provided resources into a single FHIR Bundle that
   * represents a complete patient record for molecular tumor board purposes.</p>
   *
   * @param patient the pseudonymized patient demographic information
   * @param diagnoses the list of tumor diagnoses for this patient
   * @param ecogs the list of ECOG performance status observations for this patient
   * @return a new MTBPatientRecord bundle containing all provided resources
   * @todo Additional resource types (genetic variants, therapies, etc.) to be added
   */
  public static MTBPatientRecord of(
    PseudonymizedPatient patient,
    List<TumorDiagnosis> diagnoses,
    List<ECOGStatus> ecogs
    //TODO...
  ){ 
    var bundle = new Bundle();

    bundle.addEntry().setResource(patient.resource());
    diagnoses.forEach(diag -> bundle.addEntry().setResource(diag.resource()));
    ecogs.forEach(ecog -> bundle.addEntry().setResource(ecog.resource()));

    return new MTBPatientRecord(bundle);
  }

}
