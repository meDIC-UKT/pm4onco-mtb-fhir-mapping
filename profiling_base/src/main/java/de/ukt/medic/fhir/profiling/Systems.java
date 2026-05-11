package de.ukt.medic.fhir.profiling;


/**
 * Utility class providing constants for commonly used medical terminology system URIs.
 *
 * <p>This class provides canonical URIs for standard medical coding systems used in FHIR
 * resources. These URIs are used in the 'system' field of Coding and CodeableConcept
 * elements to identify which coding system a code belongs to.</p>
 *
 * <p>This class cannot be instantiated as it only provides static constants.</p>
 */
public abstract class Systems
{

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private Systems(){}


  /**
   * The canonical URI for the LOINC (Logical Observation Identifiers Names and Codes) system.
   * LOINC is a database and universal standard for identifying medical laboratory observations.
   */
  public static final String LOINC = "http://loinc.org";

  /**
   * The canonical URI for the SNOMED CT (Systematized Nomenclature of Medicine - Clinical Terms) system.
   * SNOMED CT is a comprehensive clinical terminology and coding system for healthcare.
   */
  public static final String SNOMEDCT = "http://snomed.info/sct";

}
