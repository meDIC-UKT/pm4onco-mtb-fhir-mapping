package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.Observation;
import de.ukt.medic.fhir.profiling.Profiled;

public class TumorCellContent extends Profiled<Observation> {

    public static final String PROFILE = "";

    private TumorCellContent(Observation resource) {
        super(resource, PROFILE);
    }

    public static TumorCellContent of(
            // TODO: Add parameters
    ) {
        var resource = new Observation();
        // TODO: Set required fields

        return new TumorCellContent(resource);
    }
}