package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	BlackBoxTestCaseSimplify1.class, 
	BlackBoxTestCaseSimplify2.class, 
	BlackBoxTestCaseSimplify3.class,
	BlackBoxTestCaseSimplify4.class, 
	BlackBoxTestCaseSimplify5.class, 
	BlackBoxTestCaseSimplify6.class })
public class AllTests {
	
}
