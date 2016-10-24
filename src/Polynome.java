import java.util.ArrayList;
import java.util.Scanner;


//fix conflict

// ÊµÏÖÁËÒ»¸ö´¦Àí¶àÏîÊ½µÄÀà

/* 
 * ¹¦ÄÜ
 *  1¡¢¶ÁÈëÒ»¸ö¶àÏîÊ½±í´ïÊ½£¬²¢±£´æ
 *  2¡¢¶ÁÈë»¯¼òÃüÁî£¬¶Ô±í´ïÊ½½øÐÐ»¯¼ò²Ù×÷£¬²¢Êä³ö
 *  3¡¢¶ÁÈëÇóµ¼ÃüÁî£¬¶Ô±í´ïÊ½½øÐÐÇóµ¼²Ù×÷£¬²¢Êä³ö
 *  4¡¢¶ÁÈëÍË³öÃüÁî£¬ÍË³öÏµÍ³
 */

/*
 *  ´íÎóÐÅÏ¢
 *   1¡¢Invalid character inside	ÊäÈë°üº¬³ý Êý×Ö¡¢×ÖÄ¸¡¢¿Õ¸ñ¡¢tab¡¢+¡¢-¡¢*¡¢^ ÒÔÍâ µÄ×Ö·ûµÄ±í´ïÊ½
 *   2¡¢Wrong command			ÃüÁî¸ñÊ½³ö´í£¬ÔÚ£¡Ç°ÓÐ³ýÁË¿Õ¸ñºÍÖÆ±í·ûÖ®ÍâµÄ×Ö·û
 *   3¡¢Unrecognized command		ÊäÈëÁËÎ´ÖªµÄÃüÁî
 *   4¡¢^ error. It should be var^num	¶Ô^µÄÊ¹ÓÃ£¬²»Âú×ãvar^numÄ£Ê½
 *   5¡¢Polynome hasn't been entered 	ÊäÈë±í´ïÊ½Ç°£¬ÊäÈë»¯¼òºÍÇóµ¼µÄÃüÁî
 */

/*
 * ÊäÈëµÄ±í´ïÊ½ËµÃ÷
 *  1¡¢Ö»ÄÜ°üº¬ Êý×Ö¡¢×ÖÄ¸¡¢¿Õ¸ñ¡¢tab¡¢+¡¢-¡¢*¡¢^ µÈ×Ö·û
 *  2¡¢¿ÉÒÔ°üº¬¿Õ¸ñºÍÖÆ±í·û
 *  3¡¢Ö§³Ö¼Ó¼õ·¨
 *  4¡¢¿ÉÒÔÔÚÊ¹ÓÃ±äÁ¿^Êý×Ö£¬ÓÃÀ´±íÊ¾Ö¸Êý£»²»Ö§³ÖÊý×Öºó¼Ó^ºÍ^ºó¼Ó×ÖÄ¸
 *  5¡¢±äÁ¿Ãû³Æ¿ÉÒÔÊÇ×ÖÄ¸ºÍÊý×ÖµÄ×éºÏ£¬³¤¶ÈÎÞÏÞÖÆ
 *  6¡¢²»Ö§³ÖÀ¨ºÅ
 *  7¡¢²»Ö§³Ö*µÄÊ¡ÂÔ
 *  8¡¢²»Ö§³ÖÍ¬ÀàÏîºÏ²¢
 */

