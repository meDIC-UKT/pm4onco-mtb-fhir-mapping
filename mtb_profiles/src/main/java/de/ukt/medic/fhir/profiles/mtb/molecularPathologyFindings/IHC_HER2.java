package de.ukt.medic.fhir.profiles.mtb.molecularPathologyFindings;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Observation representing HER2 immunohistochemistry result.
 */
public class IHC_HER2 extends Profiled<Observation>
{

  public static final String PROFILE = "";


  private IHC_HER2(Observation observation){
    super(observation, PROFILE);
  }


  public static IHC_HER2 of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new IHC_HER2(observation);
  }

}
