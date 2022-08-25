package Lotto;

import java.util.Scanner;

public class LottoProgram {
    private static int cc = 1;
	public static void main(String [] args){
     
	   
      Machine play = new Machine();
      Scanner in = new Scanner(System.in);
      
      System.out.println("*************************************");
      System.out.println("♨로또 프로그램입니다.♨");
      System.out.println("*************************************");
      System.out.println("1등 번호 6개 적중.");
      System.out.println("2등 번호 5개 및 보너스 번호 적중.");
      System.out.println("3등 번호 5개 적중.");
      System.out.println("4등 번호 4개 적중.");
      System.out.println("5등 번호 3개 적중.");
      System.out.println("*************************************");
      
      while(true) {
      
      if(cc!=1) {
       System.out.println(cc+"번째 로또 프로그램 실행 중입니다..♨");  
      }
      System.out.println("[1]수동 시작하기\n[2]자동 시작하기.\n[3]종료하기");
      System.out.println("--------------------------\n");
     
      play.setSelect(in.nextInt());
      if(play.getSelect()==3) {
    	  break;
      }
      play.user(play.getSelect());
      play.Ball();
      play.machine();
      play.Compare();
      System.out.println("--------------------------\n");
      cc++;
      }
   }
}
