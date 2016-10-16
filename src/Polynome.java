import java.util.ArrayList;
import java.util.Scanner;


//fix conflict

// ʵ����һ���������ʽ����

/* 
 * ����
 *  1������һ������ʽ���ʽ��������
 *  2�����뻯������Ա��ʽ���л�������������
 *  3������������Ա��ʽ�����󵼲����������
 *  4�������˳�����˳�ϵͳ
 */

/*
 *  ������Ϣ
 *   1��Invalid character inside	��������� ���֡���ĸ���ո�tab��+��-��*��^ ���� ���ַ��ı��ʽ
 *   2��Wrong command			�����ʽ�����ڣ�ǰ�г��˿ո���Ʊ��֮����ַ�
 *   3��Unrecognized command		������δ֪������
 *   4��^ error. It should be var^num	��^��ʹ�ã�������var^numģʽ
 *   5��Polynome hasn't been entered 	������ʽǰ�����뻯����󵼵�����
 */

/*
 * ����ı��ʽ˵��
 *  1��ֻ�ܰ��� ���֡���ĸ���ո�tab��+��-��*��^ ���ַ�
 *  2�����԰����ո���Ʊ��
 *  3��֧�ּӼ���
 *  4��������ʹ�ñ���^���֣�������ʾָ������֧�����ֺ��^��^�����ĸ
 *  5���������ƿ�������ĸ�����ֵ���ϣ�����������
 *  6����֧������
 *  7����֧��*��ʡ��
 *  8����֧��ͬ����ϲ�
 */

/*
 * ����˵��
 *  1��֧�ֶ��������
 *  2��֧�ֻ���ı�����ֵΪ����
 *  3����֧��С��
 *  4�����������г���δ�ڱ��ʽ�г��ֵı��������
 *  5�����������г���������!simplify x y=1,�����x
 *  6�����������г��ִ���ı����ʽ�� x=x x=pi x=1.5,�������һ��
 *  7���������г���δ�ڱ��ʽ�г��ֵı����򷵻�0
 *  8����֧��ͬ����ϲ�

//v2

// 实现了一个处理多项式的类

/* 
 * 功能
 *  1、读入一个多项式表达式，并保�?
 *  2、读入化简命令，对表达式进行化简操作，并输出
 *  3、读入求导命令，对表达式进行求导操作，并输出
 *  4、读入退出命令，退出系�?
 */

/*
 *  错误信息
 *   1、Invalid character inside	输入包含�?数字、字母、空格、tab�?�?�?、^ 以外 的字符的表达�?
 *   2、Wrong command			命令格式出错，在！前有除了空格和制表符之外的字符
 *   3、Unrecognized command		输入了未知的命令
 *   4、^ error. It should be var^num	对^的使用，不满足var^num模式
 *   5、Polynome hasn't been entered 	输入表达式前，输入化简和求导的命令
 */

/*
 * 输入的表达式说明
 *  1、只能包�?数字、字母、空格、tab�?�?�?、^ 等字�?
 *  2、可以包含空格和制表�?
 *  3、支持加减法
 *  4、可以在使用变量^数字，用来表示指数；不支持数字后加^和^后加字母
 *  5、变量名称可以是字母和数字的组合，长度无限制
 *  6、不支持括号
 *  7、不支持*的省�?
 *  8、不支持同类项合�?
 */

/*
 * 命令说明
 *  1、支持多变量化简
 *  2、支持化简的变量的值为负数
 *  3、不支持小数
 *  4、化简命令中出现未在表达式中出现的变量则忽�?
 *  5、化简命令中出现类似于!simplify x y=1,则忽略x
 *  6、化简命令中出现错误的表达形式�?x=x x=pi x=1.5,则忽略这一�?
 *  7、求导命令中出现未在表达式中出现的变量则返回0
 *  8、不支持同类项合�?

 */
public class Polynome {

	//--------------------------------------------------------

	// һ���������������ڽ��ܱ��ʽ���ַ���������
	private Scanner scan;
	// ͨ��ʹ��һ������ΪItem���б��浱ǰ���ʽ������Ҫ��
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	// ��ʱ�ַ��������ڱ���ȥ���ո���Ʊ��֮��������ַ���
	private String tmpStr = "";
	
	// opCodeΪ�����룬opStrΪ�����֡�������������getInput���޸ģ�������impOperation��
	// opCode������impOperation��ִ��ʲô���͵Ĳ���
	// opStr����opCode��ʵ��
	//	ִ�л������!simplify x=1 y=2��ʱ��opStr�б��� x=1 y=2;
	//	ִ��������(!d/d x)ʱ��opStr�б���x;
	//	���������Ϣ�ǣ�opStr���������Ϣ��
	private int opCode = 0;
	private String opStr = "";
	// �ַ�������

	// 一个输入流对象，用于接受表达式和字符串的输�?
	private Scanner scan;
	// 通过使用一个类型为Item的列表保存当前表达式，是主要�?
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	// 临时字符串，用于保存去除空格和制表符之后的输入字符串
	private String tmpStr = "";
	
