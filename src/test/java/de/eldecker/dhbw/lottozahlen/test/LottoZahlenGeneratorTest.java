package de.eldecker.dhbw.lottozahlen.test;

import static de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator.TIPP_ANZAHL;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    
    @ParameterizedTest
    @ValueSource(ints = { 10, 42, 123, 1024 })
    void richtigeAnzahl(int seed) {
    
        LottoZahlenGenerator.setSeedFuerZufallsgenerator(seed);
        
        int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp(); // Aufruf Methode unter Test
        
        assertEquals(TIPP_ANZAHL, ergebnisArray.length); 
    }
    

    @ParameterizedTest
    @ValueSource(ints = { 10, 42, 123, 1024 })
    void keineMehrfachenZahlen(int seed) {

        LottoZahlenGenerator.setSeedFuerZufallsgenerator(seed);
        

        int[] ergebnisArray = LottoZahlenGenerator.erzeugeTipp(); // Aufruf Methode unter Test
        
        // ein Set (Menge) kann jedes Element höchstens einmal enthalten;
        // wenn also ein Wert mehrfach enthalten wäre, dann hätte das
        // Set weniger Elemente als TIPP_ANZAHL        
        Set<Integer> intSet = new HashSet<>(TIPP_ANZAHL);
        for (int wert : ergebnisArray) {
            
            intSet.add(wert);
        }
        
        assertEquals(TIPP_ANZAHL, intSet.size());                         
    }
        
}