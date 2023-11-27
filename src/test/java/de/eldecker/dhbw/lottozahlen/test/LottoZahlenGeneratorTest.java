package de.eldecker.dhbw.lottozahlen.test;

import static de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator.MAX_LOTTOZAHL;
import static de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator.TIPP_ANZAHL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Am Anfang jeder Testmethode wird der Zufallszahlengenerator mit einem definierten
 * Wert ("Seed") initialisiert, damit die Testläufe reproduzierbar sind.
 */
public class LottoZahlenGeneratorTest {

    /**
     * Überprüft, ob Ergebnis-Array die korrekte Anzahl an Elementen enthält. 
     * 
     * @param seed Initialwert für Zufallsgenerator
     */
    @ParameterizedTest
    @ValueSource(ints = { 10, 42, 123, 1024 })
    void richtigeAnzahl(int seed) {
    
        LottoZahlenGenerator.setSeedFuerZufallsgenerator(seed);
        
        int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp(); // Aufruf Methode unter Test
        
        assertEquals(TIPP_ANZAHL, ergebnisArray.length); 
    }
    

    /**
     * Mit einem {@code Set}-Objekt (math. Menge) wird überprüft, ob jede 
     * Ergebniszahl höchstens einmal im Ergebnis enthalten ist (ein {@code Set}
     * kann jedes Element höchstens einmal enthalten). 
     * 
     * @param seed Initialwert für Zufallsgenerator
     */
    @ParameterizedTest
    @ValueSource(ints = { 10, 42, 123, 1024 })
    void keineMehrfachenZahlen(int seed) {

        LottoZahlenGenerator.setSeedFuerZufallsgenerator(seed);
        
        int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp(); // Aufruf Methode unter Test
        
        Set<Integer> intSet = new HashSet<>(TIPP_ANZAHL);
        for (int wert : ergebnisArray) {
            
            intSet.add(wert);
        }
        
        assertEquals(TIPP_ANZAHL, intSet.size());                         
    }

    /**
     * Überprüft, ob die Ergebniswerte aufsteigend sortiert sind.
     * Es wird auch überprüft, dass sich die Ergebniswerte im zulässigen
     * Bereich befinden.
     * 
     * @param seed Initialwert für Zufallsgenerator
     */
    @ParameterizedTest
    @ValueSource(ints = { 10, 42, 123, 1024 })
    void aufsteigendeReihenfolge(int seed) {

       LottoZahlenGenerator.setSeedFuerZufallsgenerator(seed);
       
       int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp(); // Aufruf Methode unter Test

       int maxZahl = -1;
       for (int zahl : ergebnisArray) {
           
           if (maxZahl == -1) {
               
               assertTrue( zahl >= 1 );
           }
           
           assertTrue( zahl > maxZahl ); // Check für Sortierreihenfolge
           maxZahl = zahl;
       }
       
       assertTrue( maxZahl <= MAX_LOTTOZAHL );
    }
        
}