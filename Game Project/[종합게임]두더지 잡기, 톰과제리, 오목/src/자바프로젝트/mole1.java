package �ڹ�������Ʈ;

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

class mole1 extends JFrame implements ActionListener {
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/�δ��� ����.jpg"); 
    Image back = backgroundimage.getImage(); 
    JButton start;
    
    mole1(){
        this.setTitle("�̵���������"); 
        
        start = new JButton(new ImageIcon("./src/images/���ӽ���.png"));
        
        start.setBounds(140, 200, 290, 140);
        start.setContentAreaFilled(false);
        start.setFocusPainted(false); 
        start.addActionListener(this);
        
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
    	 new Mole();
    	}
    	

    }
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }

