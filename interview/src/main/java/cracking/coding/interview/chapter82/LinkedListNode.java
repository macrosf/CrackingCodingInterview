package cracking.coding.interview.chapter82;

public class LinkedListNode {

	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int data){
		this.data = data;
		next = null;
	}

	public LinkedListNode append(int i) {
		LinkedListNode tail = getTail();
		tail.next = new LinkedListNode(i);
		return this;
	}

	public LinkedListNode append(LinkedListNode node){
		LinkedListNode tail = getTail();
		tail.next = node;
		return this;
	}

	private LinkedListNode getTail() {
		LinkedListNode cur = this;
		while(cur.next != null) {
			cur = cur.next;
		}
		return cur;
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
