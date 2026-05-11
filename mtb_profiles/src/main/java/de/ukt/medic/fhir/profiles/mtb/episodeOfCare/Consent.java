package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;


import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Observation representing patient consent.
 */
public class Consent extends Profiled<Observation> {

    public static final String PROFILE = "";

    private Consent(Observation resource) {
        super(resource, PROFILE);
    }

    public static Consent of(
            // TODO: Add parameters
    ) {
        var resource = new Observation();
        // TODO: Set required fields

        return new Consent(resource);
    }
}