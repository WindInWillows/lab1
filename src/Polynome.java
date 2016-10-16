import java.util.ArrayList;
import java.util.Scanner;


//fix conflict

// 实现了一个处理多项式的类

/* 
 * 功能
 *  1、读入一个多项式表达式，并保存
 *  2、读入化简命令，对表达式进行化简操作，并输出
 *  3、读入求导命令，对表达式进行求导操作，并输出
 *  4、读入退出命令，退出系统
 */

/*
 *  错误信息
 *   1、Invalid character inside	输入包含除 数字、字母、空格、tab、+、-、*、^ 以外 的字符的表达式
 *   2、Wrong command			命令格式出错，在！前有除了空格和制表符之外的字符
 *   3、Unrecognized command		输入了未知的命令
 *   4、^ error. It should be var^num	对^的使用，不满足var^num模式
 *   5、Polynome hasn't been entered 	输入表达式前，输入化简和求导的命令
 */

/*
 * 输入的表达式说明
 *  1、只能包含 数字、字母、空格、tab、+、-、*、^ 等字符
 *  2、可以包含空格和制表符
 *  3、支持加减法
 *  4、可以在使用变量^数字，用来表示指数；不支持数字后加^和^后加字母
 *  5、变量名称可以是字母和数字的组合，长度无限制
 *  6、不支持括号
 *  7、不支持*的省略
 *  8、不支持同类项合并
 */

/*
 * 命令说明
 *  1、支持多变量化简
 *  2、支持化简的变量的值为负数
 *  3、不支持小数
 *  4、化简命令中出现未在表达式中出现的变量则忽略
 *  5、化简命令中出现类似于!simplify x y=1,则忽略x
 *  6、化简命令中出现错误的表达形式如 x=x x=pi x=1.5,则忽略这一项
 *  7、求导命令中出现未在表达式中出现的变量则返回0
 *  8、不支持同类项合并

//v2

// 瀹炵幇浜嗕竴涓鐞嗗椤瑰紡鐨勭被

/* 
 * 鍔熻兘
 *  1銆佽鍏ヤ竴涓椤瑰紡琛ㄨ揪寮忥紝骞朵繚瀛?
 *  2銆佽鍏ュ寲绠�鍛戒护锛屽琛ㄨ揪寮忚繘琛屽寲绠�鎿嶄綔锛屽苟杈撳嚭
 *  3銆佽鍏ユ眰瀵煎懡浠わ紝瀵硅〃杈惧紡杩涜姹傚鎿嶄綔锛屽苟杈撳嚭
 *  4銆佽鍏ラ��鍑哄懡浠わ紝閫�鍑虹郴缁?
 */

/*
 *  閿欒淇℃伅
 *   1銆両nvalid character inside	杈撳叆鍖呭惈闄?鏁板瓧銆佸瓧姣嶃�佺┖鏍笺�乼ab銆?銆?銆?銆乛 浠ュ 鐨勫瓧绗︾殑琛ㄨ揪寮?
 *   2銆乄rong command			鍛戒护鏍煎紡鍑洪敊锛屽湪锛佸墠鏈夐櫎浜嗙┖鏍煎拰鍒惰〃绗︿箣澶栫殑瀛楃
 *   3銆乁nrecognized command		杈撳叆浜嗘湭鐭ョ殑鍛戒护
 *   4銆乛 error. It should be var^num	瀵筤鐨勪娇鐢紝涓嶆弧瓒硋ar^num妯″紡
 *   5銆丳olynome hasn't been entered 	杈撳叆琛ㄨ揪寮忓墠锛岃緭鍏ュ寲绠�鍜屾眰瀵肩殑鍛戒护
 */

/*
 * 杈撳叆鐨勮〃杈惧紡璇存槑
 *  1銆佸彧鑳藉寘鍚?鏁板瓧銆佸瓧姣嶃�佺┖鏍笺�乼ab銆?銆?銆?銆乛 绛夊瓧绗?
 *  2銆佸彲浠ュ寘鍚┖鏍煎拰鍒惰〃绗?
 *  3銆佹敮鎸佸姞鍑忔硶
 *  4銆佸彲浠ュ湪浣跨敤鍙橀噺^鏁板瓧锛岀敤鏉ヨ〃绀烘寚鏁帮紱涓嶆敮鎸佹暟瀛楀悗鍔燸鍜宆鍚庡姞瀛楁瘝
 *  5銆佸彉閲忓悕绉板彲浠ユ槸瀛楁瘝鍜屾暟瀛楃殑缁勫悎锛岄暱搴︽棤闄愬埗
 *  6銆佷笉鏀寔鎷彿
 *  7銆佷笉鏀寔*鐨勭渷鐣?
 *  8銆佷笉鏀寔鍚岀被椤瑰悎骞?
 */

