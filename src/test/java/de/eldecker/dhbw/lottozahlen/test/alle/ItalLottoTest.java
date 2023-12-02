package de.eldecker.dhbw.lottozahlen.test.alle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.eldecker.dhbw.lottozahlen.engine.LottoException;
import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;

/**
 * Test für italienisches Zahlenlotto "6 aus 90".
 */
public class ItalLottoTest {

    private static final int ANZAHL_ZAHLEN = 6;
    private static final int MAX_ZAHL      = 90;

    /** Class under Test. */
    private LottoZahlenGenerator _cut;
    
    /**
     * Vor jeden Unit-Test-Methode wird ein neues Objekt der CUT
     * (mit frisch initialisiertem Testdatengenerator) erzeugt.
     * Da jede Testmethode nur einmal die Methode {@code erzeugeTipp()}
     * aufruft, gibt diese Methode in jeder Testmethode dieselbe
     * Zahlenfolge zurück.
     */
    @BeforeEach
    void vorJederTestMethodeVorbereiten() throws LottoException {
         
        _cut = new LottoZahlenGenerator(ANZAHL_ZAHLEN, MAX_ZAHL, 1234);
    }
    
    @Test
    void richtigeAnzahl() {
        
        int[] tippArray = _cut.erzeugeTipp(); // Aufruf Methode unter Test
        
        assertEquals(ANZAHL_ZAHLEN, tippArray.length);
    }
    
}
