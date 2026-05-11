package de.ukt.medic.fhir.profiling;


import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;


/**
 * Represents a logical FHIR reference using an Identifier to identify the target resource.
 *
 * <p>This implementation of {@link Ref} creates references where the target resource
 * is identified by a business identifier rather than a direct URI. This is useful when
 * the exact location of a resource is unknown or when referring to resources across
 * different systems using a shared identifier system.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * Identifier id = new Identifier()
 *     .setSystem("http://hospital.org/patients")
 *     .setValue("12345");
 * LogicalRef<Patient> patientRef = new LogicalRef<>(id);
 * Reference fhirReference = patientRef.reference(); // Creates Reference with identifier
 * }</pre>
 *
 * @param <T> the type of FHIR resource this reference points to
 * @param identifier the FHIR Identifier that identifies the target resource
 */
public record LogicalRef<T extends Resource>(
  Identifier identifier
)
implements Ref<T>
{
  /**
   * Converts this logical reference to a HAPI-FHIR Reference object.
   *
   * @return a new HAPI-FHIR Reference containing the identifier
   */
  @Override
  public Reference reference(){
    return new Reference().setIdentifier(identifier);
  }
}
