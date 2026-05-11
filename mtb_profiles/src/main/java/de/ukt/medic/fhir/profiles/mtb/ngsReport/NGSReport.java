package de.ukt.medic.fhir.profiles.mtb.ngsReport;

import org.hl7.fhir.r4.model.DiagnosticReport;
import de.ukt.medic.fhir.profiling.Profiled;


/**
 * Profiled FHIR DiagnosticReport representing an NGS diagnostic report.
 */
public class NGSReport extends Profiled<DiagnosticReport>
{

  public static final String PROFILE = "";

  private NGSReport(DiagnosticReport report){
    super(report, PROFILE);
  }


  public static NGSReport of(
    // TODO: Add parameters
  ){
    var report = new DiagnosticReport();
    // TODO: Set required fields
    return new NGSReport(report);
  }

}
