package de.eldecker.dhbw.lottozahlen.test.alle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;
import de.eldecker.dhbw.lottozahlen.engine.model.LottoException;

/**
 * Tests für deutsches Zahlenlotto "6 aus 49".
 */
public class DeutschesLottoTest {
    
    private static final int ANZAHL_ZAHLEN = 6;
    private static final int MAX_ZAHL      = 49;

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
         
        _cut = new LottoZahlenGenerator( ANZAHL_ZAHLEN, MAX_ZAHL, 1234 );
    }
    
    @Test
    @Tag("wichtig")
    void richtigeAnzahl() {
        
        int[] tippArray = _cut.erzeugeTipp(); // Aufruf Methode unter Test
        
        assertEquals( ANZAHL_ZAHLEN, tippArray.length );
    }
    
    /**
     * Mit einem {@code Set}-Objekt (math. Menge) wird überprüft, ob jede 
     * Ergebniszahl höchstens einmal im Ergebnis enthalten ist (ein {@code Set}
     * kann jedes Element höchstens einmal enthalten). 
     */    
    @Test
    @Tag("wichtig")
    @Tag("nochEinTag")
    void keineMehrfachenZahlen() {
        
        int[] tippArray = _cut.erzeugeTipp(); // Aufruf Methode unter Test
        
        Set<Integer> intSet = arrayToSet( tippArray );

        assertEquals( ANZAHL_ZAHLEN, intSet.size() );
    }
    
    @Test
    void aufsteigendeReihenfolge() {

        int[] ergebnisArray = _cut.erzeugeTipp(); // Aufruf Methode unter Test

        int maxZahl = -1;
        for ( int zahl : ergebnisArray ) {
            
            if ( maxZahl == -1 ) {
                
                assertTrue( zahl >= 1 );
            }
             
            assertTrue( zahl > maxZahl ); // Check für Sortierreihenfolge
            maxZahl = zahl;
        }
        
        assertTrue( maxZahl <= MAX_ZAHL );
     }    
    
    /**
     * Hilfsmethode (keine Unit-Test-Methode!), wandelt int-Array in {@code Set<Integer>}
     * um, wobei evtl. mehrfach vorhandene Zahlen verloren gehen.
     */
    private Set<Integer> arrayToSet(int[] intArray) {
        
        Set<Integer> intSet = new HashSet<>( ANZAHL_ZAHLEN );
        for ( int wert : intArray ) {
            
            intSet.add(wert);
        }
        
        return intSet;
    }

}
