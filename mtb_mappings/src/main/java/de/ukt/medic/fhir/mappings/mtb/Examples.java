package de.ukt.medic.fhir.mappings.mtb;

import java.time.YearMonth;
import java.util.Map;
import java.util.Optional;
import scala.Enumeration;
import de.dnpm.dip.coding.Coding;
import de.dnpm.dip.model.Gender$;
import de.dnpm.dip.mtb.model.MTBDiagnosis;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Resource;
import de.ukt.medic.fhir.profiling.LiteralRef;
import de.ukt.medic.fhir.profiling.QualifiedCoding;
import de.ukt.medic.fhir.profiles.mtb.examples.PseudonymizedPatient;
import de.ukt.medic.fhir.profiles.mtb.examples.TumorDiagnosis;


abstract class Examples
{

  // Converter of scala.Option to java.util.Optional
  private static <T> Optional<T> toJava(scala.Option<T> option){
    return scala.jdk.javaapi.OptionConverters$.MODULE$.toJava(option);
  }


  public static final <E extends Enumeration> Enumeration.Value enumValue(
          E e,
          Coding coding
  ){
    return e.withName(String.valueOf(coding.code()));
  }


  public static final Map<Enumeration.Value,AdministrativeGender> ADMINISTRATIVE_GENDER =
          Map.of(
                  Gender$.MODULE$.Male(),    AdministrativeGender.MALE,
                  Gender$.MODULE$.Female(),  AdministrativeGender.FEMALE,
                  Gender$.MODULE$.Other(),   AdministrativeGender.OTHER,
                  Gender$.MODULE$.Unknown(), AdministrativeGender.UNKNOWN
          );


  public static <T> QualifiedCoding toCoding(Coding<T> coding){
    return new QualifiedCoding(
            String.valueOf(coding.code()),
            coding.system().toString(),
            toJava(coding.display()),
            toJava(coding.version())
    );
  }


  public static <T, R extends Resource> LiteralRef<R> toLiteralRef(
          de.dnpm.dip.model.Reference<T> ref
  ){
    return new LiteralRef<R>(ref.id().value());
  }


  public static PseudonymizedPatient toFHIR(de.dnpm.dip.model.Patient patient){

    return PseudonymizedPatient.of(
            patient.id().value(),
            ADMINISTRATIVE_GENDER.get(enumValue(Gender$.MODULE$,patient.gender())),
            patient.birthDate(),
            toJava(patient.dateOfDeath()).map(YearMonth::atEndOfMonth)
    );

  }


  public static TumorDiagnosis toFHIR(MTBDiagnosis diag){

    return TumorDiagnosis.of(
            diag.id().value(),
            toLiteralRef(diag.patient()),
            diag.recordedOn(),
            toCoding(diag.code()),
            Optional.of(toCoding(diag.topography()))
    );

  }

}
