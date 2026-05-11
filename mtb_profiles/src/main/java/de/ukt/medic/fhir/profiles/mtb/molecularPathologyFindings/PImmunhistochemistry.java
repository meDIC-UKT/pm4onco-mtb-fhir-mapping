package de.ukt.medic.fhir.profiles.mtb.molecularPathologyFindings;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing phospho-immunohistochemistry (p-IHC) result.
 */
public class PImmunhistochemistry extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private PImmunhistochemistry(Observation observation){
    super(observation, PROFILE);
  }


  public static PImmunhistochemistry of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new PImmunhistochemistry(observation);
  }

}
