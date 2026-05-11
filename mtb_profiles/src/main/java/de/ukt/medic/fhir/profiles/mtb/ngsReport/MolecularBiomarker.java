package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Observation representing a molecular biomarker.
 */
public class MolecularBiomarker extends Profiled<Observation>
{

  public static final String PROFILE = "";

  private MolecularBiomarker(Observation observation){
    super(observation, PROFILE);
  }


  public static MolecularBiomarker of(
    // TODO: Add parameters
  ){
    var observation = new Observation();
    // TODO: Set required fields
    return new MolecularBiomarker(observation);
  }

}
