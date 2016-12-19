package cracking.coding.interview.chapter82;

import java.util.Hashtable;

public class Question01 {

	public static void deleteDup(LinkedListNode n){
		Hashtable<Integer,Boolean> ht = new Hashtable<Integer,Boolean>();
		LinkedListNode previous = null;
		while (n!=null) {
			if (ht.containsKey(n.data)){
				previous.next = n.next;
			}else {
				ht.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}//end of while
	}
	
	public static void deleteDup2(LinkedListNode n){
		if (n==null || n.next == null) return;
		
		while (n.next != null) {
			LinkedListNode runner = n;
			while (runner.next != null) {
				if ( n.data == runner.next.data) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			n = n.next;
		}
	}
	
	
	public static void main(String[] args){
		LinkedListNode top = new LinkedListNode(10);
		top.append(20);
		top.append(30);
		top.append(40);
		top.append(30);
		top.append(50);
		System.out.println("before...");
		top.print();
		System.out.println("after...");
		//deleteDup(top);
		deleteDup2(top);
		top.print();
	}
}
