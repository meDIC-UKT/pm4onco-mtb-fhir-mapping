package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing a DNA fusion/gene rearrangement.
 */
public class DNAFusion extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private DNAFusion(Observation observation){
    super(observation, PROFILE);
  }


  public static DNAFusion of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new DNAFusion(observation);
  }

}
