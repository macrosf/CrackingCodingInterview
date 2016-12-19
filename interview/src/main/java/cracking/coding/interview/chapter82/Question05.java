package cracking.coding.interview.chapter82;

public class Question05 {
	
	public static void main(String args[]){
		//倒序链表测试
		LinkedListNode t1 = new LinkedListNode(7)
				.append(1).append(6);
		LinkedListNode t2 = new LinkedListNode(5)
				.append(9).append(2);
		chainAdd(t1, t2).print();//617+295
		
		chainAdd(null, t2).print();
		
		LinkedListNode t3 = new LinkedListNode(7).append(1);
		chainAdd(t3, t2).print();//17+295
		
		System.out.println("------------------------------");
		//正序链表测试
		LinkedListNode t10 = new LinkedListNode(7)
				.append(1).append(6);
		System.out.println(chain2int_v2(t10));
		LinkedListNode t11 = new LinkedListNode(5)
				.append(9).append(2);
		chainAdd2(t10, t11).print();//716+592
		
		chainAdd2(null, t11).print();
		LinkedListNode t13 = new LinkedListNode(7).append(1);
		chainAdd2(t13, t11).print();//71+592
	}
	
	//数字按倒序存入链表相加
	public static LinkedListNode chainAdd(
			LinkedListNode n1, LinkedListNode n2){
		int t1 = chain2int(n1);
		int t2 = chain2int(n2);
		return int2chain(t1+t2);
	}

	private static LinkedListNode int2chain(int n) {
		int power = 10;
		int mod = n % power;
		LinkedListNode top = new LinkedListNode(mod);
		while (n-mod > 0) {
			int t = ((n-mod)%(power*10))/power;
			top.append(t);
			mod += t*power;
			power*=10;
		}
		return top;
	}

	private static int chain2int(LinkedListNode node) {
		if (node==null) return 0;
		int sum = node.data;
		int power = 1;
		node = node.next;
		while (node != null){
			power *= 10;
			sum += node.data*power;
			node = node.next;
		}
		return sum;
	}
	
	//数字按正序存入链表相加
	public static LinkedListNode chainAdd2(
			LinkedListNode n1, LinkedListNode n2){
		int t1 = chain2int_v2(n1);
		int t2 = chain2int_v2(n2);
		return int2chain_v2(t1+t2);
	}

	private static LinkedListNode int2chain_v2(int n) {
		int power = 10;
		int mod = n % power;
		LinkedListNode top = new LinkedListNode(mod);
		while (n-mod > 0) {
			int t = ((n-mod)%(power*10))/power;
			top = top.insertBefore(t);
			mod += t*power;
			power*=10;
		}
		return top;		
	}

	private static int chain2int_v2(LinkedListNode top) {
		if (top == null) return 0;
		int sum = top.data;
		int power = 1;
		top = top.next;
		while (top != null){
			power *= 10;
			sum += (sum*power+top.data);
			top = top.next;
		}
		return sum;
	}
}
