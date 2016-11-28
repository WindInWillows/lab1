package entity;

import java.util.ArrayList;

public class SimplifyR {

	private String opStr = null;
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	
	public String simplify(String inputStr, ArrayList<Item> expressionArray) {
		// !simplify
		opStr=inputStr.substring(9);
		this.expressionArray=expressionArray;
		return simplify();
	}
	// 黑盒测试 之后 ，增添;格式错误，返回false
	private boolean checkBlankValid() {
		// tmpStr: "x=1y=2 z=1"=> x=1y=2 z=1 =>[x 1y 2] [z 1]
		String[] tmpStrArray= opStr.substring(1).split(" ");
		// s: "x=1y=2"
		for (String s : tmpStrArray){
			// sArray: x,1y,2
			//System.out.println(s);
			String[] sArray= s.split("=");
			try{
				// 预先判断
				if (sArray.length>=2){
					Integer.parseInt(sArray[1]);
				}
			} catch (Exception e) {
				//System.out.println(sArray[1]);
				return false;
			}
		}
		return true;
	}

	// 黑盒测试 之后 ，增添;未找到变量,返回false
	private boolean checkVariable_defined() {
		// tmpStr x=1 y=1 => (x=1,y=1
		String[] strArray = opStr.split(" ");
		for (String s : strArray){
			// s x=1 => (x,1)
			String[] ss = s.split("=");
			if (thisVariableDefined(ss[0])==true){
				return true;
			}
		}
		return false;
	}

	// 黑盒测试 之后 ，增添 ; 未找到变量，返回false
	private boolean thisVariableDefined(String v) {
		for (int i=0; i<this.expressionArray.size();i++){
			 if (this.expressionArray.get(i).hasVarialbe(v)!=null) 
				 return true;
		}
		return false;
	}

	// 黑盒测试 之后 ，增添;找到小数点，返回false
	private boolean checkRadixPoint() {
		char[] chars = opStr.toCharArray();
		for (char ch : chars){
			if (ch == '.'){
				return false;
			}
		}
		return true;
	}
	
	// 黑盒测试 之后 ，增添
	private String commandCheck_OF_simplify() {
		opStr=opStr.trim();
		if (opStr.equals(""))	return null;
		boolean passFlag = checkRadixPoint();
		if (passFlag == false){
			return "ERROR:float not support";
		}
		passFlag = checkVariable_defined();
		if (passFlag == false){
			return "ERROR:undefined variable";
		}
		passFlag = checkBlankValid();
		if (passFlag == false){
			return "ERROR:format error";
		}
		return null;
	}

	//黑盒测试
	public String simplify() {
		
		String resStr = commandCheck_OF_simplify();
		
		if (resStr!=null){
			return resStr;
		}
		resStr="";
		boolean firstFlag = true;//也许能优化
		
		for (int i=0; i<this.expressionArray.size();i++){
			resStr += this.expressionArray.get(i).simplify(opStr).toString(firstFlag);
			firstFlag = false;
			//System.out.println("  "+resStr);
		}
		return resStr;
	}
}