package de.eldecker.dhbw.lottozahlen.test.suites;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectMethod;
import org.junit.platform.suite.api.Suite;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;
import de.eldecker.dhbw.lottozahlen.engine.model.LottoException;
import de.eldecker.dhbw.lottozahlen.test.alle.DeutschesLottoTest;
import de.eldecker.dhbw.lottozahlen.test.alle.ItalLottoTest;


/**
 * Diese Test-Suite enthält nur die Unit-Test-Methoden, die die richtige
 * Anzahl der Zahlen im erzeugten Lotto-Tipp überprüfen. Da mit der
 * Annotation {@code SelectionMethod} die Klassen mit den Methoden
 * angegeben werden, muss auf die Annotation {@code SelectPackages}
 * verzichtet werden.
 */
@Suite
@SelectMethod(type = DeutschesLottoTest.class, name = "richtigeAnzahl")
@SelectMethod(type = ItalLottoTest.class     , name = "richtigeAnzahl")
public class RichtigeAnzahlTestSuite {
    
    /**
     * Normalerweise enthalten Test-Suite-Klassen keine eigenen Unit-Test-Methoden,
     * es ist aber möglich. Diese Test-Methode führt einen Test für schwedisches
     * Lotto "7 aus 35" aus.
     */
    @Test
    void richtigeAnzahlSchwedischesLotto() throws LottoException {
        
        LottoZahlenGenerator cut = new LottoZahlenGenerator( 7, 35, 424242 );
        
        assertEquals( 7, cut.erzeugeTipp().length );
    }
}