/*
 * 鍛戒护璇存槑
 *  1銆佹敮鎸佸鍙橀噺鍖栫畝
 *  2銆佹敮鎸佸寲绠�鐨勫彉閲忕殑鍊间负璐熸暟
 *  3銆佷笉鏀寔灏忔暟
 *  4銆佸寲绠�鍛戒护涓嚭鐜版湭鍦ㄨ〃杈惧紡涓嚭鐜扮殑鍙橀噺鍒欏拷鐣?
 *  5銆佸寲绠�鍛戒护涓嚭鐜扮被浼间簬!simplify x y=1,鍒欏拷鐣
 *  6銆佸寲绠�鍛戒护涓嚭鐜伴敊璇殑琛ㄨ揪褰㈠紡濡?x=x x=pi x=1.5,鍒欏拷鐣ヨ繖涓�椤?
 *  7銆佹眰瀵煎懡浠や腑鍑虹幇鏈湪琛ㄨ揪寮忎腑鍑虹幇鐨勫彉閲忓垯杩斿洖0
 *  8銆佷笉鏀寔鍚岀被椤瑰悎骞?

 */
public class Polynome {

	//--------------------------------------------------------

	// 一个输入流对象，用于接受表达式和字符串的输入
	private Scanner scan;
	// 通过使用一个类型为Item的列表保存当前表达式，是主要的
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	// 临时字符串，用于保存去除空格和制表符之后的输入字符串
	private String tmpStr = "";
	
	// opCode为操作码，opStr为操作字。这两个变量在getInput被修改，作用于impOperation。
	// opCode决定在impOperation中执行什么类型的操作
	// opStr辅助opCode的实现
	//	执行化简命令（!simplify x=1 y=2）时，opStr中保存 x=1 y=2;
	//	执行求导命令(!d/d x)时，opStr中保存x;
	//	输出错误信息是，opStr保存错误信息。
	private int opCode = 0;
	private String opStr = "";
	// 字符串常量

	// 涓�涓緭鍏ユ祦瀵硅薄锛岀敤浜庢帴鍙楄〃杈惧紡鍜屽瓧绗︿覆鐨勮緭鍏?
	private Scanner scan;
	// 閫氳繃浣跨敤涓�涓被鍨嬩负Item鐨勫垪琛ㄤ繚瀛樺綋鍓嶈〃杈惧紡锛屾槸涓昏鐨?
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	// 涓存椂瀛楃涓诧紝鐢ㄤ簬淇濆瓨鍘婚櫎绌烘牸鍜屽埗琛ㄧ涔嬪悗鐨勮緭鍏ュ瓧绗︿覆
	private String tmpStr = "";
	
	// opCode涓烘搷浣滅爜锛宱pStr涓烘搷浣滃瓧銆傝繖涓や釜鍙橀噺鍦╣etInput琚慨鏀癸紝浣滅敤浜巌mpOperation銆?
	// opCode鍐冲畾鍦╥mpOperation涓墽琛屼粈涔堢被鍨嬬殑鎿嶄綔
	// opStr杈呭姪opCode鐨勫疄鐜?
	//	鎵ц鍖栫畝鍛戒护锛?simplify x=1 y=2锛夋椂锛宱pStr涓繚瀛?x=1 y=2;
	//	鎵ц姹傚鍛戒护(!d/d x)鏃讹紝opStr涓繚瀛榵;
	//	杈撳嚭閿欒淇℃伅鏄紝opStr淇濆瓨閿欒淇℃伅銆?
	private int opCode = 0;
	private String opStr = "";
	// 瀛楃涓插父閲?

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

		// 打印提示信息
		po.prompt();
		while(true){
			//读取一个字符串，判断是表达式还是命令，并做相应的处理，以及得到一个操作码
			po.getInput();
			//根据上一步中获得的操作码执行相应的操作

		// 鎵撳嵃鎻愮ず淇℃伅
		po.prompt();
		while(true){
			//璇诲彇涓�涓瓧绗︿覆锛屽垽鏂槸琛ㄨ揪寮忚繕鏄懡浠わ紝骞跺仛鐩稿簲鐨勫鐞嗭紝浠ュ強寰楀埌涓�涓搷浣滅爜
			po.getInput();
			//鏍规嵁涓婁竴姝ヤ腑鑾峰緱鐨勬搷浣滅爜鎵ц鐩稿簲鐨勬搷浣?

			po.impOperation();
		}
	}
	
