package 애니팡;

import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javazoom.jl.player.Player;
import javazoom.jl.player.Player;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.util.*;

import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;


class maingame extends JFrame implements ActionListener {

	final static int MAX_ROW=13;
	final static int MAX_COL=13;
	
	public int count = 1;
	public int gameplay = 1;
	public int a;
	public int b;
	public int c;
	public int d;
	public int n;
	public int m;
	public int h = 0;
	public int timecount = 0;
    public int cleartime =0;
    
	
	ImageIcon back = new ImageIcon("./src/images/게임화면.png"); //패널에 이미지 넣기(1)
	Image background = back.getImage();//패널에 이미지 넣기(2)
	 JLabel Label; //카카오프렌즈 곰돌이 프로필 사진
	 JProgressBar pointbar = new JProgressBar(0, 500); //점수를 획득하면 오르는 프로그레스바
	 JProgressBar timebar = new JProgressBar(0, 60);
	 JLabel gameborder;//게임이 돌아가는 판
	JLabel counter;
	 JLabel animal[][];//애니팡 캐릭터 배열
	 int map[][];//맵
	 Random Shake;//랜덤으로 캐릭터 자리 배치
   Timer time;
   JLabel timelabel;
  Timer mapclear;
  JButton hit;
  JButton mix;
  JButton boom;

  
	 maingame() {
		 
		 boom = new JButton(new ImageIcon("./src/images/폭탄.jpg"));
	     mix = new JButton(new ImageIcon("./src/images/믹스.png"));
	     hit = new JButton(new ImageIcon("./src/images/뿅망치.jpg"));
	    
	     boom.setBounds(1020, 460, 110, 111);
	     boom.setBackground(Color.red);
	     boom.setContentAreaFilled(false);
	     boom.setFocusPainted(false);
	      
	     mix.setBounds(785, 460, 110, 110);
	     mix.setBackground(Color.red);
	     mix.setContentAreaFilled(false);
	     mix.setFocusPainted(false);
	     
	     hit.setBounds(905, 460, 110, 110);
	     hit.setBackground(Color.red);
	     hit.setContentAreaFilled(false);
	     hit.setFocusPainted(false);
	     
	     mix.addActionListener(this);
	     boom.addActionListener(this);
	     hit.addActionListener(this);
	     
		Panel panel = new Panel();
		gameborder = new JLabel(new ImageIcon("./src/images/trg.png"));//게임오버
		Label = new JLabel(new ImageIcon("./src/images/프로필.gif"));//곰돌이 프로필 사진 넣기
		Label.setBounds(780, 100, 360, 350);//곰돌이 프로필 위치 및 크기
         counter = new JLabel("Move  " + gameplay);
         counter.setFont(new Font("digital-7", Font.BOLD | Font.ITALIC, 60));
         timelabel = new JLabel();
         timelabel.setBounds(910, 750, 500, 100);
        time = new Timer();
        mapclear = new Timer();
        timelabel.setFont(new Font("digital-7", Font.BOLD | Font.ITALIC, 25));

		//닉네임 불러오기
        try {
        	String s;
        	String[] array;
        	BufferedReader list = new BufferedReader(new FileReader("회원명단.txt"));
        	Charset cs = StandardCharsets.UTF_8;
        	
        	while((s=list.readLine())!=null) {
        		array=s.split("/");		    		
        	
        		
        	}
        	list.close();
        }catch(Exception error) {
        	
        }
        
        panel.setLayout( null );
	      gameborder.setBounds(20, 145, 700, 690);//게임판 크기 및 위치
          gameborder.setVisible(true);
	      pointbar.setBounds(50,40, 560, 60);//포인트바 크기 및 위치
	      pointbar.setValue(0);
	      timebar.setValue(0);
	      
	      timebar.setBounds(780, 730, 250, 50);
	      timebar.setForeground(Color.green);//포인트바 게이지 색깔
	      pointbar.setForeground(Color.orange);//포인트바 게이지 색깔
	      counter.setBounds(820,590, 400, 100);
	      animal = new JLabel[13][13];//애니팡 캐릭터들 배치
	      
	      Shake = new Random();//애니팡 캐릭터들 배치를 랜덤으로
	  	map = new int[13][13];//맵
	      
	      
	      for(int i = 0; i < animal.length; i++) {
	    	  for(int j = 0; j < animal.length; j++) {   //애니팡 캐릭터들 자리 배치 및 크기 설정 그리고 위치 설정
	    		  animal[i][j] = new JLabel();
	    		 
	    		  map[i][j] = Shake.nextInt(6); //랜덤배치
	    		  animal[i][j].setBounds(0+i*52, 0+j*52, 71, 50);//애니팡 캐릭 위치 및 크기	    		     		  
	    		  
	    		  animal[i][j].setIcon(new ImageIcon("./src/images/"+ map[i][j] +".png"));//배열에 이미지 넣어주기
	    		  animal[i][j].setVisible(true);
	    		  gameborder.add(animal[i][j]); //게임판에 넣기
	    		 
	    		
	    		 
	    	  }
	    	 
	      }
	      
	     
	      
	      
	      
	      mapclear.schedule(new TimerTask() {
        	  public void run() {
        		  
        		  
        		 
        		  if(cleartime==1) {
        			 mapchecking2();
        		  }

        		  if(cleartime==2) {
         			 mapchecking2();
         		  }
        		  
        		  if(cleartime==3) {
         			 mapchecking2();
         		  }

        		  cleartime++;
        	  }
        	  
          }, 0, 1000);
	      
          
	  	  long start = System.currentTimeMillis();
	      time.schedule(new TimerTask() {
        	  public void run() {
        		  timebar.setValue(timecount);
                  long end = System.currentTimeMillis();
        		  timelabel.setText(((end-start)/1000)+"");
        		  timecount++;
        		  if(timecount==20) {
        			  
        			  hit.setEnabled(true);
        		      
        		  }
        		  if(timecount==40) {
        			  boom.setEnabled(true);
        			  hit.setEnabled(true);
        		  }
        		  if(timecount==61) {
        			  new gameover();
        			  dispose();
        			  
        			  try {
        				    BufferedWriter point = new BufferedWriter(new FileWriter("회원점수.txt", true));
        				    point.write(h+ "/"+"\n");

        				    

        				    point.close();
        				  	} catch (Exception ex) {
        				  		
        				  	}
        			  

        		  }
        		  
        	  }
        	  
          }, 0, 1000);
	      

       
	      for(int i = 0; i < animal.length; i++) {
	    	  for(int j = 0; j < animal.length; j++) {
	    		  
	    		  
	    		  
	    		  animal[i][j].addMouseListener(new MouseAdapter() {
	    			  
	    			  @Override
	    			  public void mousePressed( MouseEvent e ) { 
	    				  			
	    				  
	    				  
	    				  
	    				  for (int k =0; k < animal.length; k++) {  //마우스 클릭시 캐릭터 좌표 구하기 및 이미지 변환
	    					  for(int l = 0; l <animal.length; l++) {
	    						  if( animal[k][l] == e.getSource() ) {
	    							  System.out.println("count: " + count);
	    							  
	    							  if(([k][l]==7)&&(count%2==1)) {
	    		                          	for(int i = 0; i<MAX_ROW;i++) {
	    		                          		[i][l] = -1;    		
	    		                          		animal[i][l].setIcon(new ImageIcon("./src/images/"+ [i][l] +".png"));
	    		                          	}
	    		                          	for(int j = 0; j<MAX_ROW;j++) {
	    		                          		map[k][j] = -1;    
	    		                          		animal[k][j].setIcon(new ImageIcon("./src/images/"+ map[k][j] +".png"));
	    		                          		
	    		                          	}
	    		                          	try {
	    		                          		Thread.sleep(500);
	    		                          		mapchecking();
	    		                          	}catch(Exception sd) {
	    		                          		
	    		                          	}
	    		                          
	    		                          	
	    		                          }
	    							  if((map[k][l]==7)&&(count%2==0)) {
	    		                          	for(int i = 0; i<MAX_ROW;i++) {
	    		                          		map[i][l] = -1;    		
	    		                          		animal[i][l].setIcon(new ImageIcon("./src/images/"+ map[i][l] +".png"));
	    		                          	}
	    		                          	for(int j = 0; j<MAX_ROW;j++) {
	    		                          		map[k][j] = -1;    
	    		                          		animal[k][j].setIcon(new ImageIcon("./src/images/"+ map[k][j] +".png"));
	    		                          		
	    		                          	}
	    		                          	try {
	    		                          		Thread.sleep(500);
	    		                          		mapchecking();
	    		                          	}catch(Exception sd) {
	    		                          		
	    		                          	}
	    		                          
	    		                          	count++;
	    		                          }
	    							  
	    							  
	    							  if(count%2==1)
	    							  {
	    							  System.out.println("positionfirst: " + k + " " + l);
	    							  a = k;
	    							  b = l;
	    							  n = k;
	    							  m = l;
	    							  int ccheck = map[k][l];
	    							  animal[k][l].setIcon(new ImageIcon("./src/images/"+ map[k][l] +"-1.png"));	
	    							  count++;
	    							  
	    							  }
	    							  else if(count%2==0) {
	    								  
	    								  if((animal[a][b] == animal[k+1][l])||(animal[a][b] == animal[k][l+1])||(animal[a][b] == animal[k-1][l])||(animal[a][b] == animal[k][l-1]))
	    								  {	  
	    								  System.out.println("positionSecond: " + k + " " + l);
	    								 c = k;
	    								 d = l;
	    								 int checktemp = map[c][d];
	    								
	    								 
	    								 int temp = map[a][b];
	    								 
	    								 
	    								 map[a][b] = map[c][d];
	    								 map[c][d] = temp;
	    								 
	    								 animal[a][b].setIcon(new ImageIcon("./src/images/"+ map[a][b] +".png"));
	    								 
	    								 animal[c][d].setIcon(new ImageIcon("./src/images/"+ map[c][d] +".png"));
	    								 gameplay++;
	    								 count++;
	    								 
	    								counter.setText("Move  " + gameplay);
	    								 new impact();
                                        
	    								 mapchecking();
	    								  }
	    								 
	    							  }
	    							  
                                        
	    							  
	    							  
	    							   //이미지 클릭시 이미지 변환, 애니팡 캐릭터에 별이 생김
	    							  
	    							  
	    						  
	    						  
	    						
	    						  
	    						  
	    					  }
	    					  
	    					  }//끝
	    				  
	    				 
	    				  
	    				  
	    				  }
	    			  }   			  
	    			  }	
	    		  
	    				  );	
   		 
	    	  }
	      }
	      
	      
     
		  this.add(panel);
	      this.setBackground(Color.yellow);
	      this.setSize(1200,900);
	      this.setVisible(true);
		  this.setTitle("D & S Game");
		  hit.setEnabled(false);
	      boom.setEnabled(false);
	      panel.add(gameborder);
	      panel.add(Label);
	      panel.add(pointbar);
	      panel.add(counter);	 
	      panel.add(timelabel);
	      panel.add(timebar);
	      panel.add(boom);
	      panel.add(hit);
	      panel.add(mix);

		  
	      
	      
	 }
	 
	 
	 public void fix2() {
		 
		 
		 for(int x =0;x<MAX_ROW;x++) {
				for(int y = 0;y<MAX_COL;y++) {
					int target = -1;
							
					if((map[x][y]==-1)) {//시작
						
						 map[x][y] = Shake.nextInt(6); //랜덤배치     		  
			    		  animal[x][y].setIcon(new ImageIcon("./src/images/"+ map[x][y] +".png"));//배열에 이미지 넣어주기	
						
					}//끝
					
				}			
			}
		 mapchecking();
	 }
	 
