package cracking.coding.interview.chapter82;

public class LinkedListNode {

	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int data){
		this.data = data;
		next = null;
	}

	public LinkedListNode append(int i) {
		LinkedListNode cur = this;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = new LinkedListNode(i);
		return this;
	}

	public void print(){
		LinkedListNode cur = this;
		System.out.print("LinkedList: ["+cur.data);
		
		while (cur.next != null) {
			cur = cur.next;
			System.out.print(", " + cur.data);
		}
		System.out.println("]");
	}

	public LinkedListNode insertBefore(int i) {
		LinkedListNode n = new LinkedListNode(i);
		n.next = this;
		return n;
	}
	
}
