package test.whiteBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;

public class WhiteBoxTestCaseDerivative5 {

	@Test
	public void test() {
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!d/d c";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "0";
		
		assertEquals(expected, actual);
	}
}