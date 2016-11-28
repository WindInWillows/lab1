package test.whiteBox;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	WhiteBoxTestCaseDerivative1.class, 
	WhiteBoxTestCaseDerivative2.class, 
	WhiteBoxTestCaseDerivative3.class,
	WhiteBoxTestCaseDerivative4.class, 
	WhiteBoxTestCaseDerivative5.class, 
	WhiteBoxTestCaseDerivative6.class })

public class AllTests {}
