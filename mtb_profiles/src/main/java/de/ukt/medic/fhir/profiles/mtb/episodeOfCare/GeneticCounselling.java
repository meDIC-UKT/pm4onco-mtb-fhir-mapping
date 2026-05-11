package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import de.ukt.medic.fhir.profiling.Profiled;
import org.hl7.fhir.r4.model.ServiceRequest;

/**
 * Profiled FHIR ServiceRequest representing the study eligibility.
 */
public class GeneticCounselling extends Profiled<ServiceRequest> {

    public static final String PROFILE = "";

    private GeneticCounselling(ServiceRequest resource) {
        super(resource, PROFILE);
    }

    public static GeneticCounselling of() {
        var resource = new ServiceRequest();
        return new GeneticCounselling(resource);
    }
}