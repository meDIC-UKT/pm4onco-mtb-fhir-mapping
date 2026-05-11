package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.MedicationRequest;
import de.ukt.medic.fhir.profiling.Profiled;

public class TherapyRecommendation extends Profiled<MedicationRequest> {

    public static final String PROFILE = "";

    private TherapyRecommendation(MedicationRequest resource) {
        super(resource, PROFILE);
    }

    public static TherapyRecommendation of() {
        var resource = new MedicationRequest();
        return new TherapyRecommendation(resource);
    }
}