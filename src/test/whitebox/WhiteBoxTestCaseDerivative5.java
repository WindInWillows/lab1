package test.whitebox;

import static org.junit.Assert.*;

import org.junit.Test;

import poly.Polynome;

public class WhiteBoxTestCaseDerivative5 {

	@Test
	public void test() {

		//设定参数
		String expressionStr = "x+4*y^2*z";
		String variStr = "x y";
		
		//输入参数
		Polynome po = new Polynome();
		po.getInput(expressionStr);
		po.opStr=variStr;
		
		//得到结果
		String actual = po.derivative();
		String expected = "0";
		assertEquals(expected, actual);
	}

}
