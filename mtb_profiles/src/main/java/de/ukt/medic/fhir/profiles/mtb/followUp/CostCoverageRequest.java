package de.ukt.medic.fhir.profiles.mtb.followUp;

import org.hl7.fhir.r4.model.Claim;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Claim for the request of cost coverage (Antrag Kostenübernahme).
 * Includes extensions for 'Antragsstadium'.
 */
public class CostCoverageRequest extends Profiled<Claim> {

    public static final String PROFILE = "";

    private CostCoverageRequest(Claim resource) {
        super(resource, PROFILE);
    }

    public static CostCoverageRequest of(
            // TODO: Add parameters
    ) {
        var resource = new Claim();
        // TODO: Set required fields

        return new CostCoverageRequest(resource);
    }
}