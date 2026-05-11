package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.ClinicalImpression;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR ClinicalImpression representing the treatment episode.
 */
public class EpisodeOfCareClinicalImpression extends Profiled<ClinicalImpression> {

    public static final String PROFILE = "";

    private EpisodeOfCareClinicalImpression(ClinicalImpression resource) {
        super(resource, PROFILE);
    }

    public static EpisodeOfCareClinicalImpression of(
            // TODO: Add parameters
    ) {
        var resource = new ClinicalImpression();
        // TODO: Set required fields

        return new EpisodeOfCareClinicalImpression(resource);
    }
}