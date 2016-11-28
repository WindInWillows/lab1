package test.blackBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;


public class BlackBoxTestCaseSimplify2 {

	@Test
	public void test() {
	
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!simplify a=1";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "UnDefinedVar: The variable you enter isn't defined.";
		
		assertEquals(expected, actual);
	}

}
