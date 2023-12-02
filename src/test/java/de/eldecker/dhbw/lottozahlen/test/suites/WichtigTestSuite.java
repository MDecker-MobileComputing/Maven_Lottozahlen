package de.eldecker.dhbw.lottozahlen.test.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Diese Test-Suite nur Unit-Test-Methoden aus, die mit dem Tag "wichtig" annotiert sind.  
 * <br><br>
 * 
 * Maven-Befehl, um diese Suite auszuführen:
 * <pre>
 *      mvn test -Dtest="WichtigTestSuite"
 * </pre> 
 * <br><br>
 * 
 * Maven-Befehl, um nur Test-Methoden, die mit Tag "wichtig" versehen sind, auszuführen:
 * <pre>
 *      mvn test -Dgroups="wichtig"
 * </pre> 
 */
@Suite
@SuiteDisplayName("Test-Suite mit wichtigen Tests")
@SelectPackages("de.eldecker.dhbw.lottozahlen.test.alle")
@IncludeTags("wichtig")
public class WichtigTestSuite {

}
