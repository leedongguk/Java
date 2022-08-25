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

class pacmanstart extends JFrame implements ActionListener {
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/시작.png"); 
    Image back = backgroundimage.getImage(); 
    JButton start;
    
    pacmanstart(){
        this.setTitle("이동국오락기"); 
        
        start = new JButton(new ImageIcon("./src/images/시작버튼.png"));
        
        start.setBounds(80, 200, 300, 150);
        start.setContentAreaFilled(false);
        start.setFocusPainted(false); 
        start.addActionListener(this);
        
        Panel panel = new Panel();
        panel.setLayout( null ); 
        panel.add(start);
        this.add(panel); 
        this.setSize(800,500);
        this.setVisible(true);  


    
    }


    @Override
    public void actionPerformed(ActionEvent e) {
  	  
  	  	
    	if(e.getSource() == start) {
    		dispose();
    	 new PackMan();
    	}
    	

    }
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }

