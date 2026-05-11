package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;

public class Oncotree extends Profiled<Observation> {

    public static final String PROFILE = "";

    private Oncotree(Observation resource) {
        super(resource, PROFILE);
    }

    public static Oncotree of(
            // TODO: Add parameters
    ) {
        var resource = new Observation();
        // TODO: Set required fields

        return new Oncotree(resource);
    }
}