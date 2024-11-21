package de.eldecker.dhbw.lottozahlen.test.alle;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;
import de.eldecker.dhbw.lottozahlen.engine.model.LottoException;


/**
 * Diese Klasse enthält Testmethode, die überprüfen, ob der Konstruktor der Klasse
 * unter Test bei unsinnigen Parametern eine Exception wirft.
 * <br><br>
 * 
 * Die Testklasse hat eine Annotation für einen {@code DisplayName}. Der damit
 * spezifizierte Anzeigename wird im Eclipse-View "JUnit" verwendet.
 */
@DisplayName("Ausnahme-Tests")
public class LottoZahlenExceptionTest {
    
    @Test
    @Tag("wichtig")
    void maxLottoZahlZuKlein() {

        assertThrows( LottoException.class, () -> {
            
            new LottoZahlenGenerator( 1, 1 ); // "1 aus 1"
        });        
    }

    @Test
    @Tag("wichtig")
    void anzahlZahlenZuKlein() {
        
        final int anzahlZahlen = 0;
        
        Throwable ex = assertThrows( LottoException.class, () -> {
            
            new LottoZahlenGenerator( anzahlZahlen, 49); // "0 aus 49"
        });        
        
        assertTrue( ex.getMessage().contains( anzahlZahlen + "" ) );
    }
    
    @Test
    void maxZahlGleichAnzahlZahlen() {
        
        final int zahl = 20;
        
        assertThrows( LottoException.class, () -> {
            
            new LottoZahlenGenerator( zahl, zahl ); // "20 aus 20"
        });         
    }
    
    @Test
    void maxZahlKleinerAnzahl() {

        assertThrows( LottoException.class, () -> {
            
            new LottoZahlenGenerator( 12, 10 ); // "12 aus 10"
        });         
    }

    @Test
    void maxZahlNegativ() {

        assertThrows( LottoException.class, () -> {
            
            new LottoZahlenGenerator( 12, -10 ); // "12 aus -10"
        });         
    }
    
    @Test
    void anzahlZahlenNegative() {

        assertThrows(LottoException.class, () -> {
            
            new LottoZahlenGenerator( -6, 49 ); // "-6 aus 49"
        });         
    }

}