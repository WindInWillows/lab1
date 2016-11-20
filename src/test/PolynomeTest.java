package test;

import static org.junit.Assert.*;
import org.junit.Test;
import poly.Polynome;

public class PolynomeTest {

	@Test
	public void testSimplify() {
		Polynome po = new Polynome();
		//输入表达式
		String expressionStr = "2*x *y";
		po.getInput(expressionStr);
		
		//输入化简命令
		String commandStr = "!simplify x=2";
		po.getInput(commandStr);
		
		//得到化简结果
		String actual = po.simplify();
		String expected = "4*y";
		
		assertEquals(expected, actual);
//		fail("Not yet implemented");
	}

}
