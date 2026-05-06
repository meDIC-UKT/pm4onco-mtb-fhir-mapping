package de.ukt.medic.fhir.profiling;


import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Resource;
import ca.uhn.fhir.parser.IParser;
import static ca.uhn.fhir.context.FhirContext.forR4Cached;



/**
 * Based on the principle "favour composition over inheritance":
 * Instead of representing a profiled resource as an extension/specialization of the base resource,
 * use a wrapper around the resource instance.
 * This has the advantage of hiding the mutability of HAPI-FHIR resources within
 * the immutable or at least selectively mutable wrapper object,
 * whereas mere extensions e.g. "class MyPatient extends Patient" are still mutable.
 *
 * The idea is for a class specializing Profiled<T> to form a "consistency boundary" around the wrapped resource,
 * by providing only a non-default constructor (or better: static factory method) to which all expected attributes
 * must be passed, so as to ensure instantiation of the resource in a consistent state.
 * Also, the factory method would serve as an "anti-corruption layer" for the fact that HAPI-FHIR still requires 
 * client code to use the essentially obsolete java.util.Date. Instead, date/time attributes would be represented
 * with the new java.time.* components, and only converted to java.util.Date under the hood for 
 * initialization of the resource.
 */

public abstract class Profiled<T extends Resource>
{

  protected final T resource;

  private static final IParser PARSER = forR4Cached().newJsonParser();

  protected Profiled(
    T resource,
    String profile
  ){
    this.resource = resource;
    this.resource.getMeta().getProfile().add(new CanonicalType(profile));
  }
 

  public final String id(){
    return resource.getId();
  }

/*
  // Package private, for internal use only, to avoid copying the resource
  final T resource(){ 
    return resource;
  } 
*/

  // Return a copy (!) of the wrapped resource, to prevent it from being mutated
  public final T resource(){ 
    return (T)resource.copy();
  } 


  public String toJson(){ 
    return PARSER.encodeToString(resource);
  }

}
