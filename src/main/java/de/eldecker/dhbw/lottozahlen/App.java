package de.eldecker.dhbw.lottozahlen;

import de.eldecker.dhbw.lottozahlen.engine.LottoZahlenGenerator;
import de.eldecker.dhbw.lottozahlen.engine.model.LottoException;


/**
 * Klasse mit Einstiegsmethode für Erzeugung eines Zahltipps für Lotto "6 aus 49" (Deutschland).
 * Die dafür verwendete Klasse {@link LottoZahlenGenerator} kann aber auch für andere Lottosysteme
 * verwendet werden.
 */
public class App {
	
	/**
	 * Dummy-Konstruktor, um Instanziierung dieser Klasse zu verhindern
	 * (wäre nicht sinnvoll, weil die Klasse nur eine statische Methode hat).
	 */
	private App() {}		
	

    /**
     * Einstiegsmethode: schreibt einen Zahlentipp für deutsches Lotto
     * "6 aus 49" auf die Konsole (aufsteigend sortiert).
     *
     * @param args Kommandozeilenargumente, werden nicht ausgewertet.
     *
     * @throws LottoException falls die Erzeugung des Zahlentipps fehlschlägt
     */
    public static void main ( String[] args ) throws LottoException {

        System.out.println( "\nTipp deutsches Zahlenlotto \"6 aus \"49:\n" );

        LottoZahlenGenerator lottoZahlenGenerator = new LottoZahlenGenerator( 6, 49 ); // throws LottoException

        int[] lottoTippArray = lottoZahlenGenerator.erzeugeTipp();
        for ( int zahl : lottoTippArray ) {

            System.out.println( "  " + zahl );
        }

        System.out.println();
    }

}