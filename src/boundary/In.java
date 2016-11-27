package boundary;

import java.util.Scanner;

public class In {

	private Scanner scan = new Scanner(System.in);
	public In(){}

	public String getInput() {
		// 读取一个字符串
		System.out.print(">> ");
		String strInput = scan.nextLine();
		
		// 当输入空时，则重新输入
		if (strInput.isEmpty()){
			return getInput();
		}
		return strInput;
	}
}