/*
 * ÃüÁîËµÃ÷
 *  1¡¢Ö§³Ö¶à±äÁ¿»¯¼ò
 *  2¡¢Ö§³Ö»¯¼òµÄ±äÁ¿µÄÖµÎª¸ºÊý
 *  3¡¢²»Ö§³ÖÐ¡Êý
 *  4¡¢»¯¼òÃüÁîÖÐ³öÏÖÎ´ÔÚ±í´ïÊ½ÖÐ³öÏÖµÄ±äÁ¿ÔòºöÂÔ
 *  5¡¢»¯¼òÃüÁîÖÐ³öÏÖÀàËÆÓÚ!simplify x y=1,ÔòºöÂÔx
 *  6¡¢»¯¼òÃüÁîÖÐ³öÏÖ´íÎóµÄ±í´ïÐÎÊ½Èç x=x x=pi x=1.5,ÔòºöÂÔÕâÒ»Ïî
 *  7¡¢Çóµ¼ÃüÁîÖÐ³öÏÖÎ´ÔÚ±í´ïÊ½ÖÐ³öÏÖµÄ±äÁ¿Ôò·µ»Ø0
 *  8¡¢²»Ö§³ÖÍ¬ÀàÏîºÏ²¢

//v2

// å®žçŽ°äº†ä¸€ä¸ªå¤„ç†å¤šé¡¹å¼çš„ç±»

/* 
 * åŠŸèƒ½
 *  1ã€è¯»å…¥ä¸€ä¸ªå¤šé¡¹å¼è¡¨è¾¾å¼ï¼Œå¹¶ä¿å­?
 *  2ã€è¯»å…¥åŒ–ç®€å‘½ä»¤ï¼Œå¯¹è¡¨è¾¾å¼è¿›è¡ŒåŒ–ç®€æ“ä½œï¼Œå¹¶è¾“å‡º
 *  3ã€è¯»å…¥æ±‚å¯¼å‘½ä»¤ï¼Œå¯¹è¡¨è¾¾å¼è¿›è¡Œæ±‚å¯¼æ“ä½œï¼Œå¹¶è¾“å‡º
 *  4ã€è¯»å…¥é€€å‡ºå‘½ä»¤ï¼Œé€€å‡ºç³»ç»?
 */

/*
 *  é”™è¯¯ä¿¡æ¯
 *   1ã€Invalid character inside	è¾“å…¥åŒ…å«é™?æ•°å­—ã€å­—æ¯ã€ç©ºæ ¼ã€tabã€?ã€?ã€?ã€^ ä»¥å¤– çš„å­—ç¬¦çš„è¡¨è¾¾å¼?
 *   2ã€Wrong command			å‘½ä»¤æ ¼å¼å‡ºé”™ï¼Œåœ¨ï¼å‰æœ‰é™¤äº†ç©ºæ ¼å’Œåˆ¶è¡¨ç¬¦ä¹‹å¤–çš„å­—ç¬¦
 *   3ã€Unrecognized command		è¾“å…¥äº†æœªçŸ¥çš„å‘½ä»¤
 *   4ã€^ error. It should be var^num	å¯¹^çš„ä½¿ç”¨ï¼Œä¸æ»¡è¶³var^numæ¨¡å¼
 *   5ã€Polynome hasn't been entered 	è¾“å…¥è¡¨è¾¾å¼å‰ï¼Œè¾“å…¥åŒ–ç®€å’Œæ±‚å¯¼çš„å‘½ä»¤
 */

/*
 * è¾“å…¥çš„è¡¨è¾¾å¼è¯´æ˜Ž
 *  1ã€åªèƒ½åŒ…å?æ•°å­—ã€å­—æ¯ã€ç©ºæ ¼ã€tabã€?ã€?ã€?ã€^ ç­‰å­—ç¬?
 *  2ã€å¯ä»¥åŒ…å«ç©ºæ ¼å’Œåˆ¶è¡¨ç¬?
 *  3ã€æ”¯æŒåŠ å‡æ³•
 *  4ã€å¯ä»¥åœ¨ä½¿ç”¨å˜é‡^æ•°å­—ï¼Œç”¨æ¥è¡¨ç¤ºæŒ‡æ•°ï¼›ä¸æ”¯æŒæ•°å­—åŽåŠ ^å’Œ^åŽåŠ å­—æ¯
 *  5ã€å˜é‡åç§°å¯ä»¥æ˜¯å­—æ¯å’Œæ•°å­—çš„ç»„åˆï¼Œé•¿åº¦æ— é™åˆ¶
 *  6ã€ä¸æ”¯æŒæ‹¬å·
 *  7ã€ä¸æ”¯æŒ*çš„çœç•?
 *  8ã€ä¸æ”¯æŒåŒç±»é¡¹åˆå¹?
 */

