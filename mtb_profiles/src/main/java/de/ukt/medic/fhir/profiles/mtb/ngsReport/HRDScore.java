package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing homologous recombination deficiency (HRD) score.
 */
public class HRDScore extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private HRDScore(Observation observation){
    super(observation, PROFILE);
  }


  public static HRDScore of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new HRDScore(observation);
  }

}
