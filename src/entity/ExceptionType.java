package entity;

public enum ExceptionType {
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
	PloyNoEnter,UnregnizedCommand,FormatErrorE,FormatErrorC,UncorrectUseOfPower,NotVarWhenDerivative,
	VarNotEnterWhenDerivative,MultiVarWhenDerivative,FloatNotSupported,UnDefinedVar,BlankMissing
}