/*
 * å‘½ä»¤è¯´æ˜Ž
 *  1ã€æ”¯æŒå¤šå˜é‡åŒ–ç®€
 *  2ã€æ”¯æŒåŒ–ç®€çš„å˜é‡çš„å€¼ä¸ºè´Ÿæ•°
 *  3ã€ä¸æ”¯æŒå°æ•°
 *  4ã€åŒ–ç®€å‘½ä»¤ä¸­å‡ºçŽ°æœªåœ¨è¡¨è¾¾å¼ä¸­å‡ºçŽ°çš„å˜é‡åˆ™å¿½ç•?
 *  5ã€åŒ–ç®€å‘½ä»¤ä¸­å‡ºçŽ°ç±»ä¼¼äºŽ!simplify x y=1,åˆ™å¿½ç•¥x
 *  6ã€åŒ–ç®€å‘½ä»¤ä¸­å‡ºçŽ°é”™è¯¯çš„è¡¨è¾¾å½¢å¼å¦?x=x x=pi x=1.5,åˆ™å¿½ç•¥è¿™ä¸€é¡?
 *  7ã€æ±‚å¯¼å‘½ä»¤ä¸­å‡ºçŽ°æœªåœ¨è¡¨è¾¾å¼ä¸­å‡ºçŽ°çš„å˜é‡åˆ™è¿”å›ž0
 *  8ã€ä¸æ”¯æŒåŒç±»é¡¹åˆå¹?

 */
public class Polynome {

	//--------------------------------------------------------

	// Ò»¸öÊäÈëÁ÷¶ÔÏó£¬ÓÃÓÚ½ÓÊÜ±í´ïÊ½ºÍ×Ö·û´®µÄÊäÈë
	private Scanner scan;
	// Í¨¹ýÊ¹ÓÃÒ»¸öÀàÐÍÎªItemµÄÁÐ±í±£´æµ±Ç°±í´ïÊ½£¬ÊÇÖ÷ÒªµÄ
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	// ÁÙÊ±×Ö·û´®£¬ÓÃÓÚ±£´æÈ¥³ý¿Õ¸ñºÍÖÆ±í·ûÖ®ºóµÄÊäÈë×Ö·û´®
	private String tmpStr = "";
	
	// opCodeÎª²Ù×÷Âë£¬opStrÎª²Ù×÷×Ö¡£ÕâÁ½¸ö±äÁ¿ÔÚgetInput±»ÐÞ¸Ä£¬×÷ÓÃÓÚimpOperation¡£
	// opCode¾ö¶¨ÔÚimpOperationÖÐÖ´ÐÐÊ²Ã´ÀàÐÍµÄ²Ù×÷
	// opStr¸¨ÖúopCodeµÄÊµÏÖ
	//	Ö´ÐÐ»¯¼òÃüÁî£¨!simplify x=1 y=2£©Ê±£¬opStrÖÐ±£´æ x=1 y=2;
	//	Ö´ÐÐÇóµ¼ÃüÁî(!d/d x)Ê±£¬opStrÖÐ±£´æx;
	//	Êä³ö´íÎóÐÅÏ¢ÊÇ£¬opStr±£´æ´íÎóÐÅÏ¢¡£
	private int opCode = 0;
	private String opStr = "";
	// ×Ö·û´®³£Á¿

	// ä¸€ä¸ªè¾“å…¥æµå¯¹è±¡ï¼Œç”¨äºŽæŽ¥å—è¡¨è¾¾å¼å’Œå­—ç¬¦ä¸²çš„è¾“å…?
	private Scanner scan;
	// é€šè¿‡ä½¿ç”¨ä¸€ä¸ªç±»åž‹ä¸ºItemçš„åˆ—è¡¨ä¿å­˜å½“å‰è¡¨è¾¾å¼ï¼Œæ˜¯ä¸»è¦çš?
	private ArrayList<Item> expressionArray = new ArrayList<Item>();
	// ä¸´æ—¶å­—ç¬¦ä¸²ï¼Œç”¨äºŽä¿å­˜åŽ»é™¤ç©ºæ ¼å’Œåˆ¶è¡¨ç¬¦ä¹‹åŽçš„è¾“å…¥å­—ç¬¦ä¸²
	private String tmpStr = "";
	
