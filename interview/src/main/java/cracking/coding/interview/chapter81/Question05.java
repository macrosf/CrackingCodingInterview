package cracking.coding.interview.chapter81;

public class Question05 {

	public static String compressBetter(String str){
		int compress_len = countCompress(str);
		if (compress_len>=str.length()){
			return str;
		}
		
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i=1; i<str.length(); i++){
			if (str.charAt(i)==last){
				count++;
			}else {
				sb.append(last);
				sb.append(String.valueOf(count));
				last = str.charAt(i);
				count = 1;
			}
		}
		sb.append(last);
		sb.append(String.valueOf(count));
		return sb.toString();
	}

	private static int countCompress(String str) {
		if (str==null || str.length()==0) return 0;
		
		int size=0;
		int count=1;
		char last = str.charAt(0);
		for (int i=1; i<str.length(); i++) {
			if (last == str.charAt(i)){
				count++;
			}else {
				last = str.charAt(i);
				count = 1;
				size += 1+String.valueOf(count).length();
			}
		}
		size += 1+String.valueOf(count).length();
		return size;
	}
	
//	public static String alternativeCompress(String str){
//		int len = str.length();
//		if(len<=countCompress(str)) return str;
//		
//		char[] array = new char[countCompress(str)];
//		char last = str.charAt(0);
//		int count = 1;
//		for (int i=1; i<len; i++){
//			if (last == str.charAt(i)){
//				count++;
//			}
//			else{
//				copy2array(array, index, count);
//			}
//		}
//	}
	
	public static void main(String args[]){
		String str = "aaabbcccdd";
		System.out.println(str+ "-->" + compressBetter(str));
		
		str = "abcedfg";
		System.out.println(str+ "-->" + compressBetter(str));

		str = "aa";
		System.out.println(str+ "-->" + compressBetter(str));

		str = "a";
		System.out.println(str+ "-->" + compressBetter(str));
	}
}
