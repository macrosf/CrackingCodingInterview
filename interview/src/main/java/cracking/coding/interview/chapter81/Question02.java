package cracking.coding.interview.chapter81;

public class Question02 {
	public static String sort(String s){
		char[] cs=s.toCharArray();
		java.util.Arrays.sort(cs);
		return new String(cs);
	}
	
	//解法1
	public static boolean permutation(String s, String t){
		if (s.length()!=t.length()) return false;
		
		return sort(s).equals(sort(t));
	}
	
	//解法2
	public static boolean permutation2(String s, String t){
		if (s.length()!=t.length()) return false;
		
		int[] check = new int[256];
		for (int i=0; i<s.length(); i++){
			check[s.charAt(i)]++;
		}
		for (int i=0; i<t.length(); i++){
			check[t.charAt(i)]--;
			if (check[t.charAt(i)]<0) return false;
		}
		return true;
	}
	public static void main(String[] args){
		String s = "AabbccDD";
		String t = "bbDDccAA";
		System.out.println(permutation(s,t));
		System.out.println(permutation2(s,t));
	}
}
