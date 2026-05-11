package de.ukt.medic.fhir.profiles.mtb.molecularPathologyFindings;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing PD-L1 immunohistochemistry result.
 */
public class IHC_PDL1 extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private IHC_PDL1(Observation observation){
    super(observation, PROFILE);
  }


  public static IHC_PDL1 of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new IHC_PDL1(observation);
  }

}
