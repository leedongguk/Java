package 자바프로젝트;

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
import java.awt.Toolkit;


class PackMan extends JFrame implements ActionListener {
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/123.png"); 
    Image back = backgroundimage.getImage(); 
  
    Random random1, random2;
    JLabel gameborder;
    JLabel scoreborder;
    JLabel pack[][];
    int map[][];
    Timer time;
    Timer time2;
    int timecount = 0;
    int pacmanx = 7;
    int pacmany = 14;
    int score = 0;
    int move = 0;
    int emx = 7;
    int emy = 5;
    PackMan(){
    	
    	random1 = new Random();
    	time = new Timer();
    	time2 = new Timer();
    	pack = new JLabel[16][16];         	
        map = new int[16][16];

        
        scoreborder = new JLabel("");  
        
        
        scoreborder.setBounds(1050,530,200,200);
       scoreborder.setText(score+"");
       scoreborder.setVisible(true);
       scoreborder.setFont(new Font("굵은고딕", Font.BOLD | Font.ITALIC, 40));
        gameborder = new JLabel();
        gameborder.setBackground(Color.black);
        gameborder.setVisible(true);
        gameborder.setBounds(0,0,900,900);
        
        
        Map();
        timer();
        
        moving();
    	
        this.setTitle("이동국오락기");       
        Panel panel = new Panel();
        panel.setLayout( null ); 
        this.add(panel); 
        panel.add(scoreborder);        
        panel.add(gameborder);
        this.setSize(1200,850);
        this.setVisible(true);  
      
        
    } 
    
    public void Map() {
    	
   	 for(int i = 0; i < pack.length; i++) {
	    	  for(int j = 0; j < pack.length; j++) {   
	    		  pack[i][j] = new JLabel();
	    		  map[i][j] = 0;
	    		  pack[i][j].setBounds(0+i*50, 0+j*50, 50, 50);
	    		  if(map[i][j]==0) {
	    		  pack[i][j].setIcon(new ImageIcon("./src/images/p-"+map[i][j]+".png"));
	    		  }
	    		  pack[i][j].setVisible(true);
	    		  gameborder.add(pack[i][j]); 
	    		 
	    	  }
	    	 
	      }
  
    map[1][1]=1;map[2][1]=1;map[3][1]=1;map[4][1]=1;map[5][1]=1;map[6][1]=1;map[7][1]=1;map[8][1]=1;map[9][1]=1;map[10][1]=1;map[11][1]=1;map[12][1]=1;map[13][1]=1;map[14][1]=1;
    map[1][2]=1;map[2][2]=1;map[4][2]=1;map[5][2]=1;map[10][2]=1;map[11][2]=1;map[13][2]=1;map[14][2]=1;
    map[1][3]=1;map[5][3]=1;map[6][3]=1;map[7][3]=1;map[8][3]=1;map[9][3]=1;map[10][3]=1;map[14][3]=1;
    map[1][4]=1;map[2][4]=1;map[3][4]=1;map[7][4]=1;map[8][4]=1;map[12][4]=1;map[13][4]=1;map[14][4]=1;
    map[1][5]=1;map[3][5]=1;map[4][5]=1;map[5][5]=1;map[6][5]=1;map[7][5]=1;map[8][5]=1;map[9][5]=1;map[10][5]=1;map[11][5]=1;map[12][5]=1;map[14][5]=1;
    map[1][6]=1;map[4][6]=1;map[7][6]=1;map[8][6]=1;map[11][6]=1;map[14][6]=1;
    map[1][7]=1;map[2][7]=1;map[3][7]=1;map[4][7]=1;map[6][7]=1;map[7][7]=1;map[8][7]=1;map[9][7]=1;map[11][7]=1;map[12][7]=1;map[13][7]=1;map[14][7]=1;
    map[1][8]=1;map[4][8]=1;map[6][8]=1;map[7][8]=1;map[8][8]=1;map[9][8]=1;map[11][8]=1;map[14][8]=1;
    map[1][9]=1; map[3][9]=1; map[4][9]=1; map[11][9]=1; map[12][9]=1; map[14][9]=1;
    map[3][11]=1;map[7][11]=1;map[9][11]=1;map[13][11]=1;
    map[1][10]=1;map[2][10]=1;map[3][10]=1;map[4][10]=1;map[5][10]=1;map[6][10]=1;map[7][10]=1;map[8][10]=1;map[9][10]=1;map[10][10]=1;map[11][10]=1;map[12][10]=1;map[13][10]=1;map[14][10]=1;
    map[1][12]=1;map[2][12]=1;map[3][12]=1;map[4][12]=1;map[5][12]=1;map[7][12]=1;map[8][12]=1;map[9][12]=1;map[11][12]=1;map[12][12]=1;map[13][12]=1;map[14][12]=1;
    map[1][13]=1;map[4][13]=1;map[7][13]=1;map[9][13]=1;map[12][13]=1;map[14][13]=1;	 
    map[1][14]=1;map[2][14]=1;map[3][14]=1;map[4][14]=1;map[5][14]=1;map[6][14]=1;map[7][14]=1;map[8][14]=1;map[9][14]=1;map[10][14]=1;map[11][14]=1;map[12][14]=1;map[13][14]=1;map[14][14]=1;
   
    map[7][6]=4;map[8][6]=4;//벽
    map[7][7]=3;//적
    map[pacmanx][pacmany]=2;//나
    map[6][7]=5;map[8][7]=5;map[9][7]=5;
    map[6][8]=5;map[7][8]=5;map[8][8]=5;map[9][8]=5;
    
    for(int i = 0; i < pack.length; i++) {
  	  for(int j = 0; j < pack.length; j++) { 
  		  		  
  		  if(map[i][j]==1) {
  		  pack[i][j].setIcon(new ImageIcon("./src/images/p-"+map[i][j]+".png"));
  		  }
  		 if(map[i][j]==2) {
  	  		  pack[i][j].setIcon(new ImageIcon("./src/images/p-"+map[i][j]+".png"));
  	  		  }
  		if(map[i][j]==3) {
	  		  pack[i][j].setIcon(new ImageIcon("./src/images/p-"+map[i][j]+".png"));
	  		  }
  		if(map[i][j]==4) {
	  		  pack[i][j].setIcon(new ImageIcon("./src/images/p-"+map[i][j]+".png"));
	  		  }
  		if(map[i][j]==5) {
	  		  pack[i][j].setIcon(new ImageIcon("./src/images/p-"+map[i][j]+".png"));
	  		  }
  		  pack[i][j].setVisible(true);	
  		 
  	  }
  	 
    }
   	 	 
   	
   }
    
