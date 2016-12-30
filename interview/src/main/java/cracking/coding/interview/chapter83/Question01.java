package cracking.coding.interview.chapter83;

public class Question01 {

	class TripleStack {
		int stackSize = 10;
		int[] buffer = new int[stackSize*3];
		int[] stackPointer = {-1,-1,-1};
		
		void push(int stackNum, int data) throws Exception{
			if (stackPointer[stackNum]>=stackSize-1) 
				throw new Exception("not enough space!");
			
			int pos = getAbsPos(stackNum)+1;
			buffer[pos] = data;
			stackPointer[stackNum]++;
		}

		int pop(int stackNum) throws Exception{
			int data = peek(stackNum);
			stackPointer[stackNum]--;
			return data;
		}
		
		int peek(int stackNum) throws Exception{
			if (stackPointer[stackNum] == -1) 
				throw new Exception("nothing to pop!");
			int pos = getAbsPos(stackNum);
			if (pos == -1) return -1;
			else return buffer[pos];
		}
		
		//get absolute position
		private int getAbsPos(int stackNum) {

			return stackNum*stackSize + stackPointer[stackNum];
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		TripleStack ts = new Question01().new TripleStack();
		ts.push(0, 10); ts.push(0, 20); ts.push(0, 30);
		ts.push(1, 12); 
		ts.push(1, 22); 
		ts.push(2, 13); ts.push(2, 23); ts.push(2, 33); ts.push(2, 43);
		System.out.println("peek stack01:"+ts.peek(0));
		System.out.println("peek stack02:"+ts.peek(1));
		System.out.println("peek stack03:"+ts.peek(2));
		
		System.out.println("pop stack01:" + ts.pop(0)); 
		System.out.println("pop stack02:" + ts.pop(1)); 
		System.out.println("pop stack03:" + ts.pop(2));
		
		System.out.println("peek stack01:"+ts.peek(0));
		System.out.println("peek stack02:"+ts.peek(1));
		System.out.println("peek stack03:"+ts.peek(2));
		
	}
}
