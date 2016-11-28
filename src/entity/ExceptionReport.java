package entity;

public class ExceptionReport {
	
/*
 *  错误信息
 *   1、表达式尚未输入
 *   2、未知的命令
 *   3、格式错误：表达式中包含不支持的字符
 *   4、格式错误：命令中包含不支持的字符
 *   
 *   
 *   
 *   
 *   1、Invalid character inside	输入包含除 数字、字母、空格、tab、+、-、*、^ 以外 的字符的表达式
 *   2、Wrong command			命令格式出错，在！前有除了空格和制表符之外的字符
 *   3、Unrecognized command		输入了未知的命令
 *   4、^ error. It should be var^num	对^的使用，不满足var^num模式
 *   5、Polynome hasn't been entered 	输入表达式前，输入化简和求导的命令
 */
	private String errorMsg = null;
	
	public String getErrorMessage(int i) {
		errorMsg=getByErrorID(i);
		return errorMsg;
	}

	private String getByErrorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
