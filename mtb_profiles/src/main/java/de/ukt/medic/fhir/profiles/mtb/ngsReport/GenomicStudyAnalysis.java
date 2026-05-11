package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.Procedure;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR Procedure representing bioinformatics analysis of genomic data.
 */
public class GenomicStudyAnalysis extends Profiled<Procedure>
{

  public static final String PROFILE = "";

  private GenomicStudyAnalysis(Procedure procedure){
    super(procedure, PROFILE);
  }


  public static GenomicStudyAnalysis of(
    // TODO: Add parameters
  ){
    var procedure = new Procedure();
    // TODO: Set required fields
    return new GenomicStudyAnalysis(procedure);
  }

}
