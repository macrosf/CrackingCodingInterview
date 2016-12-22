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
		while (slow.next != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args){
		
	}
}
