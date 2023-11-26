package de.eldecker.dhbw.lottozahlen.engine;

/**
 * Ein Objekt dieses Records repräsentiert eine der Lottozahlen von 1-49 zusammen
 * mit einer Zufallszahl. Die Zufallszahl wird für die zufällige Sortierreihenfolge
 * benötigt.
 * 
 * @param lottozahl   Zahl von 1-49
 * @param zufallszahl Zufallszahl für zufällige Sortierreihenfolge
 */
public record LottoZahlRecord(int lottozahl, double zufallszahl) {}
