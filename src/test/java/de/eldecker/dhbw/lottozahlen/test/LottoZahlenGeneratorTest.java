package de.eldecker.dhbw.lottozahlen.test;

import static de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator.TIPP_ANZAHL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;


public class LottoZahlenGeneratorTest {
        
    /**
     * Reihenfolge der Testausführung ist nicht deterministisch, deshalb
     * vor jeder Testmethode den Zufallsgenerator neu initialisieren.
     */
    @BeforeEach
    void prepareBeforeEachUnitTest() {
        
        LottoZahlenGenerator.setSeedFuerZufallsgenerator(123);
    }
    
    @Test
    void richtigeAnzahl() {
    
        for (int i = 1; i <= 10; i++) {

            int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp();
            assertEquals(TIPP_ANZAHL, ergebnisArray.length, 
                         "Ergebnis-Array hat nicht erwartete Länge in Durchlauf " + i);
        }
    }
    
    @Test
    void keineDoppeltenZahl() {

        for (int i = 1; i <= 10; i++) {

            int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp();
            
            Set<Integer> intSet = new HashSet<>(TIPP_ANZAHL);
            for (int wert : ergebnisArray) {
                intSet.add(wert);
            }
            
            assertEquals(TIPP_ANZAHL, intSet.size(),
                         "Ergebnis-Array hat mehrfache Einträge in Durchlauf " + i);
        }
    }
    
    
}