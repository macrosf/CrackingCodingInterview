package cracking.coding.interview.chapter83;

import java.util.ArrayList;
import java.util.List;

public class Question03_2 {

	 class Node {
		int data = Integer.MAX_VALUE;
		Node below = null;	//上方节点（后入栈的节点）
		Node above = null;	//下方节点（先入栈的节点）
		
		public Node(int data){
			this.data = data;
		}
	}//end of class Node

	class Stack {
		Node top = null;	//指向堆栈顶部节点
		Node bottom = null;	//指向堆栈底部节点
		int count = 0;
		
		void push(Node n){
			if (top == null) {
				bottom = n;
				//top = n;
			}else {
				n.below = top;
				top.above = n;
				//top = n;
			}
			top = n;
			count++;
		}
		
		Node pop() throws Exception{
			if (top == null) throw new Exception("empty stack!");

			Node n = top;
			top = top.below;
			if (top == null) bottom = null;
			else {
				top.above = null;
			}
			count--;
			return n;
		}
		
		boolean isEmpty(){
			return top==null;
		}

		public int size() {
			return count;
		}
	}
	
	class SetOfStack{
		List<Stack> stack_list = new ArrayList<Stack>();
		int capability = 0;
		
		public SetOfStack(int capability){
			this.capability = capability;
		}
		
		public SetOfStack push(int data){
			Stack last_stack = getLastStack();
			//not any stack exists or last stack is full
			if (last_stack == null || last_stack.size()==capability) {	
				Stack stack = new Stack();
				stack.push(new Node(data));
				stack_list.add(stack);
			}else {
				last_stack.push(new Node(data));
			}
			return this;
		}
		
		public Node pop() throws Exception{
			Stack last_stack = getLastStack();
			if (last_stack==null) throw new Exception("empty stack!");
			Node result = last_stack.pop();
			if (last_stack.size()==0){
				stack_list.remove(stack_list.size()-1);
			}
			return result;
		}
		
		//index从1开始
		public Node popAt(int index) throws Exception {
			if (index>stack_list.size() || index < 1) {
				throw new Exception("stack not exists");
			}
			
			if (index == stack_list.size()) return pop();
			
			//弹出指定堆栈的顶部节点，同时将右侧堆栈的顶部节点塞入本堆栈的底部
			Stack stack = stack_list.get(index-1);
			Node n = stack.pop();
			
			//如果每个堆栈的高度只有1，那么弹出指定堆栈的节点后直接删除该堆栈
			if (stack.size() == 0) stack_list.remove(index-1);
			//否则将后一个堆栈的顶部节点填充至本堆栈底部
			else shiftLeft(index);
			
			return n;
		}
		
		//index从1开始
		private void shiftLeft(int index) {
			if (index > stack_list.size()-1) return;
			
			Stack left = stack_list.get(index - 1);
			Stack right = stack_list.get(index);
			
			//detach from right stack bottom
			Node shift_node = right.bottom;
			right.bottom = shift_node.above;
			if (right.bottom != null) right.bottom.below = null;
			else right.top = null;	//如果对账的底部节点（bottom）为null，说明堆栈为空，则该堆栈的顶部节点（top）也为空
			right.count--;
			if (right.count==0) stack_list.remove(index);	//如果该堆栈为空则从list中移除该堆栈
			
			//attach to left stack top
			shift_node.below = left.top;
			shift_node.above = null;
			
			if (left.top != null) left.top.above = shift_node;
			else left.bottom = shift_node;	//如果对账的顶部节点（top）为null，说明堆栈为空，则该堆栈的底部节点（bottom）也为应指向shift_node
			left.top = shift_node;
			left.count++;
			
			shiftLeft(index + 1);
		}

		public Stack getLastStack() {
			if (stack_list.isEmpty()) return null;
			else return stack_list.get(stack_list.size()-1);
		}
		
		public void print(){
			
			for (int i=0; i<stack_list.size(); i++){
				System.out.print("Stack no."+(i+1)+": ");
				Node cur = stack_list.get(i).top;
				
				while (cur != null){
					System.out.print(cur.data+",");
					cur = cur.below;
				}
				System.out.println("");
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		SetOfStack set_stack = new Question03_2().new SetOfStack(5);
		set_stack.push(1).push(2).push(3).push(4).push(5)
			.push(6).push(7).push(8).push(9).push(10).push(11);
		System.out.println("Before pop---------");
		set_stack.print();
//		System.out.println("pop :"+set_stack.pop().data);
//		System.out.println("pop :"+set_stack.pop().data);
//		System.out.println("pop :"+set_stack.pop().data);
//		System.out.println("pop :"+set_stack.pop().data);
//		System.out.println("pop :"+set_stack.pop().data);
		System.out.println("pop at stack no.2: " + set_stack.popAt(2).data);
		System.out.println("After pop---------");
		set_stack.print();
		System.out.println("pop at stack no.1: " + set_stack.popAt(1).data);
		System.out.println("pop at stack no.1: " + set_stack.popAt(1).data);
		System.out.println("pop at stack no.1: " + set_stack.popAt(1).data);
		System.out.println("pop at stack no.1: " + set_stack.popAt(1).data);
		System.out.println("pop at stack no.1: " + set_stack.popAt(1).data);
		System.out.println("After pop2---------");
		set_stack.print();
	}
}