 public void fix3() {
		 
		 
		 for(int x =0;x<MAX_ROW;x++) {
				for(int y = 0;y<MAX_COL;y++) {
					int target = -1;
							
					if((map[x][y]==-1)) {//시작
						
						 map[x][y] = Shake.nextInt(6); //랜덤배치     		  
			    		  animal[x][y].setIcon(new ImageIcon("./src/images/"+ map[x][y] +".png"));//배열에 이미지 넣어주기	
						
					}//끝
					
				}			
			}
		 
	 }
	 
 
	 public void mapchecking2() {    //모든 맵 체크 						
		 
		 
			//3개

		 
		// 
	for(int i =0;i<MAX_ROW;i++) {
		for(int j = 0;j<11;j++) {
			if((map[i][j] == map[i][j+1])&&(map[i][j]==map[i][j+2]))
			{
				 map[i][j] = -1;
	        	 map[i][j+1] = -1;
	        	 map[i][j+2] = -1;
	        	 animal[i][j].setIcon(new ImageIcon("./src/images/"+ map[i][j] +".png"));
	        	 animal[i][j+1].setIcon(new ImageIcon("./src/images/"+ map[i][j+1] +".png"));
	        	 animal[i][j+2].setIcon(new ImageIcon("./src/images/"+ map[i][j+2] +".png"));
	        	 
	        	 pointbar.setValue(h);
			}
		}			
	}
	//
	for(int ay =0;ay<MAX_COL;ay++) {
		for(int ax = 0;ax<11;ax++) {	
			if((map[ax][ay] == map[ax+1][ay])&&(map[ax][ay]==map[ax+2][ay]))
			{
				map[ax][ay] = -1;
	        	 map[ax+1][ay] = -1;
	        	 map[ax+2][ay] = -1;
	        	 animal[ax][ay].setIcon(new ImageIcon("./src/images/"+ map[ax][ay] +".png"));
	        	 animal[ax+1][ay].setIcon(new ImageIcon("./src/images/"+ map[ax+1][ay] +".png"));
	        	 animal[ax+2][ay].setIcon(new ImageIcon("./src/images/"+ map[ax+2][ay] +".png"));
	        	 
	        	 pointbar.setValue(h);
			}
		}			
	}
	//
	
		    fix3();

			
	 }
	 
	 
	 
	 
	 public void mapchecking() {    //모든 맵 체크 						
	 
		 
			//3개

		 
		// 
	for(int i =0;i<MAX_ROW;i++) {
		for(int j = 0;j<11;j++) {
			if((map[i][j] == map[i][j+1])&&(map[i][j]==map[i][j+2]))
			{
				 map[i][j] = -1;
	        	 map[i][j+1] = -1;
	        	 map[i][j+2] = -1;
	        	 animal[i][j].setIcon(new ImageIcon("./src/images/"+ map[i][j] +".png"));
	        	 animal[i][j+1].setIcon(new ImageIcon("./src/images/"+ map[i][j+1] +".png"));
	        	 animal[i][j+2].setIcon(new ImageIcon("./src/images/"+ map[i][j+2] +".png"));
	        	 h += 5;
	        	 pointbar.setValue(h);
			}
		}			
	}
	//
	for(int ay =0;ay<MAX_COL;ay++) {
		for(int ax = 0;ax<11;ax++) {	
			if((map[ax][ay] == map[ax+1][ay])&&(map[ax][ay]==map[ax+2][ay]))
			{
				map[ax][ay] = -1;
	        	 map[ax+1][ay] = -1;
	        	 map[ax+2][ay] = -1;
	        	 animal[ax][ay].setIcon(new ImageIcon("./src/images/"+ map[ax][ay] +".png"));
	        	 animal[ax+1][ay].setIcon(new ImageIcon("./src/images/"+ map[ax+1][ay] +".png"));
	        	 animal[ax+2][ay].setIcon(new ImageIcon("./src/images/"+ map[ax+2][ay] +".png"));
	        	 h += 5;
	        	 pointbar.setValue(h);
			}
		}			
	}
	//
	
		    fix2();

			
	 }
	 
	 
	 public int getPO() {
		 return h;
	 }

