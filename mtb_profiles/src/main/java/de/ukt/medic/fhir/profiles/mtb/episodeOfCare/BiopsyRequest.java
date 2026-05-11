package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.ServiceRequest;
import de.ukt.medic.fhir.profiling.Profiled;

public class BiopsyRequest extends Profiled<ServiceRequest> {

    public static final String PROFILE = "";

    private BiopsyRequest(ServiceRequest resource) {
        super(resource, PROFILE);
    }

    public static BiopsyRequest of(
            // TODO: Add parameters
    ) {
        var resource = new ServiceRequest();
        // TODO: Set required fields

        return new BiopsyRequest(resource);
    }
}