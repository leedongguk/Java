package �ִ���;

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
    
	
	ImageIcon back = new ImageIcon("./src/images/����ȭ��.png"); //�гο� �̹��� �ֱ�(1)
	Image background = back.getImage();//�гο� �̹��� �ֱ�(2)
	 JLabel Label; //īī�������� ������ ������ ����
	 JProgressBar pointbar = new JProgressBar(0, 500); //������ ȹ���ϸ� ������ ���α׷�����
	 JProgressBar timebar = new JProgressBar(0, 60);
	 JLabel gameborder;//������ ���ư��� ��
	JLabel counter;
	 JLabel animal[][];//�ִ��� ĳ���� �迭
	 int map[][];//��
	 Random Shake;//�������� ĳ���� �ڸ� ��ġ
   Timer time;
   JLabel timelabel;
  Timer mapclear;
  JButton hit;
  JButton mix;
  JButton boom;

  
	 maingame() {
		 
		 boom = new JButton(new ImageIcon("./src/images/��ź.jpg"));
	     mix = new JButton(new ImageIcon("./src/images/�ͽ�.png"));
	     hit = new JButton(new ImageIcon("./src/images/�и�ġ.jpg"));
	    
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
		gameborder = new JLabel(new ImageIcon("./src/images/trg.png"));//���ӿ���
		Label = new JLabel(new ImageIcon("./src/images/������.gif"));//������ ������ ���� �ֱ�
		Label.setBounds(780, 100, 360, 350);//������ ������ ��ġ �� ũ��
         counter = new JLabel("Move  " + gameplay);
         counter.setFont(new Font("digital-7", Font.BOLD | Font.ITALIC, 60));
         timelabel = new JLabel();
         timelabel.setBounds(910, 750, 500, 100);
        time = new Timer();
        mapclear = new Timer();
        timelabel.setFont(new Font("digital-7", Font.BOLD | Font.ITALIC, 25));

		//�г��� �ҷ�����
        try {
        	String s;
        	String[] array;
        	BufferedReader list = new BufferedReader(new FileReader("ȸ�����.txt"));
        	Charset cs = StandardCharsets.UTF_8;
        	
        	while((s=list.readLine())!=null) {
        		array=s.split("/");		    		
        	
        		
        	}
        	list.close();
        }catch(Exception error) {
        	
        }
        
        panel.setLayout( null );
	      gameborder.setBounds(20, 145, 700, 690);//������ ũ�� �� ��ġ
          gameborder.setVisible(true);
	      pointbar.setBounds(50,40, 560, 60);//����Ʈ�� ũ�� �� ��ġ
	      pointbar.setValue(0);
	      timebar.setValue(0);
	      
	      timebar.setBounds(780, 730, 250, 50);
	      timebar.setForeground(Color.green);//����Ʈ�� ������ ����
	      pointbar.setForeground(Color.orange);//����Ʈ�� ������ ����
	      counter.setBounds(820,590, 400, 100);
	      animal = new JLabel[13][13];//�ִ��� ĳ���͵� ��ġ
	      
	      Shake = new Random();//�ִ��� ĳ���͵� ��ġ�� ��������
	  	map = new int[13][13];//��
	      
	      
	      for(int i = 0; i < animal.length; i++) {
	    	  for(int j = 0; j < animal.length; j++) {   //�ִ��� ĳ���͵� �ڸ� ��ġ �� ũ�� ���� �׸��� ��ġ ����
	    		  animal[i][j] = new JLabel();
	    		 
	    		  map[i][j] = Shake.nextInt(6); //������ġ
	    		  animal[i][j].setBounds(0+i*52, 0+j*52, 71, 50);//�ִ��� ĳ�� ��ġ �� ũ��	    		     		  
	    		  
	    		  animal[i][j].setIcon(new ImageIcon("./src/images/"+ map[i][j] +".png"));//�迭�� �̹��� �־��ֱ�
	    		  animal[i][j].setVisible(true);
	    		  gameborder.add(animal[i][j]); //�����ǿ� �ֱ�
	    		 
	    		
	    		 
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
        				    BufferedWriter point = new BufferedWriter(new FileWriter("ȸ������.txt", true));
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
	    				  			
	    				  
	    				  
	    				  
	    				  for (int k =0; k < animal.length; k++) {  //���콺 Ŭ���� ĳ���� ��ǥ ���ϱ� �� �̹��� ��ȯ
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
	    							  
                                        
	    							  
	    							  
	    							   //�̹��� Ŭ���� �̹��� ��ȯ, �ִ��� ĳ���Ϳ� ���� ����
	    							  
	    							  
	    						  
	    						  
	    						
	    						  
	    						  
	    					  }
	    					  
	    					  }//��
	    				  
	    				 
	    				  
	    				  
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
							
					if((map[x][y]==-1)) {//����
						
						 map[x][y] = Shake.nextInt(6); //������ġ     		  
			    		  animal[x][y].setIcon(new ImageIcon("./src/images/"+ map[x][y] +".png"));//�迭�� �̹��� �־��ֱ�	
						
					}//��
					
				}			
			}
		 mapchecking();
	 }
	 
 public void fix3() {
		 
		 
		 for(int x =0;x<MAX_ROW;x++) {
				for(int y = 0;y<MAX_COL;y++) {
					int target = -1;
							
					if((map[x][y]==-1)) {//����
						
						 map[x][y] = Shake.nextInt(6); //������ġ     		  
			    		  animal[x][y].setIcon(new ImageIcon("./src/images/"+ map[x][y] +".png"));//�迭�� �̹��� �־��ֱ�	
						
					}//��
					
				}			
			}
		 
	 }
	 
 
	 public void mapchecking2() {    //��� �� üũ 						
		 
		 
			//3��

		 
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
	 
	 
	 
	 
	 public void mapchecking() {    //��� �� üũ 						
	 
		 
			//3��

		 
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
			  animal[RA][RB].setIcon(new ImageIcon("./src/images/"+ map[RA][RB] +".png"));//�迭�� �̹��� �־��ֱ�
			  boom.setEnabled(false);
			  
		 }
         if(ev.getSource() == hit) { 
        	 hit.setEnabled(false);
        	 int RXA = Shake.nextInt(12)+1;
 		    int RXB = Shake.nextInt(12)+1;
 			map[RXA][RXB] = -1;
 			 
 			animal[RXA][RXB].setIcon(new ImageIcon("./src/images/"+ map[RXA][RXB] +".png"));//�迭�� �̹��� �־��ֱ�
 			h += 5;
			  pointbar.setValue(h);
 			mapchecking();
 			
 			 
		 }
         if(ev.getSource() == mix) { 
        	 mix.setEnabled(false);
   	      for(int i = 0; i < animal.length; i++) {
	    	  for(int j = 0; j < animal.length; j++) {   
    		  map[i][j] = Shake.nextInt(6); //������ġ
	    		  animal[i][j].setIcon(new ImageIcon("./src/images/"+ map[i][j] +".png"));//�迭�� �̹��� �־��ֱ�
    		 
	    	  }
	    	 
	      }
        	 
        	 mapchecking();
		 }
	  	

	  }
	 
	 
	class Panel extends JPanel{     //�гο� �̹��� �ֱ�
	      public void paintComponent(Graphics g){
	          super.paintComponent(g);
	          g.drawImage(background,0,0,getWidth(),getHeight(),this);
	          
	      } 
	     
	  }
	}
	
