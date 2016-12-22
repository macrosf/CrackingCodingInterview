package cracking.coding.interview.chapter82;

public class Question06 {

	public static LinkedListNode findBeginning(LinkedListNode head){
		if (head == null) return null;
		
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) break;
		}
		
		//if no cricle exists
		if (fast == null || fast.next == null) return null;
		
		slow = head;
		while (slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args){
		LinkedListNode top = new LinkedListNode(1)
				.append(2)
				.append(3)
				.append(4);
		LinkedListNode n = new LinkedListNode(5);
		top.append(n);
		n.next = top.next.next; //n.next -> 3
		
		LinkedListNode begin = findBeginning(top);
		if (begin==null) System.out.println("no connection");
		else System.out.println(begin.data);
	}
}
