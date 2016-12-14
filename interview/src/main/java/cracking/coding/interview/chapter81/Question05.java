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
	
	public static String alternativeCompress(String str){
		int len = str.length();
		if(len<=countCompress(str)) return str;
		
		char[] array = new char[countCompress(str)];
		char last = str.charAt(0);
		int count = 1;
		int index = 0;
		for (int i=1; i<len; i++){
			if (last == str.charAt(i)){
				count++;
			}
			else{
				index = copy2array(array, index, last, count);
				last = str.charAt(i);
				count=1;
			}
		}
		
		copy2array(array, index, last, count);
		return new String(array);
	}
	
	private static int copy2array(char[] array, int index, char last, int count) {
		array[index] = last;
		String s = String.valueOf(count);
		for (int i=1; i<=s.length(); i++) {
			array[index+i] = s.charAt(i-1);
		}
		return index+s.length()+1;
	}

	public static void main(String args[]){
		String str = "aaabbcccdd";
		System.out.println(str+ "-->" + compressBetter(str));
		System.out.println(str + "-->" + alternativeCompress(str));
		
		str = "abcedfg";
		System.out.println(str+ "-->" + compressBetter(str));

		str = "aa";
		System.out.println(str+ "-->" + compressBetter(str));

		str = "a";
		System.out.println(str+ "-->" + compressBetter(str));
	}
}
