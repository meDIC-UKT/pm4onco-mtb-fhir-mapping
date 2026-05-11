package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing RNA-seq gene expression data.
 */
public class RNASeq extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private RNASeq(Observation observation){
    super(observation, PROFILE);
  }


  public static RNASeq of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new RNASeq(observation);
  }

}
