package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;


import org.hl7.fhir.r4.model.ServiceRequest;
import de.ukt.medic.fhir.profiling.Profiled;

public class HistologyEvaluation extends Profiled<ServiceRequest> {

    public static final String PROFILE = "";

    private HistologyEvaluation(ServiceRequest resource) {
        super(resource, PROFILE);
    }

    public static HistologyEvaluation of(
            // TODO: Add parameters
    ) {
        var resource = new ServiceRequest();
        // TODO: Set required fields

        return new HistologyEvaluation(resource);
    }
}