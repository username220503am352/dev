package test;

public class ApiTest {
	
	public void test01() {
		String str = "Hello World";
		
		//charAt : 특정 인덱스의 '문자' 리턴 
//		char result = str.charAt(0);
		
		//compareTo : 사전순으로 비교
//		int result = str.compareTo("hlii");
		
		//concat :
//		String result = str.concat("zzz");
		
		//substring : 인덱스를 이용해서 문자열 자름
//		String result = str.substring(3,7);
		
		//lowerCase , upperCase
		String result = str.toUpperCase();
		
		//print
		System.out.println(result);
		
	}//test01
	
	public void test02() {
		//StringBuilder , StringBuffer
		
//		StringBuilder sb = new StringBuilder();
//		sb.append("zz");
//		sb.append("abc");
//		System.out.println(sb);
		
		StringBuffer sb = new StringBuffer();
		sb.append("zz");
		sb.append("abc");
		System.out.println(sb);
	}
	
	public void test03() {
		//Math
		
		int result = Math.abs(-77);
		
		System.out.println(result);
		
	}
	
}//class












