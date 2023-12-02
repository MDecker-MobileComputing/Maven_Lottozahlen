package de.eldecker.dhbw.lottozahlen.engine.model;

/**
 * Ein Objekt dieses Records repräsentiert eine der Lottozahlen zusammen mit  
 * einer Zufallszahl. Die Zufallszahl wird für die zufällige Sortierreihenfolge
 * benötigt.
 * 
 * @param lottozahl   Eine Zahl von 1..MAX_ZAHL, z.B. 49 für deutsches Zahlenlotto "6 aus 49"
 * @param zufallszahl Zufallszahl für zufällige Sortierreihenfolge
 */
public record LottoZahlRecord(int lottozahl, double zufallszahl) {}
