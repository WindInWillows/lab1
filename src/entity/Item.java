package entity;

import java.util.ArrayList;

public class Item {
	public int coe=1;
	public ArrayList<Node> item = new ArrayList<Node>();
	public boolean errorFlag = false;
	/*
	 *杈撳叆琛ㄨ揪寮忛」鍜岄」鐨勬璐燂紝寤虹珛璧疯〃杈惧紡椤圭殑鏁版嵁缁撴瀯锛�
	 *	琛ㄨ揪寮忛」鐨勫彉閲忛儴鍒嗙敱涓�涓狝rrayList缁勬垚
	 *	琛ㄨ揪寮忕殑绯绘暟鍖呭惈姝ｈ礋
	 */
	//'-','11*x*y*x*8' => -88,Node(x,2),Node(y,1)
	public Item(String exp, boolean isPositive) {
		////澶勭悊绯绘暟鐨勬璐熼棶棰�
		if( !isPositive){
			this.coe *= -1;
		}
		////鎷嗗垎涓�涓椤瑰紡涓竴椤�
		//灏�'11*x*y*x*8'鎷嗗垎涓�   鍒楄〃[11 x y x 8]
		String[] tmp_list=exp.split("\\*");
		for(int i=0;i<tmp_list.length;i++){
			String tmp_i=tmp_list[i];
			Integer num=isNumber(tmp_i);
			
			Integer power = 1;
			if(tmp_i.indexOf("^") != -1) {
				String[] tmmp = tmp_i.split("\\^");
				power=isNumber(tmmp[1]);
				if (power == null ){
					errorFlag = true;
					return;
				}
				if (isNumber(tmmp[0]) != null ){
					errorFlag = true;
					return;
				}
				tmp_i = tmmp[0];
			}
			
			// num=null 琛ㄧずtmp_i涓嶆槸鏁板瓧锛屽惁鍒欒繑鍥炶繖涓暟瀛楋紙int锛夛紝灏嗚繖涓暟瀛楃洿鎺ヤ笌绯绘暟鐩镐箻鍗冲彲
			if( num!= null ){
				this.coe *= num;
			}
			// tmp_i 涓哄彉閲忥紝鍦ㄤ笅闈㈢殑浠ｇ爜涓垽鏂彉閲弔mp_i鏄惁鍑虹幇杩�
			else{
				//鍒ゆ柇瀛楃tmp_i鏄惁宸茬粡鍑虹幇鐨勬爣蹇�
				boolean appear_flag=false;// 锛佷篃璁歌兘琚紭鍖�
				//閬嶅巻tmp_list涓凡缁忓鐞嗙殑閮ㄥ垎锛屽垽鏂彉閲弔mp_i鏄惁鍑虹幇杩�
				for(int j=0;j<this.item.size();j++){
					Node Node_j=this.item.get(j);
					// 鍙橀噺tmp_i鍑虹幇鍦ㄤ箣鍓嶅鐞嗙殑瀛楃涓蹭腑锛屽鍘熷彉閲忓搴旇妭鐐圭殑鎸囨暟+1
					if(Node_j.v.equals(tmp_i)){
						Node_j.inc(power);
						appear_flag=true;
					}
				}
				//娣诲姞鏈嚭鐜扮殑鍙橀噺
				if (appear_flag==false){
					this.item.add(new Node(tmp_i, power));
				}
			}
		}
	}
	
	public Item() {}

	public Item(String itemStr) {
		this(itemStr.substring(1),itemStr.toCharArray()[0] == '+' );
	}

	public Item diff(String x) {
		Item tmp = getCopy();
		for(int i=0;i<tmp.item.size();i++){
			if (tmp.item.get(i).v.equals(x)){
				tmp.coe *= tmp.item.get(i).power;
				tmp.item.get(i).dec();
				return tmp;
			}
		}
		return null;
	}
	private Item getCopy(){
		// 涔熻鑳戒紭鍖�
		Item res = new Item();
		res.coe = this.coe;
		for(int i=0;i<this.item.size();i++){
			res.item.add(this.item.get(i).getCopy());
		}
		return res;
	}
	
	//杈撳嚭褰撳墠椤�
	public String toString(Boolean firstFlag) {
		String str = "";
		if (coe == 0) return "";
		if(coe > 0 && !firstFlag)
			str += "+";
		str += coe;
		for(Node n : item) {
			if(n.power > 1 && !n.v.equals("")){
				if(str.length() > 0) str += "*";
				str += n.v+"^"+n.power;
			}
			else if(n.power == 1 && !n.v.equals("")){
				if(str.length() > 0) str += "*";
				str += n.v;
			}
		}
		return str;
	}
	
	//鍒ゆ柇涓ら」鏄惁鑳藉悎骞�
	private boolean equals(Item it) {
		ArrayList<Node> arr = it.item;
		for(Node n : arr){
			if(!this.hasNode(n))
				return false;
		}
		return true;
	}
	
	//鍒ゆ柇璇ラ」涓槸鍚︽湁姝ゅ彉閲�
	private boolean hasNode(Node n) {
		for(Node nn:item){
			if(nn.equals(n))
				return true;
		}
		return false;
	}
	
	private boolean hasVarialbe(Node n) {
		for(Node nn:item){
			if(nn.v.equals(n.v))
				return true;
		}
		return false;
	}
	
	public Node hasVarialbe(String v) {
		for(Node nn:item){
			if(nn.v.equals(v))
				return nn;
		}
		return null;
	}	
	
	//涓鸿〃杈惧紡璧嬪�硷紝鏀寔澶氫釜鍙橀噺璧嬪��
	//杩斿洖null璇存槑鎵句笉鍒�
	public Item simplify(String value) {
		Item tmp = getCopy();
		
		String[] strArray = {value};
		if (value.indexOf(" ") != -1){
			strArray = value.split(" ");
		}
		for (String tmpStr : strArray){
			if (tmpStr.indexOf("=") != -1){
				String[] ss = tmpStr.split("=");
				String name = ss[0];
				Integer v = isNumber(ss[1]);
				if (v == null) continue;
				Node n = null;
				if((n = tmp.hasVarialbe(name)) != null){
					tmp.coe *= (int)Math.pow(v, n.power);
					tmp.item.remove(n);
				}
			}
		}
		return tmp;
	}
	
	private Integer isNumber(String s) {
		char[] chs = s.toCharArray();
		Integer ans = 0;
		int flag = 1;
		if(chs[0] == '-') {
			flag = -1;
		}
		
		for(int i=chs[0]=='-'?1:0; i<chs.length; i++) {
			if(chs[i] >= '0' && chs[i] <= '9'){
				ans = ans*10+(int)chs[i] - (int)'0';
			} else {
				return null;
			}
		}
		return ans*flag;
	}
}