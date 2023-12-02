package de.eldecker.dhbw.lottozahlen.test.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Diese Test-Suite nur Unit-Test-Methoden aus, die mit dem Tag "WichtigerTest" annotiert sind.  
 * <br><br>
 * 
 * Maven-Befehl, um diese Suite auszuführen:
 * <pre>
 * mvn test -Dtest="WichtigTestSuite"
 * </pre> 
 */
@Suite
@SuiteDisplayName("Test-Suite mit wichtigen Tests")
@SelectPackages("de.eldecker.dhbw.lottozahlen.test.alle")
@IncludeTags("WichtigerTest")
public class WichtigTestSuite {

}
