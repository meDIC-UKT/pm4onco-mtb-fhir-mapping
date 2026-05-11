package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing a genetic variant (SNV/InDel).
 */
public class GeneticVariant extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private GeneticVariant(Observation observation){
    super(observation, PROFILE);
  }


  public static GeneticVariant of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new GeneticVariant(observation);
  }

}
