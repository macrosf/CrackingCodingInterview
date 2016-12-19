package cracking.coding.interview.chapter82;

public class Question02 {

	public static LinkedListNode nthToLast(LinkedListNode top, int k){
		if (top == null || k <= 0) return null;
		
		LinkedListNode cur = top;
		LinkedListNode run = top;
		for (int i=0; i < k - 1; i++){ /*寻找倒数第一个节点时，cur和run应该是重合的*/
			if (run.next == null) return null;
			run = run.next;
		}
		
		while(run.next != null){
			run = run.next;
			cur = cur.next;
		}
		return cur;
	}
	
	public static void main(String[] args){
		LinkedListNode top = new LinkedListNode(10);
//		top.append(20);
//		top.append(30);
//		top.append(40);
//		top.append(30);
//		top.append(50);
		int nth = 1;
		LinkedListNode node = nthToLast(top, nth);
		if (node == null)
			System.out.println("last "+ nth +"th node is null");
		else
			System.out.println("last "+ nth +"th node is "+ node.data);
	}
}
