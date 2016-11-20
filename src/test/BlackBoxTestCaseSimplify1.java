package test;

import static org.junit.Assert.*;

import org.junit.Test;

import poly.Polynome;

public class BlackBoxTestCaseSimplify1 {

	@Test
	public void test() {
		Polynome po = new Polynome();
		//������ʽ
		String expressionStr = "2*x *y";
		po.getInput(expressionStr);
		
		//���뻯������
		String commandStr = "!simplify x=2";
		po.getInput(commandStr);
		
		//�õ�������
		String actual = po.simplify();
		String expected = "4*y";
		assertEquals(expected, actual);
//		fail("Not yet implemented");
	}

}
