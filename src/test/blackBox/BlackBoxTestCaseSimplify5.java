package test.blackBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;


public class BlackBoxTestCaseSimplify5 {

	@Test
	public void test() {
	
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!simplify";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "1*x+4*y^2*z";
		
		assertEquals(expected, actual);
	}
}
