package de.ukt.medic.fhir.profiling;


import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;


/**
 * Represents a literal FHIR reference using a URI to identify the target resource.
 *
 * <p>This implementation of {@link Ref} creates references where the target resource
 * is identified by its URI (which may be relative or absolute). This is in contrast
 * to logical references that use identifiers.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * LiteralRef<Patient> patientRef = new LiteralRef<>("Patient/123");
 * Reference fhirReference = patientRef.reference(); // Creates Reference with reference="Patient/123"
 * }</pre>
 *
 * @param <T> the type of FHIR resource this reference points to
 * @param uri the URI identifying the target resource (e.g., "Patient/123" or an absolute URL)
 */
public record LiteralRef<T extends Resource>(String uri) implements Ref<T>
{

  /**
   * Converts this literal reference to a HAPI-FHIR Reference object.
   *
   * @return a new HAPI-FHIR Reference containing this URI
   */
  @Override
  public Reference reference(){
    return new Reference(uri);
  }


}
