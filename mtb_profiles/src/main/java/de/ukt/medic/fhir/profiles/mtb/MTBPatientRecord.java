package de.ukt.medic.fhir.profiles.mtb;


import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import org.hl7.fhir.r4.model.Bundle;
import de.ukt.medic.fhir.profiling.Profiled;


public class MTBPatientRecord extends Profiled<Bundle>
{

  public static final String PROFILE_URI =
    "TODO";


  private MTBPatientRecord(Bundle bundle){
    super(
      bundle,
      PROFILE_URI
    );
  }


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
