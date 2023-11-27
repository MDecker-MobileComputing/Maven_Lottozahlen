package de.eldecker.dhbw.lottozahlen.test;

import static de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator.TIPP_ANZAHL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;


public class LottoZahlenGeneratorTest {
        
    @BeforeEach
    void prepareBeforeEachUnitTest() {
        
        LottoZahlenGenerator.setSeedFuerZufallsgenerator(123);
    }
    
    @Test
    void richtigeAnzahl() {
    
        int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp();
        assertEquals(TIPP_ANZAHL, ergebnisArray.length, 
                     "Ergebnis-Array hat nicht erwartete Länge");
    }
    
    
}