package de.ukt.medic.fhir.profiling;


import java.util.Optional;
import org.hl7.fhir.r4.model.Coding;


/**
 * A type-safe wrapper for FHIR Coding that enforces required fields.
 *
 * <p>This record enforces that at least "code" and "system" are always defined,
 * addressing a limitation of HAPI-FHIR's Coding class which allows these essential
 * fields to be empty. This ensures that Coding instances are always in a valid,
 * well-defined state.</p>
 *
 * <p>The display and version fields are optional and represented using Optional&lt;String&gt;
 * to explicitly indicate their optionality at the type level.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * // Create a simple coding with just code and system
 * QualifiedCoding coding = QualifiedCoding.of("89262-0", "http://loinc.org");
 *
 * // Create a full coding with all fields
 * QualifiedCoding fullCoding = new QualifiedCoding(
 *     "89262-0",
 *     "http://loinc.org",
 *     Optional.of("ECOG Performance Status"),
 *     Optional.of("2.73")
 * );
 * }</pre>
 *
 * @param code the code value (required)
 * @param system the code system URI (required)
 * @param display optional human-readable representation of the code
 * @param version optional version of the code system
 */
public record QualifiedCoding
(
  String code,
  String system,
  Optional<String> display,
  Optional<String> version
)
{ 

  /**
   * Factory method to create a QualifiedCoding with only code and system.
   *
   * <p>This is a convenience method for creating codings when display and version
   * information is not available or not needed.</p>
   *
   * @param code the code value
   * @param system the code system URI
   * @return a new QualifiedCoding with empty display and version
   */
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

  /**
   * Converts this QualifiedCoding to a HAPI-FHIR Coding object.
   *
   * <p>This method creates a new Coding instance and populates it with all
   * available fields from this QualifiedCoding. Optional fields (display and version)
   * are only set if they contain values.</p>
   *
   * @return a new HAPI-FHIR Coding object with the same values as this QualifiedCoding
   */
  public Coding coding(){

    var coding = new Coding().setCode(code).setSystem(system);
    display.ifPresent(coding::setDisplay);
    version.ifPresent(coding::setVersion);

    return coding;
  }

}
