package test.whiteBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;

public class WhiteBoxTestCaseDerivative2 {

	@Test
	public void test() {
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!d/d";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "VarNotEnterWhenDerivative: No variable was entered when derivative.";
		
		assertEquals(expected, actual);
	}
}

