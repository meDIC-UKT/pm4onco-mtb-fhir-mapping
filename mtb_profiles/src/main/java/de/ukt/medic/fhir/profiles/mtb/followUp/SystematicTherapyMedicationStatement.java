package de.ukt.medic.fhir.profiles.mtb.followUp;

import org.hl7.fhir.r4.model.MedicationStatement;
import de.ukt.medic.fhir.profiling.Profiled;

/**
 * Profiled FHIR MedicationStatement for systemic therapy.
 */
public class SystematicTherapyMedicationStatement extends Profiled<MedicationStatement> {

    public static final String PROFILE = "";

    private SystematicTherapyMedicationStatement(MedicationStatement resource) {
        super(resource, PROFILE);
    }

    public static SystematicTherapyMedicationStatement of(
            // TODO: Add parameters
    ) {
        var resource = new MedicationStatement();
        // TODO: Set required fields

        return new SystematicTherapyMedicationStatement(resource);
    }
}