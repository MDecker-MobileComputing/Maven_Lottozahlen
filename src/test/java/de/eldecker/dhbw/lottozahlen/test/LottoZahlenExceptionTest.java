package de.eldecker.dhbw.lottozahlen.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.eldecker.dhbw.lottozahlen.engine.LottoException;
import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;

/**
 * Diese Klasse enthält Testmethode, die überprüfen, ob der Konstruktor der Klasse
 * unter Test bei unsinnigen Parametern eine Exception wirft.
 */
public class LottoZahlenExceptionTest {
    
    @Test
    void maxLottoZahlZuKlein() {

        final int maxZahl = 1;
        
        Throwable ex = assertThrows(LottoException.class, () -> {
            
            new LottoZahlenGenerator(1, maxZahl); // "1 aus 1"
        });        
        
        assertTrue( ex.getMessage().contains(maxZahl + "") );
    }

    @Test
    void anzahlZahlenZuKlein() {
        
        final int anzahlZahlen = 0;
        
        Throwable ex = assertThrows(LottoException.class, () -> {
            
            new LottoZahlenGenerator(anzahlZahlen, 49); // "0 aus 49"
        });        
        
        assertTrue( ex.getMessage().contains(anzahlZahlen + "") );
    }
    
    @Test
    void maxZahlGleichAnzahlZahlen() {
        
        final int zahl = 20;
        
        assertThrows(LottoException.class, () -> {
            
            new LottoZahlenGenerator(zahl, zahl); // "20 aus 20"
        });         
    }
    
    @Test
    void maxZahlKleinerAnzahl() {

        assertThrows(LottoException.class, () -> {
            
            new LottoZahlenGenerator(12, 10); // "12 aus 10"
        });         
    }

}