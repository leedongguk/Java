package 자바프로젝트;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class GameStart1 extends JFrame{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/움배.gif"); 
    Image back = backgroundimage.getImage(); 
     
    JButton gamestartbutton; 
    JLabel agelabel;
    JLabel mark;
    JLabel start;
    
    GameStart1(){
        this.setTitle("이동국오락기"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        agelabel = new JLabel(new ImageIcon("./src/images/다운로드.png"));
        mark = new JLabel(new ImageIcon("./src/images/g.png"));
        start = new JLabel("Press Enter To Play");
        Panel panel = new Panel();
        agelabel.setBounds(1060, 0, 207,243);
      start.setBounds(500,530, 500, 200);
      start.setForeground(Color.white);
      start.setFont(start.getFont().deriveFont(32.0f));
        mark.setBounds(895, 0, 163,190);
        panel.setLayout( null ); 
        this.add(panel); 
        this.setSize(1280,720);
        this.setVisible(true);
        panel.add(agelabel);
       panel.add(mark);
     panel.add(start);
    
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
            	int keyCode = event.getKeyCode();
            	if(keyCode == KeyEvent.VK_SPACE) {
            		
            	new RLogin();
            	dispose();
            	}
                
            }
            });           
          
        
        
    }
    
            
            
   


        
            
            
     
       
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }

