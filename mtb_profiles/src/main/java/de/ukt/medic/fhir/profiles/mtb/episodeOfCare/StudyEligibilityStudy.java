package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import de.ukt.medic.fhir.profiling.Profiled;
import org.hl7.fhir.r4.model.ResearchStudy;


/**
 * Profiled FHIR ResearchStudy representing the research study.
 */
public class StudyEligibilityStudy extends Profiled<ResearchStudy> {

    public static final String PROFILE = "";

    private StudyEligibilityStudy(ResearchStudy resource) {
        super(resource, PROFILE);
    }

    public static StudyEligibilityStudy of() {
        var resource = new ResearchStudy();
        return new StudyEligibilityStudy(resource);
    }
}

