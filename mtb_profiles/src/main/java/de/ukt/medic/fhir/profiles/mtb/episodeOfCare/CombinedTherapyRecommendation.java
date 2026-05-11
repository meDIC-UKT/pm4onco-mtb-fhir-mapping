package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import de.ukt.medic.fhir.profiling.Profiled;
import org.hl7.fhir.r4.model.RequestGroup;

public class CombinedTherapyRecommendation extends Profiled<RequestGroup> {

    public static final String PROFILE = "";

    private CombinedTherapyRecommendation(RequestGroup resource) {
        super(resource, PROFILE);
    }

    public static CombinedTherapyRecommendation of(
            // TODO: Add parameters
    ) {
        var resource = new RequestGroup();
        // TODO: Set required fields

        return new CombinedTherapyRecommendation(resource);
    }
}