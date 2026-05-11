package de.ukt.medic.fhir.profiles.mtb.followUp;

import org.hl7.fhir.r4.model.ClaimResponse;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR ClaimResponse for cost coverage.
 * Includes extensions for 'Ablehnungsgrund' and 'Entscheidung'.
 */
public class CostCoverageResponse extends Profiled<ClaimResponse> {

    public static final String PROFILE = "";

    private CostCoverageResponse(ClaimResponse resource) {
        super(resource, PROFILE);
    }

    public static CostCoverageResponse of(
            // TODO: Add parameters
    ) {
        var resource = new ClaimResponse();
        // TODO: Set required fields

        return new CostCoverageResponse(resource);
    }
}