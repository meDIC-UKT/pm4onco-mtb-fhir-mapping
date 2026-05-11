package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.CarePlan;
import de.ukt.medic.fhir.profiling.Profiled;

public class TherapyPlan extends Profiled<CarePlan> {

    public static final String PROFILE = "";

    private TherapyPlan(CarePlan resource) {
        super(resource, PROFILE);
    }

    public static TherapyPlan of(
            // TODO: Add parameters
    ) {
        var resource = new CarePlan();
        // TODO: Set required fields

        return new TherapyPlan(resource);
    }
}