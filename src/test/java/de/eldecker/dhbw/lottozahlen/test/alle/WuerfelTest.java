package de.eldecker.dhbw.lottozahlen.test.alle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;
import de.eldecker.dhbw.lottozahlen.engine.model.LottoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * Der Lottozahlengenerator kann auch zur Simulation eines Würfels
 * (z.B. Standardwürfel mit 6 Seiten) verwendet werden.
 */
public class WuerfelTest {

    private static final int MAX_WUERFEL_AUGEN = 6;

    /** Class under Test. */
    private LottoZahlenGenerator _cut;

    @ParameterizedTest
    @ValueSource(ints = { 1, 10, 20, 40, 80, 160 })
    void wuerfeln(int seed) throws LottoException {

        _cut = new LottoZahlenGenerator( 1, MAX_WUERFEL_AUGEN );

        int[] ergebnisArray = _cut.erzeugeTipp(); // Methode unter Test

        assertEquals( 1, ergebnisArray.length );
        assertTrue( ergebnisArray[0] >= 1 );
        assertTrue( ergebnisArray[0] <= 6 );
    }

}