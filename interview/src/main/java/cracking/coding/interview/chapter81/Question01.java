package cracking.coding.interview.chapter81;

public class Question01 {
	//无重复的字符时，返回true
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
	
	//unicode版
	public static boolean checkUnicode(String unicodeStr){
		if (unicodeStr.length()>65535) return false;
		
		boolean[] check = new boolean[65535];
		String[] hex = unicodeStr.split("\\\\u");
		for (int i=0; i<hex.length; i++){
			if (hex[i].trim().length()==0) continue;
			int pos = Integer.parseInt(hex[i], 16);
			if(check[pos]) return false;
			check[pos] = true;
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
	
	public static String string2unicode(String str){
		StringBuffer unicode = new StringBuffer();
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			unicode.append("\\u"+Integer.toHexString(c));
		}
		return unicode.toString();
	}
	
//	public static boolean checkUnicode(String str){
//		
//	}
	
	public static void main(String[] args) {
		String s ="aBCdefghIJLMa";
		System.out.println(check(s));
		
		System.out.println(isUniqueChars(s));
		
		String unicode = "后知先觉ABcd";
		System.out.println(string2unicode(unicode));
		
		System.out.println(checkUnicode(string2unicode(unicode)));
	}
}
