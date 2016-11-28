package entity;

import java.util.ArrayList;

public class ExpressionR {
	
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	private String errorMsg = null;
	
	public ArrayList<Item> expression(String inputStr) throws PolyException {
		// 去除表达式中的空格和制表符
		inputStr = strip(inputStr);
		
		// 根据+和-，对表达式对应的字符串进行拆分
		// 并以拆分后的各个字符串作为参数，分别建立Item对象，加入到expressionArray中
		String buildItemMsg = buildItem(inputStr);
		if (buildItemMsg!=null)
			return null;
		else
			return expressionArray;
	}
	 
	public String getErrorMsg(){
		return this.errorMsg;
	}

	private String strip(String inputStr) {
		String resStr = "";
		char[] chars = inputStr.toCharArray();
		for(char ch:chars){
			if( ch!=' ' && ch!='\t')
				resStr += ch;
		}
		return resStr;
	}
	private String buildItem(String inputStr) throws PolyException{
		
		// 对存储表达式的列表进行初始化
		expressionArray.clear();
		
		// 将一个表达式字符串根据+、-,进行拆分
		// 第一项的符号默认为正
		String itemStr = "+";
		String newItemMsg = null;
		char[] chars = inputStr.toCharArray();
		for (char ch : chars){
			if (ch == '+'){
				newItemMsg=addNewItem(itemStr);
				if (newItemMsg != null) 
					return newItemMsg;
				// 下一项的符号为正
				itemStr = "+";
			}
			else if (ch == '-'){
				newItemMsg=addNewItem(itemStr);
				if (newItemMsg != null) 
					return newItemMsg;
				// 下一项的符号为负
				itemStr = "-";
			}
			else itemStr += ch;
		}
		newItemMsg=addNewItem(itemStr);
		if (newItemMsg != null) 
			return newItemMsg;
		else 
			// 读入表达式成功
			return null;
	}
	
	private String addNewItem(String itemStr) throws PolyException{
		Item newItem = (new Item(itemStr));
		// 处理itemStr时，出错
		if(newItem.errorFlag == true) {
			throw new PolyException(ExceptionType.UncorrectUseOfPower); 
		}
		expressionArray.add(newItem);
		return null;
	}
}
