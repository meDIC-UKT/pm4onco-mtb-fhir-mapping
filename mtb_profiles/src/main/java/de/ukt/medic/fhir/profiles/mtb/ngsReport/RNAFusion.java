package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing an RNA fusion transcript.
 */
public class RNAFusion extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private RNAFusion(Observation observation){
    super(observation, PROFILE);
  }


  public static RNAFusion of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new RNAFusion(observation);
  }

}
