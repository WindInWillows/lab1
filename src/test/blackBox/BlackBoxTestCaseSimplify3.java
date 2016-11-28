package test.blackBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;


public class BlackBoxTestCaseSimplify3 {

	@Test
	public void test() {
	
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!simplify x=1 y=1 z=1";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "1+4";
		
		assertEquals(expected, actual);
	}
}

