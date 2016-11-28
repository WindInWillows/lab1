package test.whiteBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;

public class WhiteBoxTestCaseDerivative4 {

	@Test
	public void test() {
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!d/d y";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "8*y*z";
		
		assertEquals(expected, actual);
	}
}