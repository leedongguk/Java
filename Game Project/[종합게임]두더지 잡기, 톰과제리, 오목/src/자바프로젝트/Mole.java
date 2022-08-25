package 자바프로젝트;

import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
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

class Mole extends JFrame implements ActionListener {
	 public int a;
 	public int b;
 	 public int c;
  	public int d;
  	public int score = 0;
  	public int timecount = 0;
  	ImageIcon mouse = new ImageIcon("./src/images/뿅망치.png"); 
  	public int starttime = 0;
    ImageIcon backgroundimage = new ImageIcon("./src/images/두더지판.jpg"); 
    Image back = backgroundimage.getImage(); 
    JProgressBar timebar = new JProgressBar(0, 60);
    int map[][];
    Random random;
    JLabel mole[][];
    JLabel gameborder;
    JLabel S;
    Timer timer;
    Timer timer2;
    
    Cursor cursor;
    Image img;  
    
    Mole(){
    	
    	 Toolkit tk = Toolkit.getDefaultToolkit();
         img = tk.getImage("./src/images/뿅망치.png");
         Point point = new Point(0,0);
         cursor = tk.createCustomCursor(img,point,"roman");
         setCursor(cursor);
    	
    	
    	
    	
        this.setTitle("이동국오락기"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mole = new JLabel[6][6];
       random = new Random();
       map = new int[6][6];
       gameborder = new JLabel();
       S = new JLabel();
       timer = new Timer();
       timer2 = new Timer();
       Font font = new Font("궁서", Font.BOLD,30);
       Mole();
       gamerule();
    S.setFont(font);
       
       for(int i = 0; i < mole.length; i++) {//
	    	  for(int j = 0; j < mole.length; j++) {
	    		  	    		  
	    		  mole[i][j].addMouseListener(new MouseAdapter() {
	    			  
	    			  @Override
	    			  public void mouseClicked( MouseEvent e ) { 
	    				  			
	    				  for (int k =0; k < 6; k++) { 
	    					  for(int l = 0; l < 6; l++) {
	    						 
	    						  if( mole[k][l] == e.getSource()) {	    							  
	    							 
	    							  
	    							 
	    							 if(map[k][l] == 1) {
	    								 map[k][l] = 2;
	    								 
	    								 mole[k][l].setIcon(new ImageIcon("./src/images/"+ 2 +".gif"));								 
	    								 score += 1;
	    								 S.setText(score+"");
	    								 S.setVisible(true);
	    								 
	    								 
	    							  }
	    							  
	    							  
	    						  }
	    						  
	    						  
	    					  
	    					  }
	    				  
	    				 
	    				  
	    				  
	    				  }
	    				  
	    				  
	    				  
	    			
	    			  }   			  
	    			  }	
	    		  
	    				  );	
	    		  
	    		  
		 
	    	  }
	      }
       
       
       
       
       time();
       S.setBackground(Color.black);
       S.setVisible(true);
       S.setBounds(625,110,100,100);
       S.setText(score+"");
       timebar.setValue(0);
       timebar.setBounds(50, 210, 600, 40
    		   );
	   timebar.setForeground(Color.ORANGE);
	   timebar.setVisible(true);
	   
        gameborder.setBackground(Color.black);
        gameborder.setVisible(true);
        gameborder.setBounds(100,240,900,800);
        Panel panel = new Panel();
        panel.add(gameborder);
        panel.add(S);
        panel.add(timebar); 
        panel.setLayout( null ); 
        this.add(panel); 
        this.setSize(800,900);
        this.setVisible(true);
        
        
        
        
    }
    

    public void time() {
    	
    	long start = System.currentTimeMillis();
	      timer2.schedule(new TimerTask() {
      	  public void run() {
      		  
      		  timebar.setValue(timecount);
                long end = System.currentTimeMillis();
      		  
      		  timecount++;
      		 timebar.setValue(timecount);
      		 
      		 if(timecount==60) {
      			 new GameSelect();
      			 new molescore();
      			 dispose();
      			 
      			try {
      				
				    BufferedWriter point = new BufferedWriter(new FileWriter("두더지점수.txt", true));
				    point.write(score +"/" + score +"\n");
				    point.close();
				  	} catch (Exception ex) {
				  		
				  	}
      			 
      			 
      		 }
      		 
      		  
      	  }
      	  
        }, 0, 1000);
    	
    }
    	
    
    
    public void Mole() {
    	
    	 for(int i = 0; i < mole.length; i++) {
	    	  for(int j = 0; j < mole.length; j++) {
	    		  mole[i][j] = new JLabel();
	    		  map[i][j] = 0;
	    		  mole[i][j].setBounds(0+i*100, 0+j*100, 100, 100);   		     		  
	    		  mole[i][j].setIcon(new ImageIcon("./src/images/"+ map[i][j] +".png"));
	    		  mole[i][j].setVisible(true);
	    		  gameborder.add(mole[i][j]);
	    		 
	    	  }
	    	 
	      }
    	
    }
    
    public void gamerule() {
    	 timer.schedule(new TimerTask() {
       	  
         	  public void run() {
         		
         		  a = random.nextInt(6);
         		  b =  random.nextInt(6);
         		  c = random.nextInt(6);
       		  d =  random.nextInt(6);     		  
       		  map[a][b] = 1;
       		  map[c][d] = 1;
         		 mole[a][b].setIcon(new ImageIcon("./src/images/"+ map[a][b] +".gif"));
         		mole[c][d].setIcon(new ImageIcon("./src/images/"+ map[c][d] +".gif"));
         		 mole[a][b].setVisible(true);
         		mole[c][d].setVisible(true);
         		  gameborder.add(mole[a][b]);    		
         		  gameborder.add(mole[c][d]);  
         		  
         		try {
                   
         			Thread.sleep(2000);
                   for(int i = 0; i < 6; i++) {
         	    	  for(int j = 0; j < 6; j++) {
         	    	if(map[i][j]==1||map[i][j]==2) {
         	    		 map[i][j] = 0;
         	    		mole[i][j].setIcon(new ImageIcon("./src/images/"+ 0 +".png"));
         	    	}
         	    	 
         	      }
                } 
         		}
                   catch (InterruptedException e) {

               }   		  
         		
         	  }
         	  
           }, 1000, 500);
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