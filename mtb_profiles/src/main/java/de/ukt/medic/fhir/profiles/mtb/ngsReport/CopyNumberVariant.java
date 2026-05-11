package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing a copy number variant (CNV).
 */
public class CopyNumberVariant extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private CopyNumberVariant(Observation observation){
    super(observation, PROFILE);
  }


  public static CopyNumberVariant of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new CopyNumberVariant(observation);
  }

}