	public void prompt(){

		// 系统开始运行后打印提示信息
		// 可在此添加包括版本，帮助等的提示信息

		// 绯荤粺寮�濮嬭繍琛屽悗鎵撳嵃鎻愮ず淇℃伅
		// 鍙湪姝ゆ坊鍔犲寘鎷増鏈紝甯姪绛夌殑鎻愮ず淇℃伅

		System.out.println("<Welcome to Polynomials System 1.0>");
	}
	
	
	public void getInput(){
		

		// 读取一个字符串
		System.out.print(">> ");
		String strInput = scan.nextLine();
		
		// 当输入空时，则重新输入

		// 璇诲彇涓�涓瓧绗︿覆
		System.out.print(">> ");
		String strInput = scan.nextLine();
		
		// 褰撹緭鍏ョ┖鏃讹紝鍒欓噸鏂拌緭鍏?

		if (strInput.isEmpty()){
			opCode = 0;
			return;
		}
		

		// 此字符串中不包含“！”，则为表达式；否则，为命令。
		// 并进行进入相应的处理函数

		// 姝ゅ瓧绗︿覆涓笉鍖呭惈鈥滐紒鈥濓紝鍒欎负琛ㄨ揪寮忥紱鍚﹀垯锛屼负鍛戒护銆?
		// 骞惰繘琛岃繘鍏ョ浉搴旂殑澶勭悊鍑芥暟

		if (strInput.indexOf("!")==-1) expression(strInput);
		else command(strInput);
  	}
	