	// opCodeä¸ºæ“ä½œç ï¼ŒopSträ¸ºæ“ä½œå­—ã€‚è¿™ä¸¤ä¸ªå˜é‡åœ¨getInputè¢«ä¿®æ”¹ï¼Œä½œç”¨äºŽimpOperationã€?
	// opCodeå†³å®šåœ¨impOperationä¸­æ‰§è¡Œä»€ä¹ˆç±»åž‹çš„æ“ä½œ
	// opStrè¾…åŠ©opCodeçš„å®žçŽ?
	//	æ‰§è¡ŒåŒ–ç®€å‘½ä»¤ï¼?simplify x=1 y=2ï¼‰æ—¶ï¼ŒopSträ¸­ä¿å­?x=1 y=2;
	//	æ‰§è¡Œæ±‚å¯¼å‘½ä»¤(!d/d x)æ—¶ï¼ŒopSträ¸­ä¿å­˜x;
	//	è¾“å‡ºé”™è¯¯ä¿¡æ¯æ˜¯ï¼ŒopSträ¿å­˜é”™è¯¯ä¿¡æ¯ã€?
	private int opCode = 0;
	private String opStr = "";
	// å­—ç¬¦ä¸²å¸¸é‡?

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

		// ´òÓ¡ÌáÊ¾ÐÅÏ¢
		po.prompt();
		while(true){
			//¶ÁÈ¡Ò»¸ö×Ö·û´®£¬ÅÐ¶ÏÊÇ±í´ïÊ½»¹ÊÇÃüÁî£¬²¢×öÏàÓ¦µÄ´¦Àí£¬ÒÔ¼°µÃµ½Ò»¸ö²Ù×÷Âë
			po.getInput();
			//¸ù¾ÝÉÏÒ»²½ÖÐ»ñµÃµÄ²Ù×÷ÂëÖ´ÐÐÏàÓ¦µÄ²Ù×÷

		// æ‰“å°æç¤ºä¿¡æ¯
		po.prompt();
		while(true){
			//è¯»å–ä¸€ä¸ªå­—ç¬¦ä¸²ï¼Œåˆ¤æ–­æ˜¯è¡¨è¾¾å¼è¿˜æ˜¯å‘½ä»¤ï¼Œå¹¶åšç›¸åº”çš„å¤„ç†ï¼Œä»¥åŠå¾—åˆ°ä¸€ä¸ªæ“ä½œç 
			po.getInput();
			//æ ¹æ®ä¸Šä¸€æ­¥ä¸­èŽ·å¾—çš„æ“ä½œç æ‰§è¡Œç›¸åº”çš„æ“ä½?

			po.impOperation();
		}
	}
	
	public void prompt(){

		// ÏµÍ³¿ªÊ¼ÔËÐÐºó´òÓ¡ÌáÊ¾ÐÅÏ¢
		// ¿ÉÔÚ´ËÌí¼Ó°üÀ¨°æ±¾£¬°ïÖúµÈµÄÌáÊ¾ÐÅÏ¢

		// ç³»ç»Ÿå¼€å§‹è¿è¡ŒåŽæ‰“å°æç¤ºä¿¡æ¯
		// å¯åœ¨æ­¤æ·»åŠ åŒ…æ‹¬ç‰ˆæœ¬ï¼Œå¸®åŠ©ç­‰çš„æç¤ºä¿¡æ¯

		System.out.println("<Welcome to Polynomials System 1.0>");
	}
	
	
	public void getInput(){
		

		// ¶ÁÈ¡Ò»¸ö×Ö·û´®
		System.out.print(">> ");
		String strInput = scan.nextLine();
		
		// µ±ÊäÈë¿ÕÊ±£¬ÔòÖØÐÂÊäÈë

		// è¯»å–ä¸€ä¸ªå­—ç¬¦ä¸²
		System.out.print(">> ");
		String strInput = scan.nextLine();
		
		// å½“è¾“å…¥ç©ºæ—¶ï¼Œåˆ™é‡æ–°è¾“å…?

		if (strInput.isEmpty()){
			opCode = 0;
			return;
		}
		

		// ´Ë×Ö·û´®ÖÐ²»°üº¬¡°£¡¡±£¬ÔòÎª±í´ïÊ½£»·ñÔò£¬ÎªÃüÁî¡£
		// ²¢½øÐÐ½øÈëÏàÓ¦µÄ´¦Àíº¯Êý

		// æ­¤å­—ç¬¦ä¸²ä¸­ä¸åŒ…å«â€œï¼â€ï¼Œåˆ™ä¸ºè¡¨è¾¾å¼ï¼›å¦åˆ™ï¼Œä¸ºå‘½ä»¤ã€?
		// å¹¶è¿›è¡Œè¿›å…¥ç›¸åº”çš„å¤„ç†å‡½æ•°

		if (strInput.indexOf("!")==-1) expression(strInput);
		else command(strInput);
  	}
	
