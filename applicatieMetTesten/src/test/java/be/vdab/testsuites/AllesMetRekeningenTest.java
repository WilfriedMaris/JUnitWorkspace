package be.vdab.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({be.vdab.valueobjects.RekeningnummerTest.class,
	be.vdab.entities.RekeningTest.class})
public class AllesMetRekeningenTest {

}
