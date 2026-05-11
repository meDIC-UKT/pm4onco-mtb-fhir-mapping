package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;

import org.hl7.fhir.r4.model.CarePlan;
import de.ukt.medic.fhir.profiling.Profiled;

public class TherapyPlan extends Profiled<CarePlan> {

    public static final String PROFILE = "";

    private TherapyPlan(CarePlan resource) {
        super(resource, PROFILE);
    }

    public static TherapyPlan of() {
        var resource = new CarePlan();
        return new TherapyPlan(resource);
    }
}