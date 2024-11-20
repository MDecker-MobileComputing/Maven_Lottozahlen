package de.eldecker.dhbw.lottozahlen.engine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

import de.eldecker.dhbw.lottozahlen.engine.model.LottoException;
import de.eldecker.dhbw.lottozahlen.engine.model.LottoZahlRecord;


/**
 * Klasse für das "Auswürfeln" eines Lottozahlen-Tipp für verschiedene Lottosysteme.
 * <br><br>
 *
 * Für Tabelle mit verschiedenen Lottosystemen in verschiedenen Ländern siehe
 * <a href="https://de.wikipedia.org/wiki/Lotto#Lottosysteme">diese Wikipedia-Seite</a>.
 */
public class LottoZahlenGenerator {

    /** Zufallszahlengenerator. */
    private Random _zufallsgenerator = null;

    /** Anzahl Zahlen für den zu erzeugenden Tipp, z.B. "6" für deutsches Zahlenlotto "6 aus 49". */
    private int _anzahlLottoZahlen;

    /** Höchste Zahl im Lottosystem, z.B. "49" für deutsches Zahlenlotto "6 aus 49". */
    private int _maxLottoZahl;


    /**
     * Hauptkonstruktor, erzeugt Lottozahlengenerator für bestimmtes Lottosystem, z.B. "6 aus 49" (Deutschland)
     * oder "6 aus 90" (Italien, SuperEnalotto).
     *
     * @param anzahlLottoZahlen  Anzahl der Zahlen im Tipp, z.B. "6" bei deutschem Zahlenlotto "6 aus 49";
     *                           muss mindestens 1 sein
     *
     * @param maxLottoZahl       Höchste Lottozahl, z.B. "49" bei deutschem Zahlenlotto "6 aus 49";
     *                           muss mindestens 6 sein
     *
     * @param initWertFuerZufall Initialwert für Zufallsgenerator ("Seed")
     *
     * @throws LottoException    Ungültige Werte für {@code anzahlLottoZahlen} oder {@code maxLottoZahl}
     */
    public LottoZahlenGenerator( int anzahlLottoZahlen, int maxLottoZahl, long initWertFuerZufall ) throws LottoException {

        if (anzahlLottoZahlen < 1) {

            throw new LottoException( "anzahlLottoZahlen=" + anzahlLottoZahlen + " ist zu klein" );
        }
        if (maxLottoZahl < 6) {

            throw new LottoException( "maxLottoZahl=" + maxLottoZahl + " ist zu klein" );
        }

        if (maxLottoZahl <= anzahlLottoZahlen) {

           throw new LottoException( "MaxLottoZahl=" + maxLottoZahl + " <= anzahlLottoZahlen=" + anzahlLottoZahlen );
        }

        _anzahlLottoZahlen = anzahlLottoZahlen;
        _maxLottoZahl      = maxLottoZahl;

        _zufallsgenerator = new Random(initWertFuerZufall);
    }


    /**
     * Convience-Konstruktor, siehe Beschreibung von {@link #LottoZahlenGenerator(int, int, long)}.
     * 
     * @param anzahlLottoZahlen  Anzahl der Zahlen im Tipp, z.B. "6" bei deutschem Zahlenlotto "6 aus 49";
     *                           muss mindestens 1 sein
     *
     * @param maxLottoZahl  Höchste Lottozahl, z.B. "49" bei deutschem Zahlenlotto "6 aus 49";
     *                      muss mindestens 6 sein
     *                      
     * @throws LottoException  Ungültige Werte für {@code anzahlLottoZahlen} oder {@code maxLottoZahl}                      
     */
    public LottoZahlenGenerator( int anzahlLottoZahlen, int maxLottoZahl ) throws LottoException {

        this( anzahlLottoZahlen, 
        	  maxLottoZahl, 
        	  new Date().getTime() 
        	);
    }


    /**
     * Zahlentipp für Lotto erzeugen.
     *
     * @return Array mit Lotto-Tipp (aufsteigend sortiert)
     */
    public int[] erzeugeTipp() {

        LottoZahlRecord[] alleLottozahlenArray = new LottoZahlRecord[ _maxLottoZahl ];
        for ( int i = 0; i < alleLottozahlenArray.length; i++ ) {

            double zufallszahl = _zufallsgenerator.nextDouble(); // erzeugt Zufallszahl im Bereich [0.0; 1.0)
            alleLottozahlenArray[i] = new LottoZahlRecord( i+1, zufallszahl );
        }

        Comparator<LottoZahlRecord> comparator = Comparator.comparingDouble( LottoZahlRecord::zufallszahl );
        Arrays.sort( alleLottozahlenArray, comparator );

        int[] ergebnisArray = new int[ _anzahlLottoZahlen ];
        for (int i = 0; i < _anzahlLottoZahlen; i++) {

            ergebnisArray[i] = alleLottozahlenArray[i].lottozahl();
        }

        Arrays.sort(ergebnisArray);

        return ergebnisArray;
    }


    /**
     * Getter für höchste Lottozahl des Lottosystems, für den das aufrufende Objekt erzeugt wurde.
     *
     * @return Höchste Lottozahl, z.B. "49" für deutsches Lotto "6 aus 49"
     */
    public int getMaxZahl() {

        return _maxLottoZahl;
    }


    /**
     * Getter für Anzahl der Zahlen in einem gültigen Tipp für das Lottosystem, für den das
     * aufrufende Objekt erzeugt wurde.
     *
     * @return Höchste Lottozahl, z.B. "6" für deutsches Lotto "6 aus 49"
     */
    public int getAnzahl() {

        return _anzahlLottoZahlen;
    }

}