	 @Override
	  public void actionPerformed(ActionEvent ev) {
		 
	 
		 if(ev.getSource() == boom) { 

			int RA = Shake.nextInt(11)+2;
		    int RB = Shake.nextInt(11)+2;
			map[RA][RB] = 7;
			  animal[RA][RB].setIcon(new ImageIcon("./src/images/"+ map[RA][RB] +".png"));//배열에 이미지 넣어주기
			  boom.setEnabled(false);
			  
		 }
         if(ev.getSource() == hit) { 
        	 hit.setEnabled(false);
        	 int RXA = Shake.nextInt(12)+1;
 		    int RXB = Shake.nextInt(12)+1;
 			map[RXA][RXB] = -1;
 			 
 			animal[RXA][RXB].setIcon(new ImageIcon("./src/images/"+ map[RXA][RXB] +".png"));//배열에 이미지 넣어주기
 			h += 5;
			  pointbar.setValue(h);
 			mapchecking();
 			
 			 
		 }
         if(ev.getSource() == mix) { 
        	 mix.setEnabled(false);
   	      for(int i = 0; i < animal.length; i++) {
	    	  for(int j = 0; j < animal.length; j++) {   
    		  map[i][j] = Shake.nextInt(6); //랜덤배치
	    		  animal[i][j].setIcon(new ImageIcon("./src/images/"+ map[i][j] +".png"));//배열에 이미지 넣어주기
    		 
	    	  }
	    	 
	      }
        	 
        	 mapchecking();
		 }
	  	

	  }
	 
	 
	class Panel extends JPanel{     //패널에 이미지 넣기
	      public void paintComponent(Graphics g){
	          super.paintComponent(g);
	          g.drawImage(background,0,0,getWidth(),getHeight(),this);
	          
	      } 
	     
	  }
	}
	
