package de.ukt.medic.fhir.profiling;


import java.util.Optional;
import org.hl7.fhir.r4.model.Coding;


/**
 * Coding specialization to enforce that at least "code" and "system" be defined 
 */
public record QualifiedCoding
(
  String code,
  String system,
  Optional<String> display,
  Optional<String> version
)
{ 

  public static QualifiedCoding of(
    String code,
    String system
  ){ 
    return new QualifiedCoding(
      code,
      system,
      Optional.empty(),
      Optional.empty()
    );
  }

  public Coding coding(){

    var coding = new Coding().setCode(code).setSystem(system);
    display.ifPresent(coding::setDisplay);
    version.ifPresent(coding::setVersion);

    return coding;
  }

}
