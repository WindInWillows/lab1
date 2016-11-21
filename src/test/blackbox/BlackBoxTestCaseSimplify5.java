package test.blackbox;

import static org.junit.Assert.*;

import org.junit.Test;

import poly.Polynome;

public class BlackBoxTestCaseSimplify5 {

	@Test
	public void test() {
		Polynome po = new Polynome();
		//������ʽ
		String expressionStr = "x+4*y^2*z";
		po.getInput(expressionStr);
		
		//���뻯������
		String commandStr = "!simplify";
		po.getInput(commandStr);
		
		//�õ�������
		String actual = po.simplify();
		String expected = "1*x+4*y^2*z";
		assertEquals(expected, actual);
	}

}
