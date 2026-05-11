package de.ukt.medic.fhir.profiles.mtb.followUp;

import org.hl7.fhir.r4.model.Procedure;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Procedure for systemic Molecular Tumor Board therapy.
 */
public class SystematicTherapieProcedure extends Profiled<Procedure> {

    public static final String PROFILE = "";

    private SystematicTherapieProcedure(Procedure resource) {
        super(resource, PROFILE);
    }

    public static SystematicTherapieProcedure of(
            // TODO: Add parameters
    ) {
        var resource = new Procedure();
        // TODO: Set required fields

        return new SystematicTherapieProcedure(resource);
    }
}