	public void impOperation() {
		

		// 根据操作码执行相应操作	
		switch(opCode) {
			case -1: exitSys(); break; 	// 退出系统
			case 0:				break; 	// 空操作,默认值
			case 1:	print();    break;	// 打印当前表达式
			case 2:	simplify(); break;	// 化简表达式
			case 3:	derivative();break; // 对表达式求导
			case 4:	errorOutput();break;// 输出错误信息，错误信息保存在opStr中
			default: 	        break;  // 空操作

		// 鏍规嵁鎿嶄綔鐮佹墽琛岀浉搴旀搷浣?
		switch(opCode) {
			case -1: exitSys(); break; 	// 閫�鍑虹郴缁?
			case 0:				break; 	// 绌烘搷浣?榛樿鍊?
			case 1:	print();    break;	// 鎵撳嵃褰撳墠琛ㄨ揪寮?
			case 2:	simplify(); break;	// 鍖栫畝琛ㄨ揪寮?
			case 3:	derivative();break; // 瀵硅〃杈惧紡姹傚
			case 4:	errorOutput();break;// 杈撳嚭閿欒淇℃伅锛岄敊璇俊鎭繚瀛樺湪opStr涓?
			default: 	        break;  // 绌烘搷浣?

		}
	}
	
	
	private void expression(String strInput){
		

		// 对输入 StrInput 的合法性进行判定，同时去除表达式中的空格和制表符

		// 瀵硅緭鍏?StrInput 鐨勫悎娉曟�ц繘琛屽垽瀹氾紝鍚屾椂鍘婚櫎琛ㄨ揪寮忎腑鐨勭┖鏍煎拰鍒惰〃绗?

		if (validateExpressionAndStrip(strInput) == false){
			opCode = 4;
			opStr  = "Invalid character inside";
			return;
		}
		

		// 根据+和-，对表达式对应的字符串进行拆分
		// 并以拆分后的各个字符串作为参数，分别建立Item对象，加入到expressionArray中

		// 鏍规嵁+鍜?锛屽琛ㄨ揪寮忓搴旂殑瀛楃涓茶繘琛屾媶鍒?
		// 骞朵互鎷嗗垎鍚庣殑鍚勪釜瀛楃涓蹭綔涓哄弬鏁帮紝鍒嗗埆寤虹珛Item瀵硅薄锛屽姞鍏ュ埌expressionArray涓?

		buildItem();
	}
	
	
	private boolean validateExpressionAndStrip(String str){

		// 对 tmpStr 进行初始化

		// 瀵?tmpStr 杩涜鍒濆鍖?

		tmpStr = "";
		
		char[] chars = str.toCharArray();
		for(char ch : chars){

			// 包含除 数字、字母、空格、tab、+、-、*、^ 以外 的字符

			// 鍖呭惈闄?鏁板瓧銆佸瓧姣嶃�佺┖鏍笺�乼ab銆?銆?銆?銆乛 浠ュ 鐨勫瓧绗?

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

		// 对存储表达式的列表进行初始化
		expressionArray.clear();
		
		// 将一个表达式字符串根据+、-,进行拆分
		// 第一项的符号默认为正

		// 瀵瑰瓨鍌ㄨ〃杈惧紡鐨勫垪琛ㄨ繘琛屽垵濮嬪寲
		expressionArray.clear();
		
		// 灏嗕竴涓〃杈惧紡瀛楃涓叉牴鎹?銆?,杩涜鎷嗗垎
		// 绗竴椤圭殑绗﹀彿榛樿涓烘

		String itemStr = "+";
		char[] chars = tmpStr.toCharArray();
		for (char ch : chars){
			if (ch == '+'){
				if (addNewItem(itemStr) == false) return;

				// 下一项的符号为正

				// 涓嬩竴椤圭殑绗﹀彿涓烘

				itemStr = "+";
			}
			else if (ch == '-'){
				if (addNewItem(itemStr) == false) return;

				// 下一项的符号为负

				// 涓嬩竴椤圭殑绗﹀彿涓鸿礋

				itemStr = "-";
			}
			else itemStr += ch;
		}
		if (addNewItem(itemStr) == false) return;

		// 将opCode的值置为1,表示读入表达式成功，在impOperation中,对表达式进行打印

		// 灏唎pCode鐨勫�肩疆涓?,琛ㄧず璇诲叆琛ㄨ揪寮忔垚鍔燂紝鍦╥mpOperation涓?瀵硅〃杈惧紡杩涜鎵撳嵃

		else opCode = 1;
	}
	
	
	private boolean addNewItem(String itemStr){
		Item newItem = (new Item(itemStr));

		// 处理itemStr时，出错

		// 澶勭悊itemStr鏃讹紝鍑洪敊

		if(newItem.errorFlag == true) {
			opCode = 4;
			opStr = "^ error. It should be var^num";
			return false;
		}
		expressionArray.add(newItem);
		return true;
	}
	
	private void command(String strInput){

		// 检查输入的命令的合法性

		// 妫�鏌ヨ緭鍏ョ殑鍛戒护鐨勫悎娉曟�?

		if (validateCommandAndStrip(strInput) == false)
		{
			opCode = 4;
			opStr = "Wrong command";
			return;
		}
		

		// 判断命令类型,并修改opCode和opStr

		// 鍒ゆ柇鍛戒护绫诲瀷,骞朵慨鏀筼pCode鍜宱pStr

		getCommandType();
	}
	
	private boolean validateCommandAndStrip(String str){

		// 检查输入的命令是否在！前有除空格和制表符之外的字符
		// 如果有，则说明输入的命令有误

		// 妫�鏌ヨ緭鍏ョ殑鍛戒护鏄惁鍦紒鍓嶆湁闄ょ┖鏍煎拰鍒惰〃绗︿箣澶栫殑瀛楃
		// 濡傛灉鏈夛紝鍒欒鏄庤緭鍏ョ殑鍛戒护鏈夎

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

		// !!! 可添加功能 去除空格

		// !!! 鍙坊鍔犲姛鑳?鍘婚櫎绌烘牸

		tmpStr = str;
		return true;
	}

	
	private void getCommandType(){

		int index;
		if ((index = tmpStr.indexOf(SIMPLIFY)) != -1) {
			index += SIMPLIFY.length() + 1;

			opCode = 2;//化简表达式
		}
		else if((index = tmpStr.indexOf(DIFF)) != -1) {
			index += DIFF.length() + 1;
			opCode = 3;//表达式求导
		}
		else if((tmpStr.indexOf(EXIT_FLAG) != -1)){
			opCode = -1;//退出程序
			return;
		}
		else {
			opCode = 4;//命令错误

			opCode = 2;//鍖栫畝琛ㄨ揪寮?
		}
		else if((index = tmpStr.indexOf(DIFF)) != -1) {
			index += DIFF.length() + 1;
			opCode = 3;//琛ㄨ揪寮忔眰瀵?
		}
		else if((tmpStr.indexOf(EXIT_FLAG) != -1)){
			opCode = -1;//閫�鍑虹▼搴?
			return;
		}
		else {
			opCode = 4;//鍛戒护閿欒

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

		boolean firstFlag = true;//也许能优化

		boolean firstFlag = true;//涔熻鑳戒紭鍖?

		
		for (int i=0; i<this.expressionArray.size();i++){
			resStr += this.expressionArray.get(i).simplify(opStr).toString(firstFlag);
			firstFlag = false;
		}
		System.out.println(resStr);
	}

	private void derivative() {
		String resStr = "";

		boolean firstFlag = true;//也许能优化

		boolean firstFlag = true;//涔熻鑳戒紭鍖?

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

		boolean firstFlag = true;//也许能优化

		boolean firstFlag = true;//涔熻鑳戒紭鍖?

		for (int i=0; i<this.expressionArray.size();i++){
			resStr+=this.expressionArray.get(i).toString(firstFlag);
			firstFlag = false;
		}
		System.out.println(resStr);
	}
	
}

