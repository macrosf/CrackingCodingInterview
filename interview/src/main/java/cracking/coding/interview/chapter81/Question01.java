package cracking.coding.interview.chapter81;

public class Question01 {
	public static boolean check(String str){
		if (str.length()>256) return false;
		
		boolean[] flags= new boolean[256];
		for (int i=0; i<str.length(); i++) {
			int asc=str.charAt(i);
			if (flags[asc]) return false;
			else flags[asc]=true;
		}
		return true;
	}
	
	public static boolean isUniqueChars(String str){
		if (str.length()>26) return false;
		int check =0;
		for (int i=0; i<str.length(); i++) {
			int offset = str.charAt(i)-'a';
			if ((check & 1<<offset)>0) {
				return false;
			}
			check |= 1<<offset;
		}
		return true;
	}
	public static void main(String[] args) {
		String s ="aBCdefghIJLMn";
		System.out.println(check(s));
	}
}
