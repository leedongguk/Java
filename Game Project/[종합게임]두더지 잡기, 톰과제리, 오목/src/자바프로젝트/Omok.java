package 자바프로젝트;

import java.awt.*;

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
import java.io.FileInputStream;
import java.util.*;

class Omok extends JFrame{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/omok.jpg"); 
    Image back = backgroundimage.getImage(); 
   int count = 1;
    JLabel stone[][];
	 int map[][];
	 JLabel gameborder;
	 Random Shake;
	 Timer timer;
	 Cursor cursor;
	    Image img;
	    Cursor cursor1;
	    Image img1;
	 
    Omok(){
    
    	Toolkit tk = Toolkit.getDefaultToolkit();
        img = tk.getImage("./src/images/b1.png");
        Point point = new Point(0,0);
        cursor = tk.createCustomCursor(img,point,"roman");
        timer = new Timer();
        Toolkit tk1 = Toolkit.getDefaultToolkit();
        img1 = tk1.getImage("./src/images/b2.png");
        Point point1 = new Point(0,0);
        cursor1 = tk1.createCustomCursor(img1,point1,"roman1");
        
    	
    	gameborder = new JLabel();
    	stone = new JLabel[19][19];
    	map = new int[19][19];
    	
    	Shake = new Random();
        this.setTitle("이동국오락기"); 
        Panel panel = new Panel();
        panel.setLayout( null );
        gameborder.setBounds(50, 43, 700, 690);
        setmap();
        click();
       
        panel.add(gameborder);
        gameborder.setVisible(true); 
        this.add(panel); 
        
        this.setSize(1200,800);
        this.setVisible(true);  
        
        
       
    }
       
    
    public void click() {
    	
    	for(int i = 0; i < stone.length; i++) {//
	    	  for(int j = 0; j < stone.length; j++) {
	    		  	    		  
	    		  stone[i][j].addMouseListener(new MouseAdapter() {
	    			  
	    			  @Override
	    			  public void mouseClicked( MouseEvent e ) { 
	    				  			
	    				  
	    				  
	    				  
	    				  for (int k =0; k < 19; k++) {  
	    					  for(int l = 0; l < 19; l++) {
	    						 
	    						  if( stone[k][l] == e.getSource()) {	    							   							 
	    							 if(map[k][l] == 0&& count %2 ==1) {	    								 
	    								 map[k][l] = 1;					 
	    								 stone[k][l].setIcon(new ImageIcon("./src/images/"+ "b" +map[k][l] +".png"));	
	    								 count++;
	    								 checking();
	    								 setCursor(cursor1);
	    								 
								 
	    							  }		  
	    							 else if(map[k][l] == 0 && count %2 ==0) {
	    								 map[k][l] = 2;					 
	    								 stone[k][l].setIcon(new ImageIcon("./src/images/"+ "b" +map[k][l] +".png"));	
	    								 count++;
	    								 checking();
	    								 setCursor(cursor);
	    							 }
	    							 
	    							 
	    							 
	    						  }
  
	    					  }//끝	  
	    				  }
	    			  }   			  
	    			  }	
	    		  
	    				  );	
	    	  }
	      }
    	
    	
    }
       
    public void setmap() {
    	
    	for(int i = 0; i < stone.length; i++) {
	    	  for(int j = 0; j < stone.length; j++) {  
	    		  stone[i][j] = new JLabel();
	    		 
	    		  map[i][j] = 0; 
	    		  stone[i][j].setBounds(0+i*36, 0+j*35, 35, 35); 		     		  
	    		  
	    		  stone[i][j].setIcon(new ImageIcon("./src/images/"+ "b" +map[i][j] +".png"));
	    		  stone[i][j].setVisible(true);
	    		  gameborder.add(stone[i][j]); 
	    		 
	    		
	    		 
	    	  }
	    	 
	      }
    	
    	
    	
    }
    
    public void checking() {
    	
    	
    	
      		  
      	
      		for(int i =0;i<19;i++) {
        		for(int j = 0;j<19;j++) {
        			if(map[i][j] != 0) {
        				
        				if((map[i][j] == map[i][j+1])&&(map[i][j]==map[i][j+2])&&(map[i][j]==map[i][j+3])&&(map[i][j]==map[i][j+4]))
            			{
            				
            				if(map[i][j]==1) {
            					new blackwin();
            					new GameSelect();
               				 dispose();
            				}
            				else if(map[i][j]==2) {
            					new whitewin();
            					new GameSelect();
                  				 dispose();
               				}
            				

            			}
        				// 
        				
        				
            		   if((map[i][j] == map[i+1][j])&&(map[i][j]==map[i+2][j])&&(map[i][j]==map[i+3][j])&&(map[i][j]==map[i+4][j]))
            			{
            				if(map[i][j]==1) {
            					new blackwin();
            					new GameSelect();
               				 dispose();
            				}
            				else if(map[i][j]==2) {
            					new whitewin();
            					new GameSelect();
                  				 dispose();
               				}
            				 

            			}
            		
            			
            			
        				if((map[i][j] == map[i+1][j+1])&&(map[i][j]==map[i+2][j+2])&&(map[i][j]==map[i+3][j+3])&&(map[i][j]==map[i+4][j+4]))
            			{
            				
            				if(map[i][j]==1) {
            					new blackwin();
            					new GameSelect();
               				 dispose();
            				}
            				else if(map[i][j]==2) {
            					new whitewin();
            					new GameSelect();
                  				 dispose();
               				}
            				

            			}
        				
            			if((map[i][j] == map[i-1][j+1])&&(map[i][j]==map[i-2][j+2])&&(map[i][j]==map[i-3][j+3])&&(map[i][j]==map[i-4][j+4]))
            			{
            				if(map[i][j]==1) {
            					new blackwin();
            					new GameSelect();
               				 dispose();
            				}
            				else if(map[i][j]==2) {
            					new whitewin();
            					new GameSelect();
                  				 dispose();
               				}
            				 

            			}
            			
            			
            			
            			
            			
            			
            			
            			
            			
            			
            			
        			
        			
        			
        			
        			
        			
        			}
        		}			
        	}
      		  
      		
      		  
      	
 
    	
    	
    	
    	
    	
    	
    }
    
    
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }
