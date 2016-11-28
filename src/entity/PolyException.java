package entity;

import java.util.HashMap;
import java.util.Map;


public class PolyException extends Exception{
	
	private static final long serialVersionUID = 1L;	
	private ExceptionType exceptionType = null;
	
	/*
	 *  错误信息
	 *   1、表达式尚未输入
	 *   2、未知的命令
	 *   3、格式错误：表达式中包含不支持的字符
	 *   4、格式错误：命令中包含不支持的字符
	 *   5、对^的使用，不满足var^num模式
	 *   
	 *   6、求导时输入类似于"!d/d 3"的命令,即变量不可为数字
	 *   7、求导时输入类似于"!d/d "的命令,即未输入变量
	 *   8、求导时输入类似于"!d/d x y"的命令，即输入多个变量
	 *   
	 *   9、化简时输入类似于"!simplify x=0.1"的命令，即输入的变量值为小数
	 *   10、化简时输入未定义的变量，即表达式中未出现的变量
	 *   11、化简时输入类似于"!simplify x=1y=2"的命令，即格式错误，缺少空格
	 */
	
	private static final Map<ExceptionType, String> info = new HashMap<ExceptionType, String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
			put(ExceptionType.PloyNoEnter, "PloyNoEnter: Polynome isn\'t entered.");
			put(ExceptionType.UnregnizedCommand, "UnregnizedCommand: Command is unregnized.");
			put(ExceptionType.FormatErrorC, "FormatErrorC: Expression format isn\'t correct.");
			put(ExceptionType.FormatErrorE, "FormatErrorE: Command format isn\'t correct.");
			put(ExceptionType.UncorrectUseOfPower, "UncorrectUseOfPower: The use of power_sign isn't correct.It should be like \"var^num\"");
			put(ExceptionType.NotVarWhenDerivative, "NotVarWhenDerivative: Not a variable but a number was entered when derivative.");
			put(ExceptionType.VarNotEnterWhenDerivative, "VarNotEnterWhenDerivative: No variable was entered when derivative.");
			put(ExceptionType.MultiVarWhenDerivative, "MultiVarWhenDerivative: Multi-variables were entered when derivative.");
			put(ExceptionType.FloatNotSupported, "FloatNotSupported: Float number wasn\'t supported here.");
			put(ExceptionType.UnDefinedVar, "UnDefinedVar: The variable you enter w isn't defined.");
			put(ExceptionType.BlankMissing, "BlankMissing: Some blank is missing.");
		};
	};

	public PolyException(ExceptionType exceptionType){  
		this.exceptionType=exceptionType;
    }
	
	@Override
	public String toString() {
		return this.getMessage();
	}

	@Override
	public String getMessage() {
		return (String)info.get(exceptionType);
	}

}
