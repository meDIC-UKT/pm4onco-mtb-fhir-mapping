package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing tumor mutational burden (TMB).
 */
public class TMBStatus extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private TMBStatus(Observation observation){
    super(observation, PROFILE);
  }


  public static TMBStatus of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new TMBStatus(observation);
  }

}
