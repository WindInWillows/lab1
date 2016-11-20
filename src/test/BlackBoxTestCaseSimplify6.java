package test;

import static org.junit.Assert.*;

import org.junit.Test;

import poly.Polynome;

public class BlackBoxTestCaseSimplify6 {

	@Test
	public void test() {
		Polynome po = new Polynome();
		//������ʽ
		String expressionStr = "x+4*y^2*z";
		po.getInput(expressionStr);
		
		//���뻯������
		String commandStr = "!simplify x=1y=1";
		po.getInput(commandStr);
		
		//�õ�������
		String actual = po.simplify();
		String expected = "ERROR: format error";
		assertEquals(expected, actual);
	}

}
