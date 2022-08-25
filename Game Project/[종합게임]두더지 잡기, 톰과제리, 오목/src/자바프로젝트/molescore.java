package 자바프로젝트;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class molescore extends JFrame{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/molescore.jpg"); 
    Image back = backgroundimage.getImage(); 

    
    JLabel Npoint;
    
    molescore(){
    	
    	Npoint = new JLabel("");
    	Npoint.setBounds(90,240,300,450);
    	Npoint.setFont(new Font("굵은고딕", Font.BOLD | Font.ITALIC, 40));
        this.setTitle("이동국오락기"); 
        

        
        try {
	    	String s;
	    	String[] array;
	    	
	    	BufferedReader list = new BufferedReader(new FileReader("두더지점수.txt"));
	    	
	    	
	    	while((s=list.readLine())!=null) {
	    		
	    		array=s.split("/");		
	    	Npoint.setText(""+array[0]);
              
	    	}
	    	list.close();
	    }catch(Exception error) {
	    	
	    }
        
        
        
        Panel panel = new Panel();
        panel.add(Npoint);
        panel.setLayout( null ); 
        this.add(panel); 
        this.setSize(400,600);
        this.setVisible(true);  
       
        
        
        
        
        
    }
       
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }
