package cracking.coding.interview.chapter82;

import java.util.Stack;

public class Question07 {

	public static boolean isPalindrome(LinkedListNode head){
		if (head == null) return false;
		
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null){
			//push to stack
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//if there's odd number of nodes
		if (fast!= null){
			slow = slow.next;
		}
		
		//compare stack with slow
		while(slow != null) {
			if (slow.data != stack.pop()) return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1)
				.append(2).append(3).append(2).append(1);
		System.out.println(isPalindrome(head));
		
		head = new LinkedListNode(1)
				.append(2).append(3).append(2).append(4);
		System.out.println(isPalindrome(head));
		
		head = new LinkedListNode(1)
				.append(2).append(3).append(3).append(2).append(1);
		System.out.println(isPalindrome(head));
		
	}
}
