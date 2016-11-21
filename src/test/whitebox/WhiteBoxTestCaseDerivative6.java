package test.whitebox;

import static org.junit.Assert.*;

import org.junit.Test;

import poly.Polynome;

public class WhiteBoxTestCaseDerivative6 {

	@Test
	public void test() {

		//�趨����
		String expressionStr = "x+4*y^2*z";
		String variStr = "1.0";
		
		//�������
		Polynome po = new Polynome();
		po.getInput(expressionStr);
		po.opStr=variStr;
		
		//�õ����
		String actual = po.derivative();
		String expected = "ERROR:variable cannot be number";
		assertEquals(expected, actual);
	}
}
