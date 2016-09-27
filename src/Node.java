//insert one line in this file.
<<<<<<< HEAD
//insert another line
=======
//insert another line in this file.
//insert the third line
>>>>>>> b4b6e6ac069acbc82299239804ef130763d91e46
public class Node {
	public Node(String v,int power) {
		this.power = power;
		this.v = v;
	}

	public Node() {
	}

	public int power;
	public String v;
	
	public Node(String v) {
		this.power = 1;
		this.v = v;
	}
	
	public void inc(int power) {
		this.power += power;
	}
	
	public void dec() {
		this.power--;
	}
	
	public Node getCopy(){
		Node res = new Node();
		res.power = this.power;
		res.v = this.v;
		return res;
	}
	
	public boolean equals(Node n) {
		return n.v.equals(this.v)
		&& n.power == this.power;
	}
}