	// opCode为操作码，opStr为操作字。这两个变量在getInput被修改，作用于impOperation�?
	// opCode决定在impOperation中执行什么类型的操作
	// opStr辅助opCode的实�?
	//	执行化简命令�?simplify x=1 y=2）时，opStr中保�?x=1 y=2;
	//	执行求导命令(!d/d x)时，opStr中保存x;
	//	输出错误信息是，opStr保存错误信息�?
	private int opCode = 0;
	private String opStr = "";
	// 字符串常�?

	private static final String EXIT_FLAG = "exit";
	private static final String SIMPLIFY = "simplify";
	private static final String DIFF = "d/d";
	//--------------------------------------------------------
	
	public Polynome() {
		//??
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Polynome po = new Polynome();

		// ��ӡ��ʾ��Ϣ
		po.prompt();
		while(true){
			//��ȡһ���ַ������ж��Ǳ��ʽ�������������Ӧ�Ĵ����Լ��õ�һ��������
			po.getInput();
			//������һ���л�õĲ�����ִ����Ӧ�Ĳ���

		// 打印提示信息
		po.prompt();
		while(true){
			//读取一个字符串，判断是表达式还是命令，并做相应的处理，以及得到一个操作码
			po.getInput();
			//根据上一步中获得的操作码执行相应的操�?

			po.impOperation();
		}
	}
	
	public void prompt(){

		// ϵͳ��ʼ���к��ӡ��ʾ��Ϣ
		// ���ڴ���Ӱ����汾�������ȵ���ʾ��Ϣ

		// 系统开始运行后打印提示信息
		// 可在此添加包括版本，帮助等的提示信息

		System.out.println("<Welcome to Polynomials System 1.0>");
	}
	
	
	public void getInput(){
		

		// ��ȡһ���ַ���
		System.out.print(">> ");
		String strInput = scan.nextLine();
		
		// �������ʱ������������

		// 读取一个字符串
		System.out.print(">> ");
		String strInput = scan.nextLine();
		
		// 当输入空时，则重新输�?

		if (strInput.isEmpty()){
			opCode = 0;
			return;
		}
		

		// ���ַ����в���������������Ϊ���ʽ������Ϊ���
		// �����н�����Ӧ�Ĵ�����

		// 此字符串中不包含“！”，则为表达式；否则，为命令�?
		// 并进行进入相应的处理函数

		if (strInput.indexOf("!")==-1) expression(strInput);
		else command(strInput);
  	}
	
	public void impOperation() {
		

		// ���ݲ�����ִ����Ӧ����	
		switch(opCode) {
			case -1: exitSys(); break; 	// �˳�ϵͳ
			case 0:				break; 	// �ղ���,Ĭ��ֵ
			case 1:	print();    break;	// ��ӡ��ǰ���ʽ
			case 2:	simplify(); break;	// ������ʽ
			case 3:	derivative();break; // �Ա��ʽ��
			case 4:	errorOutput();break;// ���������Ϣ��������Ϣ������opStr��
			default: 	        break;  // �ղ���

		// 根据操作码执行相应操�?
		switch(opCode) {
			case -1: exitSys(); break; 	// 退出系�?
			case 0:				break; 	// 空操�?默认�?
			case 1:	print();    break;	// 打印当前表达�?
			case 2:	simplify(); break;	// 化简表达�?
			case 3:	derivative();break; // 对表达式求导
			case 4:	errorOutput();break;// 输出错误信息，错误信息保存在opStr�?
			default: 	        break;  // 空操�?

		}
	}
	
	
	private void expression(String strInput){
		

		// ������ StrInput �ĺϷ��Խ����ж���ͬʱȥ�����ʽ�еĿո���Ʊ��

		// 对输�?StrInput 的合法性进行判定，同时去除表达式中的空格和制表�?

		if (validateExpressionAndStrip(strInput) == false){
			opCode = 4;
			opStr  = "Invalid character inside";
			return;
		}
		

		// ����+��-���Ա��ʽ��Ӧ���ַ������в��
		// ���Բ�ֺ�ĸ����ַ�����Ϊ�������ֱ���Item���󣬼��뵽expressionArray��

		// 根据+�?，对表达式对应的字符串进行拆�?
		// 并以拆分后的各个字符串作为参数，分别建立Item对象，加入到expressionArray�?

		buildItem();
	}
	
	
	private boolean validateExpressionAndStrip(String str){

		// �� tmpStr ���г�ʼ��

		// �?tmpStr 进行初始�?

		tmpStr = "";
		
		char[] chars = str.toCharArray();
		for(char ch : chars){

			// ������ ���֡���ĸ���ո�tab��+��-��*��^ ���� ���ַ�

			// 包含�?数字、字母、空格、tab�?�?�?、^ 以外 的字�?

			if(ch != ' ' && ch != '\t' ){
				if(!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') 
				|| (ch >= 'A' && ch <= 'Z') || ch == '+' || ch == '-'
				||  ch == '*' || ch == '^')){
					return false;
				}
				tmpStr += ch;
			}
		}
		return true;
	}
	
	private void buildItem(){

		// �Դ洢���ʽ���б���г�ʼ��
		expressionArray.clear();
		
		// ��һ�����ʽ�ַ�������+��-,���в��
		// ��һ��ķ���Ĭ��Ϊ��

		// 对存储表达式的列表进行初始化
		expressionArray.clear();
		
		// 将一个表达式字符串根�?�?,进行拆分
		// 第一项的符号默认为正

		String itemStr = "+";
		char[] chars = tmpStr.toCharArray();
		for (char ch : chars){
			if (ch == '+'){
				if (addNewItem(itemStr) == false) return;

				// ��һ��ķ���Ϊ��

				// 下一项的符号为正

				itemStr = "+";
			}
			else if (ch == '-'){
				if (addNewItem(itemStr) == false) return;

				// ��һ��ķ���Ϊ��

				// 下一项的符号为负

				itemStr = "-";
			}
			else itemStr += ch;
		}
		if (addNewItem(itemStr) == false) return;

		// ��opCode��ֵ��Ϊ1,��ʾ������ʽ�ɹ�����impOperation��,�Ա��ʽ���д�ӡ

		// 将opCode的值置�?,表示读入表达式成功，在impOperation�?对表达式进行打印

		else opCode = 1;
	}
	
	
	private boolean addNewItem(String itemStr){
		Item newItem = (new Item(itemStr));

		// ����itemStrʱ������

		// 处理itemStr时，出错

		if(newItem.errorFlag == true) {
			opCode = 4;
			opStr = "^ error. It should be var^num";
			return false;
		}
		expressionArray.add(newItem);
		return true;
	}
	
	private void command(String strInput){

		// ������������ĺϷ���

		// 检查输入的命令的合法�?

		if (validateCommandAndStrip(strInput) == false)
		{
			opCode = 4;
			opStr = "Wrong command";
			return;
		}
		

		// �ж���������,���޸�opCode��opStr

		// 判断命令类型,并修改opCode和opStr

		getCommandType();
	}
	
	private boolean validateCommandAndStrip(String str){

		// �������������Ƿ��ڣ�ǰ�г��ո���Ʊ��֮����ַ�
		// ����У���˵���������������

		// 检查输入的命令是否在！前有除空格和制表符之外的字符
		// 如果有，则说明输入的命令有误

		char[] chars = str.toCharArray();
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

		// !!! ����ӹ��� ȥ���ո�

		// !!! 可添加功�?去除空格

		tmpStr = str;
		return true;
	}

	
	private void getCommandType(){

		int index;
		if ((index = tmpStr.indexOf(SIMPLIFY)) != -1) {
			index += SIMPLIFY.length() + 1;

			opCode = 2;//������ʽ
		}
		else if((index = tmpStr.indexOf(DIFF)) != -1) {
			index += DIFF.length() + 1;
			opCode = 3;//���ʽ��
		}
		else if((tmpStr.indexOf(EXIT_FLAG) != -1)){
			opCode = -1;//�˳�����
			return;
		}
		else {
			opCode = 4;//�������

			opCode = 2;//化简表达�?
		}
		else if((index = tmpStr.indexOf(DIFF)) != -1) {
			index += DIFF.length() + 1;
			opCode = 3;//表达式求�?
		}
		else if((tmpStr.indexOf(EXIT_FLAG) != -1)){
			opCode = -1;//退出程�?
			return;
		}
		else {
			opCode = 4;//命令错误

			opStr = "Unrecognized command";
			return;
		}
		if (!this.expressionArray.isEmpty()) opStr = tmpStr.substring(index);
		else{
			opCode = 4;
			opStr="Polynome hasn't been entered";
		}
	}
	
	private void simplify() {
		String resStr = "";

		boolean firstFlag = true;//Ҳ�����Ż�

		boolean firstFlag = true;//也许能优�?

		
		for (int i=0; i<this.expressionArray.size();i++){
			resStr += this.expressionArray.get(i).simplify(opStr).toString(firstFlag);
			firstFlag = false;
		}
		System.out.println(resStr);
	}

	private void derivative() {
		String resStr = "";

		boolean firstFlag = true;//Ҳ�����Ż�

		boolean firstFlag = true;//也许能优�?

		for (int i=0; i<this.expressionArray.size();i++){
			Item diffItem = this.expressionArray.get(i).diff(this.opStr);
			if (diffItem == null) resStr += "";
			else {
				resStr += diffItem.toString(firstFlag);
				firstFlag = false;
			}
		}
		if (resStr.isEmpty()) resStr = "";
		System.out.println(resStr);
	}
	

	private void exitSys() {
		System.out.println("Thanks for use!");
		System.exit(0);
	}
	
	private void errorOutput(){
		System.out.println("Error: "+opStr+".");
	}
	
	private void print() {
		String resStr = "";

		boolean firstFlag = true;//Ҳ�����Ż�

		boolean firstFlag = true;//也许能优�?

		for (int i=0; i<this.expressionArray.size();i++){
			resStr+=this.expressionArray.get(i).toString(firstFlag);
			firstFlag = false;
		}
		System.out.println(resStr);
	}
	
}

