package main;

public class MainSwitch {

	public static void main(String[] args) {
		
		//switch
		/*
		 * 값이 같은지 비교 (==)
		 * 
		 * [문법]
		 * switch(기준값){
		 * case 비교값1 : 실행내용; break;
		 * case 비교값2 : 실행내용; break;
		 * case 비교값3 : 실행내용; break;
		 * ... //case 는 원하는 만큼 작성
		 * default : 실행내용;
		 * }
		 */
		
		String name = "심원용";
		switch(name) {
		case "홍길동" : 
			System.out.println("길동 ㅎㅇ");
			System.out.println("반가워요 길동 ㅋㅋㅋ");
			break;
		case "심원용" : 
			System.out.println("원용 ㅎㅇ"); 
			System.out.println("반가워요 원용 ㅋㅋㅋ");
			if(10 > 0) {
				System.out.println("당연히 10이 더 크지");
			}
			break;
		case "김철수" : 
			System.out.println("철수 ㅎㅇ"); 
			System.out.println("반가워요 원용 ㅋㅋㅋ");
			break;
		}

		
		
		
		
	}//main

}//class






































