package de.ukt.medic.fhir.profiles.mtb.episodeOfCare;


import org.hl7.fhir.r4.model.Procedure;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR Procedure for prior systemic therapy.
 */
public class SystematicPreTreatment extends Profiled<Procedure> {

    public static final String PROFILE = "";

    private SystematicPreTreatment(Procedure resource) {
        super(resource, PROFILE);
    }

    public static SystematicPreTreatment of() {
        var resource = new Procedure();
        return new SystematicPreTreatment(resource);
    }
}