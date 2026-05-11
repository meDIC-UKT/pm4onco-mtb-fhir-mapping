package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing microsatellite instability (MSI) status.
 */
public class MSIStatus extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private MSIStatus(Observation observation){
    super(observation, PROFILE);
  }


  public static MSIStatus of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new MSIStatus(observation);
  }

}
