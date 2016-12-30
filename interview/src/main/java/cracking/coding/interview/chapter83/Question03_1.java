package cracking.coding.interview.chapter83;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question03_1 {

	class Node {
		int data = Integer.MAX_VALUE;
		
		public Node(int data){
			this.data = data;
		}
	}//end of class Node
	
	class SetOfStack{
		List<Stack<Node>> stack_list = new ArrayList<Stack<Node>>();
		int capability = 0;
		
		public SetOfStack(int capability){
			this.capability = capability;
		}
		
		public SetOfStack push(int data){
			Stack<Node> last_stack = getLastStack();
			//not any stack exists or last stack is full
			if (last_stack == null || last_stack.size()==capability) {	
				Stack<Node> stack = new Stack<Node>();
				stack.push(new Node(data));
				stack_list.add(stack);
			}else {
				last_stack.push(new Node(data));
			}
			return this;
		}
		
		public Node pop() throws Exception{
			Stack<Node> last_stack = getLastStack();
			if (last_stack==null) throw new Exception("empty stack!");
			Node result = last_stack.pop();
			if (last_stack.size()==0){
				stack_list.remove(stack_list.size()-1);
			}
			return result;
		}
		
		public Stack<Node> getLastStack() {
			if (stack_list.isEmpty()) return null;
			else return stack_list.get(stack_list.size()-1);
		}
		
		public void print(){
//			for (Stack<Node> stack: stack_list){
//				System.out.print(stack.toString());
//			}
			
			for (int i=0; i<stack_list.size(); i++){
				System.out.print("Stack no."+(i+1)+": ");
				@SuppressWarnings("unchecked")
				Stack<Node> stack = (Stack<Node>) stack_list.get(i).clone();
				while (!stack.isEmpty()){
					System.out.print(stack.pop().data+",");
				}
				System.out.println("");
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		SetOfStack set_stack = new Question03_1().new SetOfStack(5);
		set_stack.push(1).push(2).push(3).push(4).push(5)
			.push(6).push(7).push(8).push(9).push(10).push(11);
		System.out.println("Before pop---------");
		set_stack.print();
		System.out.println("pop :"+set_stack.pop().data);
		System.out.println("pop :"+set_stack.pop().data);
		System.out.println("pop :"+set_stack.pop().data);
		System.out.println("pop :"+set_stack.pop().data);
		System.out.println("pop :"+set_stack.pop().data);
		System.out.println("After pop---------");
		set_stack.print();
	}
}
