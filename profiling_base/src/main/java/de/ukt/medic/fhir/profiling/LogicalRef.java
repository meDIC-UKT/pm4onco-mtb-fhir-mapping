package de.ukt.medic.fhir.profiling;


import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;


public record LogicalRef<T extends Resource>(
  Identifier identifier
)
implements Ref<T>
{
  @Override
  public Reference reference(){
    return new Reference().setIdentifier(identifier);
  }
}
