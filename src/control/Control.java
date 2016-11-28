package control;

import boundary.In;
import boundary.Out;
import entity.Polynome;
import entity.CommandType;
import entity.ExceptionType;
import entity.PolyException;

public class Control {

	private In in = new In();
	private Out out = new Out();
	private Polynome po = new Polynome();
	private Validator validator =new Validator();
	private CommandType commandType = null;
	private static final String EXIT_STR = "exit";
	private static final String SIMPLIFY_STR = "simplify";
	private static final String DERIVATIVE_STR = "d/d";
	
	public Control(){}
	public void main(){
		// 系统开始运行时，输出提示信息
		String inputStr = null;
		String outputStr = null;
		out.prompt();
		while (true){
			inputStr = in.getInput();
			if (isExpression(inputStr))
				outputStr=expressionProcess(inputStr);
			else
				outputStr=commandProcess(inputStr);
			out.print(outputStr);
		}
	}
	
	public String expressionProcess(String inputStr){
		// 格式检查：对输入表达式字符串格式的合法性进行检查
		try {
			boolean validateResult = validator.validateExpression(inputStr);
			if (validateResult == true)
				return po.expression(inputStr);
			else
				// 格式错误：表达式中包含不支持的字符
				throw new PolyException(ExceptionType.FormatErrorC);} 
		catch (PolyException e) {
			return e.getMessage();
		}
			
	}

	public String commandProcess(String inputStr){
		
		try{
			// 判断表达式是否已经输入
			if (po.isEmpty()){
				// 表达式尚未输入
				throw new PolyException(ExceptionType.FormatErrorE);
				}
			// 格式检查：对输入命令格式的合法性进行检查
			boolean validateResult = validator.validateCommand(inputStr);
			if (validateResult == false)
				// 格式错误：命令中包含不支持的字符
				throw new PolyException(ExceptionType.FormatErrorC);
			
			// 命令类型:得到输入命令的类型，根据不同的命令，执行不同的操作，并返回相应值
			commandType = getCommandType(inputStr); 
			switch(commandType) {
							
				case  EXIT: 		out.exitSys();return null;	  	// 退出系统						
				case  SIMPLIFY:		return po.simplify(inputStr); 	// 得到化简表达式后的结果								
				case  DERIVATIVE:	return po.derivative(inputStr);	// 得到表达式求导后的结果						
				case  ERROR:		throw new PolyException(ExceptionType.UnregnizedCommand);// 未知的命令	
				default: 			return "";// 返回空字符
			}
		} 
		catch (PolyException e) {
			return e.getMessage();
		}
	}

	
	// 确定输入的字符串是表达式还是命令
	private boolean isExpression(String str){
		if (str.indexOf("!")==-1)
			return true;
		else
			return false;
	}
	
	private CommandType getCommandType(String str){
		// 得到命令的类型
		if((str.indexOf(EXIT_STR) != -1))
			return CommandType.EXIT;//退出程序
		else if ((str.indexOf(SIMPLIFY_STR)) != -1) 
			return CommandType.SIMPLIFY;//化简表达式
		else if((str.indexOf(DERIVATIVE_STR)) != -1) 
			return CommandType.DERIVATIVE;//表达式求导
		else
			return CommandType.ERROR;//未知的命令
	}
}
