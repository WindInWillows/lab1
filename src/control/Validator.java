package control;

public class Validator {

	public boolean validateExpression(String inputStr) {
		
		char[] chars = inputStr.toCharArray();
		for(char ch : chars){
			// 包含除 数字、字母、空格、tab、+、-、*、^、. 以外 的字符
			if(ch != ' ' && ch != '\t' ){
				if(!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') 
				|| (ch >= 'A' && ch <= 'Z') || ch == '+' || ch == '-'
				||  ch == '*' || ch == '^' || ch == '.')){
					return false;
				}
			}
		}
		return true;
	}

	public boolean validateCommand(String inputStr) {
		// 检查输入的命令是否在！前有除空格和制表符之外的字符
		// 如果有，则说明输入的命令有误
		char[] chars = inputStr.toCharArray();
		boolean checkFlag = true;
		for (char ch : chars){
			if(ch == '!'){
				checkFlag = false;
				break;
			}
			else if((ch != ' ' && ch != '\t') && checkFlag){
				return false;
			}
		}
		return true;
	}
	
}
