package de.ukt.medic.fhir.profiling;


import java.util.Collection;
import java.util.Optional;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;


/*
  Sum type to properly represent the different Reference types:
  - Literal references via a URI (not necessarily absolute) to the resource
  - Logical references via Identifier
  - Contained resource reference
  This ensures a Ref instance to be in a well-defined state,
  whereas a HAPI-FHIR Reference can in principle be empty or in a multi-state (literal and logical)
*/
public sealed interface Ref<T extends Resource> permits LiteralRef, LogicalRef //, Ref.Contained
{

  // Return a HAPI-FHIR Reference representing this Ref
  public Reference reference();


  // Base utility to resolve a reference
  @FunctionalInterface
  public static interface Resolver<T extends Resource>
  {
    public Optional<T> resolve(Ref<T> ref);

    public static <T extends Resource> Resolver<T> on(Collection<T> ts){
      return ref -> {
        return switch(ref){
          case LiteralRef<T> literal ->
            ts.stream()
              .filter(r -> literal.uri().equals(r.getId()))
              .findFirst();

          default -> Optional.empty();
        }; 
      };
    }

/*
    public static <R extends Resource, T extends Profiled<R>> Resolver<R> on(Collection<T> ts){
      return ref -> {
        return switch(ref){
          case LiteralRef<R> literal ->
            ts.stream()
              .filter(r -> literal.uri().equals(r.id()))
              .findFirst()
              .map(Profiled::resource);

          default -> Optional.empty();
        }; 
      };
    }
*/

  }

}
