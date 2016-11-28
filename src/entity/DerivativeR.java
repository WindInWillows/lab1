package entity;

import java.util.ArrayList;


public class DerivativeR {


	private String opStr = null;
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	public String derivative(String inputStr, ArrayList<Item> expressionArray) {
		// !d/d
		opStr=inputStr.substring(4).trim();
		this.expressionArray = expressionArray;
		return derivative();
	}
	
	// 白盒测试
	public String derivative() {
		try{
			Double.parseDouble(this.opStr);
			return "ERROR:variable cannot be number";
		} catch (Exception e) {}
		
		if(this.opStr.trim().equals(""))
			return "ERROR:variable not entered";
		String[] strs = this.opStr.split(" ");
		int variCount = 0;
		for(String tmp : strs) {
			if(tmp != null && !tmp.equals("\t")) 
				variCount++;
		}
		if(variCount > 1) {
			return "ERROR:not support multi variables";
		}
		
		//初始化要返回的字符串resStr，作为要输出的内容
		String resStr = "";
		
		//firstFLag标识Item是否是第一项，第一项不需要有"+"号
		boolean firstFlag = true;
		
		//对每一项Item进行求导操作，将 每个求导结果 合并到 resStr中
		for (int i=0; i<this.expressionArray.size();i++){
			Item now = this.expressionArray.get(i);
			//得到当前项求导后的新Item
			Item diffItem = now.diff(this.opStr.trim());
			//求导后为空，说明该项中不存在求导变量
			if (diffItem == null) 
				resStr += "";
			else {
				//将 当前求导结果 合并到 resStr中
				resStr += diffItem.toString(firstFlag);
				//更新firstFlag，至此一定不是第一项
				firstFlag = false;
			}
		}
		
		//该表达式中所有项均不存在求导的变量,输出0
		if (resStr.isEmpty()) 
			resStr = "0";
		return resStr;
	}

}
