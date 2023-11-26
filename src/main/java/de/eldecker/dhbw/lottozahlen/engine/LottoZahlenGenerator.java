package de.eldecker.dhbw.lottozahlen.engine;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Klasse für das "Auswürfen" eines Lottozahlen-Tipp für "6 aus 49"
 * (deutsches Zahlenlotto).
 */
public class LottoZahlenGenerator {

    /** Konstante für größte Lottozahl (entspricht Anzahl der zur Auswahl stehenden Zahlen). */
    public static final int MAX_LOTTOZAHL = 49;
    
    /** Konstante für Anzahl der Zahlen, die für einen Tipp auszuwählen sind. */
    public static final int TIPP_ANZAHL = 6;
    
 
    
    /**
     * Zahlentipp für Lotto erzeugen.
     * 
     * @return Array mit Lotto-Tipp, enthält 6 Zahlen aufsteigend
     *         sortiert.
     */
    public static int[] erzeugeTipp() {
        
        LottoZahlRecord[] alleLottozahlenArray = new LottoZahlRecord[MAX_LOTTOZAHL];
        for (int i = 0; i < MAX_LOTTOZAHL; i++) {
            
            double zufallszahl = Math.random(); // erzeugt Zufallszahl im Bereich [0.0; 1.0)
            alleLottozahlenArray[i] = new LottoZahlRecord(i+1, zufallszahl);
        }
        
        Arrays.sort(alleLottozahlenArray, 
                    Comparator.comparingDouble(LottoZahlRecord::zufallszahl));
        
        int[] ergebnisArray = new int[TIPP_ANZAHL];
        for (int i = 0; i < TIPP_ANZAHL; i++) {
            
            ergebnisArray[i] = alleLottozahlenArray[i].lottozahl();
        }
        
        Arrays.sort(ergebnisArray);
        
        return ergebnisArray;
    }
    
}
