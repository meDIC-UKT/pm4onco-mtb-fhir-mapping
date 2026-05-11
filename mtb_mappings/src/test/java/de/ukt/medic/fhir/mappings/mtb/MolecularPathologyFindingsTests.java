package de.ukt.medic.fhir.mappings.mtb;

import de.dnpm.dip.mtb.gens.Generators$;
import de.dnpm.dip.mtb.model.Completers$;
import de.dnpm.dip.mtb.model.MTBPatientRecord;
import de.dnpm.dip.util.Completer;
import de.ekut.tbi.generators.Gen;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scala.util.Random;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;


public class MolecularPathologyFindingsTests {

        private static final Random RND = new Random();
        private static final Gen<MTBPatientRecord> PATIENT_RECORDS = Generators$.MODULE$.genPatientRecord();
        public static final Completer<MTBPatientRecord> PATIENT_RECORD_COMPLETER = Completers$.MODULE$.mtbPatientRecordCompleter();
        private static MTBPatientRecord patientRecord;
        private static List<MTBPatientRecord> patientRecords;

        @BeforeAll
        static void init(){

            // System property to configure the local site running DIP components,
            // required among others to initialize the local/managing site in Patient objects
            System.setProperty("dnpm.dip.site","UKx:Musterhausen");


            // Here how to get a generated DTO instance...
            patientRecord = PATIENT_RECORDS.next(RND);

            // ... or how to get a whole List of generated DTO instances.
            patientRecords =
                    Stream.generate(() -> PATIENT_RECORDS.next(RND))
                            .limit(42)
                            .map(PATIENT_RECORD_COMPLETER::apply) // Apply the Completer<MTBPatientRecord> to each
                            .collect(toList());
        }


        @Test
        public void testMolecularPathology(){

            // todo: test DNPM MolecularPathologyFindings to FHIR

        }

}
