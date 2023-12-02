package de.eldecker.dhbw.lottozahlen.engine;

/**
 * Eigene Exception-Klasse für Lottozahlengenerator.
 * Die Exception soll z.B. geworfen werden, wenn die Höchstzahl kleiner als die
 * Anzahl der zu ziehenden Zahlen ist.
 */
@SuppressWarnings("serial")
public class LottoException extends Exception {

    /**
     * Konstruktor um Exception mit Fehlerbeschreibung zu erzeugen.
     * 
     * @param nachricht Beschreibung des Fehlers 
     */
    public LottoException(String nachricht) {
        
        super(nachricht);
    }
}
