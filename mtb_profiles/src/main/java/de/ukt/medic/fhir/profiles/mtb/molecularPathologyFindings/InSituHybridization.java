package de.ukt.medic.fhir.profiles.mtb.molecularPathologyFindings;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Observation representing in situ hybridization (FISH/CISH/SISH) result.
 */
public class InSituHybridization extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private InSituHybridization(Observation observation){
    super(observation, PROFILE);
  }


  public static InSituHybridization of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new InSituHybridization(observation);
  }

}
