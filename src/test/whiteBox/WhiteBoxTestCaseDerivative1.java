package test.whiteBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;

public class WhiteBoxTestCaseDerivative1 {

	@Test
	public void test() {
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!d/d x y";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "MultiVarWhenDerivative: Multi-variables were entered when derivative.";
		
		assertEquals(expected, actual);
	}
}
