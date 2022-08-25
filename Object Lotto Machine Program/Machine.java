package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Machine {

   private int sum = 0;
   private int Bonus;
   private int select;
   Random random = new Random();
   private List<Integer> ball = new ArrayList<Integer>();
   private List<Integer> Lotto = new ArrayList<Integer>();
   private List<Integer> User = new ArrayList<Integer>();
   Scanner in = new Scanner(System.in);
   
   public void user(int select) {
       
       if(select==1) {
       
       for(int i=0;i<6;i++) {
         User.add(in.nextInt());
       }
       }
       else if(select==2) {
    	   User.clear();
           System.out.print("자동으로 생성된 번호는:");
           for(int i=0; i < 6; i++) {   
        	   User.add(random.nextInt(45)+1);
               for(int j=0;j<i;j++) {
                  if(User.get(i) == User.get(j)) {
                     User.remove(i);
                	  i--;
                  }
               }
               System.out.print(User.get(i)+ " ");
           }
           System.out.print("입니다.\n");
           
           System.out.print("정렬된 자동 생성된 번호는:");
           Collections.sort(User);
           for(int i=0; i < 6; i++) { 
               System.out.print(User.get(i)+ " ");
           }
           System.out.print("입니다.\n");
           System.out.println(">");
       }
       else {
          System.out.println("잘못 입력하셨습니다.");
       }
       
      
   }
 
   

public void Ball() {   

      for(int i=1;i<=45;i++) {
      ball.add(i);   
      }
   }
   
    public void machine() {
    	
    	if(select==2) {
    		Lotto.clear();
    	}
    	
       System.out.print("요번 주 로또 당첨번호는:");
       for(int i=0; i < 6; i++) {   
           Lotto.add(random.nextInt(45)+1);
           for(int j=0;j<i;j++) {
              if(Lotto.get(i) == Lotto.get(j)) {
                 Lotto.remove(i);
            	  i--;
              }
           }
           System.out.print(Lotto.get(i)+ " ");
           if(i==5) {
             
              Bonus = random.nextInt(45)+1;
              
               for(int j=0;j<6;j++) {
                  if(Lotto.get(i) == Bonus) {
                      Bonus = random.nextInt(45)+1;
                      j=0;
                  }
               }
               System.out.print("+ 보너스 번호["+Bonus+"]");
           }
       }
        System.out.print("입니다.\n");
        
        System.out.print("정렬된 요번 주 로또 당첨번호는:");
        Collections.sort(Lotto);
        for(int i=0; i < 6; i++) { 
            System.out.print(Lotto.get(i)+ " ");
        }
        System.out.print("+ 보너스 번호["+Bonus+"]");
        System.out.print("입니다.\n");
        System.out.println(">");
        
   }
    
    public void Compare() {
 
    	if(select==2) {
    		sum=0;
    	}
       
       
       for(int i=0;i<6;i++) {
          
         for(int j=0;j<6;j++){
        	 if(Lotto.get(i)==User.get(j)) {
        		 sum++;
        	 }
         }
          
       }
       
       if(sum==6) {
        System.out.println("1등 입니다. 축하합니다.");
        System.out.println(sum+"개 맞으셨습니다.");
       }
       else if(sum==5&&Bonus==1) {
           System.out.println("2등입니다.");
           System.out.println(sum+"개 맞으셨습니다." + "그리고 보너스 번호를 맞으셨습니다.");
       }
       else if(sum==5) {
           System.out.println("3등입니다.");
           System.out.println(sum+"개 맞으셨습니다.");
       }
       else if(sum==4) {
           System.out.println("4등입니다.");
           System.out.println(sum+"개 맞으셨습니다.");
       }
       else if(sum==3) {
           System.out.println("5등입니다.");
           System.out.println(sum+"개 맞으셨습니다.");
       }
       else {
           System.out.println("당첨되지 못하셨습니다.");
           System.out.println(sum+"개 맞으셨습니다.");
       }  
       System.out.println("");
    }

    public int getSelect() {
    	return select;
    }
    public void setSelect(int select) {
    	this.select = select;
    }
    
    

    
   }
