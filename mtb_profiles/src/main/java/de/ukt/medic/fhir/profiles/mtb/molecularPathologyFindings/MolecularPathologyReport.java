package de.ukt.medic.fhir.profiles.mtb.molecularPathologyFindings;

import org.hl7.fhir.r4.model.DiagnosticReport;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR DiagnosticReport representing a molecular pathology report.
 */
public class MolecularPathologyReport extends Profiled<DiagnosticReport>
{

  public static final String PROFILE = "";

  private MolecularPathologyReport(DiagnosticReport report){
    super(report, PROFILE);
  }


  public static MolecularPathologyReport of(
    // TODO: Add parameters
  ){
    var report = new DiagnosticReport();
    // TODO: Set required fields
    return new MolecularPathologyReport(report);
  }

}