	public void impOperation() {
		

		// ¸ù¾Ý²Ù×÷ÂëÖ´ÐÐÏàÓ¦²Ù×÷	
		switch(opCode) {
			case -1: exitSys(); break; 	// ÍË³öÏµÍ³
			case 0:				break; 	// ¿Õ²Ù×÷,Ä¬ÈÏÖµ
			case 1:	print();    break;	// ´òÓ¡µ±Ç°±í´ïÊ½
			case 2:	simplify(); break;	// »¯¼ò±í´ïÊ½
			case 3:	derivative();break; // ¶Ô±í´ïÊ½Çóµ¼
			case 4:	errorOutput();break;// Êä³ö´íÎóÐÅÏ¢£¬´íÎóÐÅÏ¢±£´æÔÚopStrÖÐ
			default: 	        break;  // ¿Õ²Ù×÷

		// æ ¹æ®æ“ä½œç æ‰§è¡Œç›¸åº”æ“ä½?
		switch(opCode) {
			case -1: exitSys(); break; 	// é€€å‡ºç³»ç»?
			case 0:				break; 	// ç©ºæ“ä½?é»˜è®¤å€?
			case 1:	print();    break;	// æ‰“å°å½“å‰è¡¨è¾¾å¼?
			case 2:	simplify(); break;	// åŒ–ç®€è¡¨è¾¾å¼?
			case 3:	derivative();break; // å¯¹è¡¨è¾¾å¼æ±‚å¯¼
			case 4:	errorOutput();break;// è¾“å‡ºé”™è¯¯ä¿¡æ¯ï¼Œé”™è¯¯ä¿¡æ¯ä¿å­˜åœ¨opSträ¸?
			default: 	        break;  // ç©ºæ“ä½?

		}
	}
	
	
	private void expression(String strInput){
		

		// ¶ÔÊäÈë StrInput µÄºÏ·¨ÐÔ½øÐÐÅÐ¶¨£¬Í¬Ê±È¥³ý±í´ïÊ½ÖÐµÄ¿Õ¸ñºÍÖÆ±í·û

		// å¯¹è¾“å…?StrInput çš„åˆæ³•æ€§è¿›è¡Œåˆ¤å®šï¼ŒåŒæ—¶åŽ»é™¤è¡¨è¾¾å¼ä¸­çš„ç©ºæ ¼å’Œåˆ¶è¡¨ç¬?

		if (validateExpressionAndStrip(strInput) == false){
			opCode = 4;
			opStr  = "Invalid character inside";
			return;
		}
		

		// ¸ù¾Ý+ºÍ-£¬¶Ô±í´ïÊ½¶ÔÓ¦µÄ×Ö·û´®½øÐÐ²ð·Ö
		// ²¢ÒÔ²ð·ÖºóµÄ¸÷¸ö×Ö·û´®×÷Îª²ÎÊý£¬·Ö±ð½¨Á¢Item¶ÔÏó£¬¼ÓÈëµ½expressionArrayÖÐ

		// æ ¹æ®+å’?ï¼Œå¯¹è¡¨è¾¾å¼å¯¹åº”çš„å­—ç¬¦ä¸²è¿›è¡Œæ‹†åˆ?
		// å¹¶ä»¥æ‹†åˆ†åŽçš„å„ä¸ªå­—ç¬¦ä¸²ä½œä¸ºå‚æ•°ï¼Œåˆ†åˆ«å»ºç«‹Itemå¯¹è±¡ï¼ŒåŠ å…¥åˆ°expressionArrayä¸?

		buildItem();
	}
	
	
	private boolean validateExpressionAndStrip(String str){

		// ¶Ô tmpStr ½øÐÐ³õÊ¼»¯

		// å¯?tmpStr è¿›è¡Œåˆå§‹åŒ?

		tmpStr = "";
		
		char[] chars = str.toCharArray();
		for(char ch : chars){

			// °üº¬³ý Êý×Ö¡¢×ÖÄ¸¡¢¿Õ¸ñ¡¢tab¡¢+¡¢-¡¢*¡¢^ ÒÔÍâ µÄ×Ö·û

			// åŒ…å«é™?æ•°å­—ã€å­—æ¯ã€ç©ºæ ¼ã€tabã€?ã€?ã€?ã€^ ä»¥å¤– çš„å­—ç¬?

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

		// ¶Ô´æ´¢±í´ïÊ½µÄÁÐ±í½øÐÐ³õÊ¼»¯
		expressionArray.clear();
		
		// ½«Ò»¸ö±í´ïÊ½×Ö·û´®¸ù¾Ý+¡¢-,½øÐÐ²ð·Ö
		// µÚÒ»ÏîµÄ·ûºÅÄ¬ÈÏÎªÕý

		// å¯¹å­˜å‚¨è¡¨è¾¾å¼çš„åˆ—è¡¨è¿›è¡Œåˆå§‹åŒ–
		expressionArray.clear();
		
		// å°†ä¸€ä¸ªè¡¨è¾¾å¼å­—ç¬¦ä¸²æ ¹æ?ã€?,è¿›è¡Œæ‹†åˆ†
		// ç¬¬ä¸€é¡¹çš„ç¬¦å·é»˜è®¤ä¸ºæ­£

		String itemStr = "+";
		char[] chars = tmpStr.toCharArray();
		for (char ch : chars){
			if (ch == '+'){
				if (addNewItem(itemStr) == false) return;

				// ÏÂÒ»ÏîµÄ·ûºÅÎªÕý

				// ä¸‹ä¸€é¡¹çš„ç¬¦å·ä¸ºæ­£

				itemStr = "+";
			}
			else if (ch == '-'){
				if (addNewItem(itemStr) == false) return;

				// ÏÂÒ»ÏîµÄ·ûºÅÎª¸º

				// ä¸‹ä¸€é¡¹çš„ç¬¦å·ä¸ºè´Ÿ

				itemStr = "-";
			}
			else itemStr += ch;
		}
		if (addNewItem(itemStr) == false) return;

		// ½«opCodeµÄÖµÖÃÎª1,±íÊ¾¶ÁÈë±í´ïÊ½³É¹¦£¬ÔÚimpOperationÖÐ,¶Ô±í´ïÊ½½øÐÐ´òÓ¡

		// å°†opCodeçš„å€¼ç½®ä¸?,è¡¨ç¤ºè¯»å…¥è¡¨è¾¾å¼æˆåŠŸï¼Œåœ¨impOperationä¸?å¯¹è¡¨è¾¾å¼è¿›è¡Œæ‰“å°

		else opCode = 1;
	}
	
	
	private boolean addNewItem(String itemStr){
		Item newItem = (new Item(itemStr));

		// ´¦ÀíitemStrÊ±£¬³ö´í

		// å¤„ç†itemStræ—¶ï¼Œå‡ºé”™

		if(newItem.errorFlag == true) {
			opCode = 4;
			opStr = "^ error. It should be var^num";
			return false;
		}
		expressionArray.add(newItem);
		return true;
	}
	
	private void command(String strInput){

		// ¼ì²éÊäÈëµÄÃüÁîµÄºÏ·¨ÐÔ

		// æ£€æŸ¥è¾“å…¥çš„å‘½ä»¤çš„åˆæ³•æ€?

		if (validateCommandAndStrip(strInput) == false)
		{
			opCode = 4;
			opStr = "Wrong command";
			return;
		}
		

		// ÅÐ¶ÏÃüÁîÀàÐÍ,²¢ÐÞ¸ÄopCodeºÍopStr

		// åˆ¤æ–­å‘½ä»¤ç±»åž‹,å¹¶ä¿®æ”¹opCodeå’ŒopStr

		getCommandType();
	}
	
	private boolean validateCommandAndStrip(String str){

		// ¼ì²éÊäÈëµÄÃüÁîÊÇ·ñÔÚ£¡Ç°ÓÐ³ý¿Õ¸ñºÍÖÆ±í·ûÖ®ÍâµÄ×Ö·û
		// Èç¹ûÓÐ£¬ÔòËµÃ÷ÊäÈëµÄÃüÁîÓÐÎó

		// æ£€æŸ¥è¾“å…¥çš„å‘½ä»¤æ˜¯å¦åœ¨ï¼å‰æœ‰é™¤ç©ºæ ¼å’Œåˆ¶è¡¨ç¬¦ä¹‹å¤–çš„å­—ç¬¦
		// å¦‚æžœæœ‰ï¼Œåˆ™è¯´æ˜Žè¾“å…¥çš„å‘½ä»¤æœ‰è¯¯

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

		// !!! ¿ÉÌí¼Ó¹¦ÄÜ È¥³ý¿Õ¸ñ

		// !!! å¯æ·»åŠ åŠŸèƒ?åŽ»é™¤ç©ºæ ¼

		tmpStr = str;
		return true;
	}

	
	private void getCommandType(){

		int index;
		if ((index = tmpStr.indexOf(SIMPLIFY)) != -1) {
			index += SIMPLIFY.length() + 1;

			opCode = 2;//»¯¼ò±í´ïÊ½
		}
		else if((index = tmpStr.indexOf(DIFF)) != -1) {
			index += DIFF.length() + 1;
			opCode = 3;//±í´ïÊ½Çóµ¼
		}
		else if((tmpStr.indexOf(EXIT_FLAG) != -1)){
			opCode = -1;//ÍË³ö³ÌÐò
			return;
		}
		else {
			opCode = 4;//ÃüÁî´íÎó

			opCode = 2;//åŒ–ç®€è¡¨è¾¾å¼?
		}
		else if((index = tmpStr.indexOf(DIFF)) != -1) {
			index += DIFF.length() + 1;
			opCode = 3;//è¡¨è¾¾å¼æ±‚å¯?
		}
		else if((tmpStr.indexOf(EXIT_FLAG) != -1)){
			opCode = -1;//é€€å‡ºç¨‹åº?
			return;
		}
		else {
			opCode = 4;//å‘½ä»¤é”™è¯¯

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

		boolean firstFlag = true;//Ò²ÐíÄÜÓÅ»¯

		boolean firstFlag = true;//ä¹Ÿè®¸èƒ½ä¼˜åŒ?

		
		for (int i=0; i<this.expressionArray.size();i++){
			resStr += this.expressionArray.get(i).simplify(opStr).toString(firstFlag);
			firstFlag = false;
		}
		System.out.println(resStr);
	}

	private void derivative() {
		String resStr = "";

		boolean firstFlag = true;//Ò²ÐíÄÜÓÅ»¯

		boolean firstFlag = true;//ä¹Ÿè®¸èƒ½ä¼˜åŒ?

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

		boolean firstFlag = true;//Ò²ÐíÄÜÓÅ»¯

		boolean firstFlag = true;//ä¹Ÿè®¸èƒ½ä¼˜åŒ?

		for (int i=0; i<this.expressionArray.size();i++){
			resStr+=this.expressionArray.get(i).toString(firstFlag);
			firstFlag = false;
		}
		System.out.println(resStr);
	}
	
}

