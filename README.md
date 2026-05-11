# PM4Onco MTB FHIR Profiles and Mappings

Multi-module project for molecular tumor board (MTB) FHIR profiles and mappings according to MII (Medizininformatik-Initiative) specifications.

## Modules

* **`profiling_base`**: Base components to create profiled HAPI FHIR resources
* **`mtb_profiles`**: MTB FHIR Profiles organized by functional domain
* **`mtb_mappings`**: Mappings from DNPM MTB model onto FHIR profiles from `mtb_profiles`

## MTB Profiles Package Structure

The `mtb_profiles` module is organized into four functional packages:

### 1. Clinical Package (`mtb.clinical`)
Core clinical patient data and diagnoses:
- **PseudonymizedPatient** - Patient with pseudonymized identifiers
- **TumorDiagnosis** - Primary tumor diagnosis with ICD-10-GM and ICD-O-3 codes
- **TumorMorphology** - Histological type and tumor grade
- **TNMClassification** - Cancer staging
- **ECOGStatus** - Performance status assessment
- **TumorSpecimen** - Tumor tissue samples
- **BiopsyProcedure** - Biopsy procedures
- **MolecularTherapy** - Systemic therapy administration
- **MTBRecommendation** - MTB therapy recommendations
- **HistopathologyReport** - Histopathology diagnostic reports
- **MTBPatientRecord** - Complete patient bundle

### 2. NGS Package (`mtb.ngs`)
Next-generation sequencing molecular findings:
- **NGSReport** - Main NGS diagnostic report
- **GenomicStudy** - Overall sequencing procedure
- **GenomicStudyAnalysis** - Bioinformatics analysis
- **GeneticVariant** - SNVs and InDels with HGVS notation
- **CopyNumberVariant** - CNVs with copy number and log2 ratio
- **DNAFusion** - DNA-level gene fusions
- **RNAFusion** - RNA fusion transcripts
- **TMBStatus** - Tumor Mutational Burden
- **MSIStatus** - Microsatellite Instability
- **HRDScore** - Homologous Recombination Deficiency
- **BRCAness** - BRCAness phenotype
- **RNASeq** - Gene expression quantification
- **MolecularBiomarker** - General biomarker profile
- **DiagnosticImplication** - Diagnostic/prognostic significance
- **TherapeuticImplication** - Treatment recommendations with evidence levels

### 3. Pathology Package (`mtb.pathology`)
Molecular pathology assessments:
- **MolecularPathologyReport** - Aggregates IHC/ISH results
- **Immunohistochemistry** - Base IHC profile with scoring
- **PImmunhistochemistry** - Phospho-protein IHC
- **IHC_HER2** - HER2 IHC with ASCO/CAP scoring
- **IHC_MMR_MSI** - MMR panel for Lynch syndrome
- **IHC_PDL1** - PD-L1 IHC with TPS/CPS
- **InSituHybridization** - FISH/CISH/SISH for gene amplification

### 4. Behandlungsepisode Package (`mtb.behandlungsepisode`)
MTB treatment episode and recommendations:

#### Core Episode
- **Behandlungsepisode** - Main MTB consultation episode (ClinicalImpression)

#### Clinical Assessments
- **DiagnosePrimaertumor** - Primary tumor diagnosis (Condition)
- **Tumorausbreitung** - Metastatic disease sites
- **WHOGradZNS** - WHO CNS tumor grading
- **OncoTree** - OncoTree tumor classification
- **ProbeTumorzellgehalt** - Tumor cell content in specimen
- **MTBConsent** - Patient consent for MTB evaluation

#### Treatment History
- **SystemischeVortherapie** - Prior systemic therapies

#### MTB Recommendations
- **Therapieempfehlung** - Individual therapy recommendation (Medication)
- **KombinationstherapieEmpfehlung** - Combination therapy recommendation (RequestGroup)
- **StudieneinschlussAnfrage** - Clinical trial enrollment recommendation (ServiceRequest)
- **StudienanschlussStudie** - Clinical trial details (ResearchStudy)

#### Additional Recommendations
- **BiopsieAuftrag** - Biopsy procedure recommendation
- **HumangenetischeBeratung** - Genetic counseling referral
- **HistologieEvaluation** - Histology re-evaluation request

#### Extensions
- **PublicationExtension** - Reference to supporting literature (PMID, DOI)
- **EvidenzgraduierungExtension** - Evidence level grading (ESCAT, OncoKB, AMP/ASCO/CAP)
- **PrioritaetExtension** - Priority ranking for recommendations

## Pipeline

┌─────────────────────────────┐
│  Source: DIP MTB Model      │
│  (de.dnpm.dip.model.*)      │
│                             │
│  Example: MTBDiagnosis      │
│  - Scala types              │
│  - Scala Option             │
│  - Scala Enumerations       │
└──────────────┬──────────────┘
│
▼
┌─────────────────────────────┐
│  Mapping Layer              │
│  (Examples.java)            │
│                             │
│  • toFHIR(MTBDiagnosis)     │
│    ├─ Extract fields        │
│    ├─ Convert Scala→Java    │
│    ├─ Map Codings           │
│    └─ Map References        │
└──────────────┬──────────────┘
│
▼
┌─────────────────────────────┐
│  Profile Builder            │
│  (TumorDiagnosis.of(...))   │
│                             │
│  • Validates constraints    │
│  • Builds FHIR structure    │
└──────────────┬──────────────┘
│
▼
┌─────────────────────────────┐
│  FHIR R4 Resource           │
│  (TumorDiagnosis extends    │
│   Condition)                │
│                             │
│  Ready for transmission     │
└─────────────────────────────┘


## Example Usage

```java
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
```

## Standards and References

- [MII Onkologie Module](https://simplifier.net/medizininformatikinitiative-modulonkologie)
- [FHIR R4 Specification](https://www.hl7.org/fhir/R4/)
- [HAPI FHIR Library](https://hapifhir.io/)
- [ESCAT Evidence Framework](https://www.esmo.org/guidelines/precision-medicine/esmo-scale-for-clinical-actionability-of-molecular-targets)
- [OncoKB Levels of Evidence](https://www.oncokb.org/levels)

