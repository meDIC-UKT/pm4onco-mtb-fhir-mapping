package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.Condition;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Condition for the primary tumor diagnosis.
 */
public class PrimaryTumorDiagnosis extends Profiled<Condition> {

    public static final String PROFILE = "";

    private PrimaryTumorDiagnosis(Condition resource) {
        super(resource, PROFILE);
    }

    public static PrimaryTumorDiagnosis of(
            // TODO: Add parameters
    ) {
        var resource = new Condition();
        // TODO: Set required fields

        return new PrimaryTumorDiagnosis(resource);
    }
}