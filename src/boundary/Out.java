package boundary;

public class Out {

	public void print(String str) {
		System.out.println(str);
	}

	public void exitSys() {
		System.out.println("Thanks for use!");
		System.exit(0);
	}
	
	public void prompt(){
		// 系统开始运行后打印提示信息
		// 可在此添加包括版本，帮助等的提示信息
		System.out.println("<Welcome to Polynomials System 1.0>");
	}

}
