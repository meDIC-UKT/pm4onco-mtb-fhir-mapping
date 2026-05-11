package de.ukt.medic.fhir.profiles.mtb.molecularPathologyFindings;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Observation representing an immunohistochemistry (IHC) result.
 */
public class Immunohistochemistry extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private Immunohistochemistry(Observation observation){
    super(observation, PROFILE);
  }


  public static Immunohistochemistry of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new Immunohistochemistry(observation);
  }

}
