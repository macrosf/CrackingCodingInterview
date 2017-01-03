package cracking.coding.interview.chapter83;

import java.util.Iterator;
import java.util.Stack;

public class Question02 {

	class MinStack extends Stack<Integer>{
		private static final long serialVersionUID = 8285346633676324699L;
		private Stack<Integer> minStack = new Stack<Integer>();
		//private Integer min = null;
		
		public Integer push(Integer item){
			super.push(item);
			if (minStack.isEmpty() || minStack.peek()>=item) {
				minStack.push(item);
			}
			return item;
		}
		
		public Integer pop(){
			if (super.isEmpty()) return Integer.MAX_VALUE;
			
			Integer item = super.pop();
			if (item == minStack.peek()) {
				minStack.pop();
			}
			return item;
		}
		
		public Integer min(){
			if (minStack.isEmpty()) return Integer.MAX_VALUE;
			else return minStack.peek();
		}
		
		public void printMin(){
			
			System.out.print("stack elements is: ");
			Iterator<Integer> i = this.iterator();
			while(i.hasNext()){
				System.out.print(i.next()+", ");
			}
			System.out.println("while min is: "+min());
		}
	}
	
	public static void main(String[] args) {
		MinStack min_stack = new Question02().new MinStack();
		min_stack.push(3);
		min_stack.printMin();
		min_stack.push(4);
		min_stack.printMin();
		min_stack.push(5);
		min_stack.printMin();
		min_stack.push(2);
		min_stack.printMin();
		min_stack.push(6);
		min_stack.printMin();
		min_stack.push(7);
		min_stack.printMin();
		
		while(!min_stack.isEmpty()) {
			min_stack.printMin();
			min_stack.pop();
		}
	}
}
