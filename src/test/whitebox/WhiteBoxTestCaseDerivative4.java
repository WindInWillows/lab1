package test.whitebox;

import static org.junit.Assert.*;

import org.junit.Test;

import poly.Polynome;

public class WhiteBoxTestCaseDerivative4 {

	@Test
	public void test() {

		//�趨����
		String expressionStr = "x+4*y^2*z";
		String variStr = "y";
		
		//�������
		Polynome po = new Polynome();
		po.getInput(expressionStr);
		po.opStr=variStr;
		
		//�õ����
		String actual = po.derivative();
		String expected = "8*y*z";
		assertEquals(expected, actual);
	}
}
