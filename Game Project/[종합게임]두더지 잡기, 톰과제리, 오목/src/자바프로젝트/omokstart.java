package 자바프로젝트;

import java.awt.*;
import javax.swing.*;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.io.IOException;

class omokstart extends JFrame implements ActionListener {
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/eee.png"); 
    Image back = backgroundimage.getImage(); 
    JButton start;
    
    omokstart(){
        this.setTitle("이동국오락기"); 
        
        start = new JButton(new ImageIcon("./src/images/Untitled-3.png"));
        
        start.setBounds(200, 550, 200, 100);
        start.setContentAreaFilled(false);
        start.setFocusPainted(false); 
        start.addActionListener(this);
        start.setBorderPainted(false);
        Panel panel = new Panel();
        panel.setLayout( null ); 
        panel.add(start);
        this.add(panel); 
        this.setSize(600,800);
        this.setVisible(true);  


    
    }


    @Override
    public void actionPerformed(ActionEvent e) {
  	  
  	  	
    	if(e.getSource() == start) {
    		dispose();
    	 new Omok();
    	}
    	

    }
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }