package de.ukt.medic.fhir.profiles.mtb.followUp;

import org.hl7.fhir.r4.model.ClinicalImpression;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR ClinicalImpression representing the general Follow-Up state.
 */
public class FollowUp_ClinicalImpression extends Profiled<ClinicalImpression> {

    public static final String PROFILE = "";

    private FollowUp_ClinicalImpression(ClinicalImpression resource) {
        super(resource, PROFILE);
    }

    public static FollowUp_ClinicalImpression of(
            // TODO: Add parameters
    ) {
        var resource = new ClinicalImpression();
        // TODO: Set required fields

        return new FollowUp_ClinicalImpression(resource);
    }
}