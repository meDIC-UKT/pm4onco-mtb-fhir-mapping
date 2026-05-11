package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Procedure;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Procedure representing a genomic study/sequencing procedure.
 */
public class GenomicStudy extends Profiled<Procedure>
{

  public static final String PROFILE = "";

  private GenomicStudy(Procedure procedure){
    super(procedure, PROFILE);
  }


  public static GenomicStudy of(
    // TODO: Add parameters
  ){
    var procedure = new Procedure();
    // TODO: Set required fields
    return new GenomicStudy(procedure);
  }

}
