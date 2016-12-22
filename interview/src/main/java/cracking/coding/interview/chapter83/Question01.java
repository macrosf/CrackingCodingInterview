package cracking.coding.interview.chapter83;

public class Question01 {

	class tripleStack {
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
			return buffer[pos];
		}
		
		//get absolute position
		private int getAbsPos(int stackNum) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
