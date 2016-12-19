package chapter82;

public class LinkedListNode {

	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int data){
		this.data = data;
		next = null;
	}

	public void append(int i) {
		LinkedListNode cur = this;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = new LinkedListNode(i);
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
	
}