    public void ai() {
    	
    	 time2.schedule(new TimerTask() {
         	  public void run() {
         		
         		  move = random1.nextInt(4)+1;         		          		  
         		  
         		  if(move==1) { //위
         			  
         			 if((map[emx][emy-1] == 1 && map[emx][emy-1] != 0 &&map[emx][emy-1] != 4)||(map[emx][emy-1] == 5 && map[emx][emy-1] != 0&& map[emx][emy-1] != 4)) {
             		
         				
         				
             			if(map[emx][emy-1] ==5) {
         				map[emx][emy] = 5;	
             			}
             			else if(map[emx][emy-1] == 1) {
             				map[emx][emy] = 1;
             			}
             			map[emx][emy-1] = 3;
             			
             			pack[emx][emy-1].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy-1]+".png"));
             			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
             			pack[emx][emy-1].setVisible(true);	
             			pack[emx][emy].setVisible(true);	
             			emy -= 1;
             		}
         			 
         			 else if(map[emx][emy-1] == 2 && map[emx][emy-1] != 0 &&map[emx][emy-1] != 4) {
         				map[emx][emy-1] = 3;
         				map[emx][emy] = 5;	
             			pack[emx][emy-1].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy-1]+".png"));
             			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
             			pack[emx][emy-1].setVisible(true);	
             			pack[emx][emy].setVisible(true);	
             			emy -= 1;
         				 dispose();
         				 new tomwin();
         				 
         			 }
         			  
         		  }
         		  else if(move==2) {//아래
        			  
         			 if((map[emx][emy+1] == 1 && map[emx][emy+1] != 0 &&map[emx][emy+1] != 4)||(map[emx][emy+1] == 5 && map[emx][emy+1] != 0&& map[emx][emy+1] != 4)) {
              			
              			if(map[emx][emy+1] ==5) {
             				map[emx][emy] = 5;	
                 			}
                 			else if(map[emx][emy+1] == 1) {
                 				map[emx][emy] = 1;
                 			}
              			map[emx][emy+1] = 3;		
              			pack[emx][emy+1].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy+1]+".png"));
              			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
              			pack[emx][emy+1].setVisible(true);	
              			pack[emx][emy].setVisible(true);	
              			emy += 1;
              		}
          			 else if(map[emx][emy+1] == 2 && map[emx][emy+1] != 0 &&map[emx][emy+1] != 4) {
          				map[emx][emy+1] = 3;
              			map[emx][emy] = 5;	
              			pack[emx][emy+1].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy+1]+".png"));
              			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
              			pack[emx][emy+1].setVisible(true);	
              			pack[emx][emy].setVisible(true);	
              			emy += 1;
          				 dispose();
          				new tomwin();
          			 }
         			  
         			  
         			  
         			  
        		  }
         		  else if(move==3) { //오른쪽
        			  
         			 if((map[emx+1][emy] == 1 && map[emx+1][emy] != 0 &&map[emx+1][emy] != 4)||(map[emx+1][emy] == 5 && map[emx+1][emy] != 0&& map[emx+1][emy] != 4)) {
               			
               			if(map[emx+1][emy] ==5) {
             				map[emx][emy] = 5;	
                 			}
                 			else if(map[emx+1][emy] == 1) {
                 				map[emx][emy] = 1;
                 			}	
               			map[emx+1][emy] = 3;
               			pack[emx+1][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx+1][emy]+".png"));
               			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
               			pack[emx+1][emy].setVisible(true);	
               			pack[emx][emy].setVisible(true);	
               			emx += 1;
               		}
           			 else if(map[emx+1][emy] == 2 && map[emx+1][emy] != 0 &&map[emx+1][emy] != 4) {
           				map[emx+1][emy] = 3;
               			map[emx][emy] = 5;	
               			pack[emx+1][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx+1][emy]+".png"));
               			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
               			pack[emx+1][emy].setVisible(true);	
               			pack[emx][emy].setVisible(true);	
               			emx += 1;
           				 dispose();
           				new tomwin();
           			 }
         			  
         			  
         			  
         			  
        		  }
         		  else if(move==4) { //왼쪽
         			  
         			 if((map[emx-1][emy] == 1 && map[emx-1][emy] != 0 &&map[emx-1][emy] != 4)||(map[emx-1][emy] == 5 && map[emx-1][emy] != 0&& map[emx-1][emy] != 4)) {
                			
                			if(map[emx-1][emy] ==5) {
                 				map[emx][emy] = 5;	
                     			}
                     			else if(map[emx-1][emy] == 1) {
                     				map[emx][emy] = 1;
                     			}	
                			map[emx-1][emy] = 3;
                			pack[emx-1][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx-1][emy]+".png"));
                			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
                			pack[emx-1][emy].setVisible(true);	
                			pack[emx][emy].setVisible(true);	
                			emx -= 1;
                		}
            			 else if(map[emx-1][emy] == 2 && map[emx-1][emy] != 0 &&map[emx-1][emy] != 4) {
            				map[emx-1][emy] = 3;
                			map[emx][emy] = 5;	
                			pack[emx-1][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx-1][emy]+".png"));
                			pack[emx][emy].setIcon(new ImageIcon("./src/images/p-"+map[emx][emy]+".png"));
                			pack[emx-1][emy].setVisible(true);	
                			pack[emx][emy].setVisible(true);	
                			emx -= 1;
            				 dispose();
            				 new tomwin();
            			 }
         			  
         			  
        			  
        		  }
         		  
         		
         		  
         		
         		  
         		       		  
         		 
         		  
         	  }
         	  
           }, 0, 200);
    	
    	
    	
    	
    }
    
    
 public void timer() {
    	
    	
	      time.schedule(new TimerTask() {
      	  public void run() {
      		  
      		  
      		  if(score==120) {
      			  new jerry();
      			  new GameSelect();
      			  ++score;
      			  dispose();
      		  }
      		
      		  
      		  if(timecount==5) {
      			  
      			 map[7][6]=5;map[8][6]=5;//벽
      			
      	  	  pack[7][6].setIcon(new ImageIcon("./src/images/p-"+map[7][6]+".png"));
      	  	 pack[8][6].setIcon(new ImageIcon("./src/images/p-"+map[8][6]+".png"));  
      	  	pack[7][6].setVisible(true);
      	  pack[8][6].setVisible(true);
      		  }
      		if(timecount==6) {
    			  
     			 map[7][6]=4;map[8][6]=4;//벽
     			map[7][7] = 5;
     			map[7][5]=3;
     			
     	  	  pack[7][6].setIcon(new ImageIcon("./src/images/p-"+map[7][6]+".png"));
     	  	 pack[8][6].setIcon(new ImageIcon("./src/images/p-"+map[8][6]+".png"));  
     	  	pack[7][6].setVisible(true);
     	  pack[8][6].setVisible(true);
     	 pack[7][5].setIcon(new ImageIcon("./src/images/p-"+map[7][5]+".png"));  
   	  	pack[7][5].setVisible(true);
     	 pack[7][7].setIcon(new ImageIcon("./src/images/p-"+map[7][7]+".png"));  
  	  	pack[7][7].setVisible(true);
     	  
     	  
     	 
     	  ai();
     	  
     		  }
      		  
      		  timecount++;
      		
      		 
      		  
      	  }
      	  
        }, 0, 1000);
    	
    }
    	
    
    public void moving()
    {
    	addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
            	
            	int keyCode = event.getKeyCode();
            	
  
            	
            	//위 키 시작
            	if(keyCode == KeyEvent.VK_UP) {
            		
            		if(map[pacmanx][pacmany-1] == 1 && map[pacmanx][pacmany-1] != 0) {
            			map[pacmanx][pacmany-1] = 2;
            			map[pacmanx][pacmany] = 5;
            			score += 1;
            			scoreborder.setText(""+score);
            			 scoreborder.setVisible(true);
            			pack[pacmanx][pacmany-1].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany-1]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx][pacmany-1].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmany -= 1;
            		}
            		else if(map[pacmanx][pacmany-1] == 5 && map[pacmanx][pacmany-1] != 0) {
            			map[pacmanx][pacmany-1] = 2;
            			map[pacmanx][pacmany] = 5;
                  		pack[pacmanx][pacmany-1].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany-1]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx][pacmany-1].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmany -= 1;
            		}
            		else if(map[pacmanx][pacmany-1] == 3 && map[pacmanx][pacmany-1] != 0) {
            			dispose();
            			new tomwin();
            			new GameSelect();
            		}
            		
            		
                	}//끝
            	
            	//오른쪽 키 시작
            	else if(keyCode == KeyEvent.VK_RIGHT) {
            		
            		if(map[pacmanx+1][pacmany] == 1 && map[pacmanx+1][pacmany] != 0) {
            			map[pacmanx+1][pacmany] = 2;
            			map[pacmanx][pacmany] = 5;
            			score += 1;
            			scoreborder.setText(""+score);
            			 scoreborder.setVisible(true);
            			pack[pacmanx+1][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx+1][pacmany]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx+1][pacmany].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmanx += 1;
            		}
            		else if(map[pacmanx+1][pacmany] == 5 && map[pacmanx+1][pacmany] != 0) {
            			map[pacmanx+1][pacmany] = 2;
            			map[pacmanx][pacmany] = 5;

            			pack[pacmanx+1][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx+1][pacmany]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx+1][pacmany].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmanx += 1;
            		}
            		else if(map[pacmanx+1][pacmany] == 3 && map[pacmanx+1][pacmany] != 0) {
            			dispose();
            			new tomwin();
            			new GameSelect();
            		}
            		
            		
            		
            	}//끝
            	
            	//왼쪽 키 시작
            	else if(keyCode == KeyEvent.VK_LEFT) {
            		
            		if(map[pacmanx-1][pacmany] == 1 && map[pacmanx-1][pacmany] != 0) {
            			map[pacmanx-1][pacmany] = 2;
            			map[pacmanx][pacmany] = 5;
            			score += 1;
            			scoreborder.setText(""+score);
            			 scoreborder.setVisible(true);
            			pack[pacmanx-1][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx-1][pacmany]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx-1][pacmany].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmanx -= 1;
            		}
            		else if(map[pacmanx-1][pacmany] == 5 && map[pacmanx-1][pacmany] != 0) {
            			map[pacmanx-1][pacmany] = 2;
            			map[pacmanx][pacmany] = 5;

            			pack[pacmanx-1][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx-1][pacmany]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx-1][pacmany].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmanx -= 1;
            		}
            		else if(map[pacmanx-1][pacmany] == 3 && map[pacmanx-1][pacmany] != 0) {
            			dispose();
            			new tomwin();
            			new GameSelect();
            		}
            		
            		
            		
                }//끝
            	
            	//아래 키 시작
                else if(keyCode == KeyEvent.VK_DOWN) {
            		
                	if(map[pacmanx][pacmany+1] == 1 && map[pacmanx][pacmany+1] != 0) {
            			map[pacmanx][pacmany+1] = 2;
            			map[pacmanx][pacmany] = 5;
            			score += 1;
            			scoreborder.setText(""+score);
            			 scoreborder.setVisible(true);
            			pack[pacmanx][pacmany+1].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany+1]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx][pacmany+1].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmany += 1;
            		}
            		else if(map[pacmanx][pacmany+1] == 5 && map[pacmanx][pacmany+1] != 0) {
            			map[pacmanx][pacmany+1] = 2;
            			map[pacmanx][pacmany] = 5;
                  		pack[pacmanx][pacmany+1].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany+1]+".png"));
            			pack[pacmanx][pacmany].setIcon(new ImageIcon("./src/images/p-"+map[pacmanx][pacmany]+".png"));
            			pack[pacmanx][pacmany+1].setVisible(true);	
            			pack[pacmanx][pacmany].setVisible(true);	
            			pacmany += 1;
            		}
            		else if(map[pacmanx][pacmany+1] == 3 && map[pacmanx][pacmany+1] != 0) {
            			dispose();
            			new tomwin();
            			new GameSelect();
            		}
                	
                	
                }//끝
            	
                
            }
            }); 
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	 { 
    		
    	
    	 
    	}
    	
    	
    }
    
    
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }
