package cracking.coding.interview.chapter83;

import java.util.Stack;

public class Question02 {

	class MinStack extends Stack<Integer>{
		private static final long serialVersionUID = 8285346633676324699L;
		private Stack<Integer> minStack = new Stack<Integer>();
		//private Integer min = null;
		
		public Integer push(Integer item){
			super.push(item);
			if (minStack.isEmpty() || minStack.peek()<=item) {
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
	}
}
