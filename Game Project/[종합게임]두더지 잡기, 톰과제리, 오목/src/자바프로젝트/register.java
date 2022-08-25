package 자바프로젝트;

import java.awt.*;
import javax.swing.*;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.io.IOException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class register extends JFrame implements ActionListener{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/회원가입 (2).png"); 
    Image back = backgroundimage.getImage(); 
    JButton Loginbutton;
    JButton check;
    TextField text1;
    TextField text2;
    TextField text3;
    
    register(){
        this.setTitle("이동국오락기"); 
        
        text1= new TextField();
        text2= new TextField(); 
        text3= new TextField();
        text1.setBounds(43, 338, 340, 70); 
        text2.setBounds(43, 470, 340, 70); 
        text2.setEchoChar('*');
        text3.setBounds(43, 605, 340, 70); 
        text3.setEchoChar('*');
        
        
        text1.setText("UserName");
        text1.setFont(new Font("Dialog",Font.ITALIC,30));
        text2.setText(" ****");
        text2.setFont(new Font("Dialog",Font.ITALIC,30));
        text3.setText(" ****");
        text3.setFont(new Font("Dialog",Font.ITALIC,30));
        
        Loginbutton = new JButton(new ImageIcon("./src/images/로그인버튼임.gif"));
        check = new JButton(new ImageIcon("./src/images/체크.png"));

        Loginbutton.setBounds(160, 735, 127, 113);
        Loginbutton.setBackground(Color.red);
        Loginbutton.setContentAreaFilled(false);
        Loginbutton.setFocusPainted(false);
        Loginbutton.setBorderPainted(false);
       
        check.setBounds(300, 690, 100, 42);
        check.setContentAreaFilled(false);
        check.setFocusPainted(false);
        check.setBorderPainted(false);
        
        
        Panel panel = new Panel();
        panel.add(Loginbutton);
        panel.add(check);
        panel.add(text1); 
    	 panel.add(text2);
    	 panel.add(text3);
        panel.setLayout( null ); 
        this.add(panel); 
        this.setSize(438,919);
        this.setVisible(true);  

        Loginbutton.addActionListener(this);
        check.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource() == Loginbutton) { 
    		
    		
    		new RLogin();
    		dispose();
    	 	try {
    	 		BufferedWriter playregister = new BufferedWriter(new FileWriter("회원명단.txt", true));
    	 	    playregister.write(text1.getText()+"/");
    	 	    playregister.write(text2.getText()+"/");
    	 	    playregister.write(text3.getText()+"\r\n");
    	 	    playregister.close();
    	 	  	} catch (Exception ex) {
    	 	  		
    	 	  	}
    	}
    	
    	 
    	 	if(e.getSource() == check) {
    	  		String a = text2.getText();
    	  		String b = text3.getText();
    	  		
    	  		if( a.equals(b) ) {
    	  			new check();
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
