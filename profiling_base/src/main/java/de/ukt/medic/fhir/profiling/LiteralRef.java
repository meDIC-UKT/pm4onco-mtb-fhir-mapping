package de.ukt.medic.fhir.profiling;


import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;


public record LiteralRef<T extends Resource>(String uri) implements Ref<T>
{

  @Override
  public Reference reference(){
    return new Reference(uri);
  }


}
