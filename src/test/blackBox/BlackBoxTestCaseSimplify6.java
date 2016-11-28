package test.blackBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;


public class BlackBoxTestCaseSimplify6 {

	@Test
	public void test() {
	
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!simplify x=1y=1";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "BlankMissing: Some blank is missing.";
		
		assertEquals(expected, actual);
	}
}
