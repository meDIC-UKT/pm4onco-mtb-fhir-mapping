package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import de.ukt.medic.fhir.profiling.Profiled;
import org.hl7.fhir.r4.model.ServiceRequest;

    /**
     * Profiled FHIR ServiceRequest representing the study eligibility.
     */
    public class StudyEligibilityRequest extends Profiled<ServiceRequest> {

        public static final String PROFILE = "";

        private StudyEligibilityRequest(ServiceRequest resource) {
            super(resource, PROFILE);
        }

        public static StudyEligibilityRequest of(
                // TODO: Add parameters
        ) {
            var resource = new ServiceRequest();
            // TODO: Set required fields

            return new StudyEligibilityRequest(resource);
        }
}
