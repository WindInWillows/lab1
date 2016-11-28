package entity;

import java.util.ArrayList;

public class Polynome {

	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	private ExpressionR expressionR = new ExpressionR();
	private SimplifyR simplifyR = new SimplifyR();
	private DerivativeR derivativeR = new DerivativeR();
	
	public String expression(String inputStr) throws PolyException{
		expressionArray=expressionR.expression(inputStr);
		return toString();
	}
	
	public String simplify(String inputStr) throws PolyException {
		return simplifyR.simplify(inputStr,expressionArray);
	}

	public String derivative(String inputStr) throws PolyException {
		return derivativeR.derivative(inputStr,expressionArray);
	}
	
	public boolean isEmpty(){
		return expressionArray.isEmpty();
	}
	
	public String toString() {
		String resStr = "";
		boolean firstFlag = true;//也许能优化
		for (int i=0; i<this.expressionArray.size();i++){
			resStr+=this.expressionArray.get(i).toString(firstFlag);
			firstFlag = false;
		}
		return resStr;
	}
	
}
