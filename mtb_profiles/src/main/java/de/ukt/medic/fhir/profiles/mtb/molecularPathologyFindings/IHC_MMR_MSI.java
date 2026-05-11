package de.ukt.medic.fhir.profiles.mtb.molecularPathologyFindings;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing MMR/MSI immunohistochemistry result.
 */
public class IHC_MMR_MSI extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private IHC_MMR_MSI(Observation observation){
    super(observation, PROFILE);
  }


  public static IHC_MMR_MSI of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new IHC_MMR_MSI(observation);
  }

}
