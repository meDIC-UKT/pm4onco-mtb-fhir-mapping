package de.ukt.medic.fhir.profiles.mtb.followUp;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Observation representing the finding response (Befund Response).
 */
public class FindingsReponse extends Profiled<Observation> {

    public static final String PROFILE = "";

    private FindingsReponse(Observation resource) {
        super(resource, PROFILE);
    }

    public static FindingsReponse of(
            // TODO: Add parameters
    ) {
        var resource = new Observation();
        // TODO: Set required fields

        return new FindingsReponse(resource);
    }
}