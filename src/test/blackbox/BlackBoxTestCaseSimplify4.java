package test.blackbox;

import static org.junit.Assert.*;

import org.junit.Test;

import poly.Polynome;

public class BlackBoxTestCaseSimplify4 {

	@Test
	public void test() {
		Polynome po = new Polynome();
		//输入表达式
		String expressionStr = "x+4*y^2*z";
		po.getInput(expressionStr);
		
		//输入化简命令
		String commandStr = "!simplify x=0.1";
		po.getInput(commandStr);
		
		//得到化简结果
		String actual = po.simplify();
		String expected = "ERROR:float not support";
		assertEquals(expected, actual);
	}

}
