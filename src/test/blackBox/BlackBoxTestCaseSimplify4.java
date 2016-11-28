package test.blackBox;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Control;


public class BlackBoxTestCaseSimplify4 {

	@Test
	public void test() {
	
		String expressionStr = "x+4*y^2*z";
		String commandStr = "!simplify x=0.1";
		
		Control  c= new Control();
		c.expressionProcess(expressionStr);
		
		String actual = c.commandProcess(commandStr);
		String expected = "FloatNotSupported: Float number wasn\'t supported here.";
		
		assertEquals(expected, actual);
	}
}
