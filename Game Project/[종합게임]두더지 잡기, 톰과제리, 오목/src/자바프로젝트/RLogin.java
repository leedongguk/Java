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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class RLogin extends JFrame implements ActionListener{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/로그인창.gif"); 
    Image back = backgroundimage.getImage(); 
    JButton Loginbutton;
    JButton Registerbutton;
    TextField text1;
    TextField text2;
    
    RLogin(){
        this.setTitle("이동국오락기"); 
        
        text1= new TextField(); 
        text2= new TextField(); 
        
        text1.setBounds(39, 238, 350, 65); 
        text2.setBounds(40, 330, 350, 65); 
        text2.setEchoChar('*');
        
        text1.setText("UserName");
        text1.setFont(new Font("Dialog",Font.ITALIC,30));
        text2.setText(" ****");
        text2.setFont(new Font("Dialog",Font.ITALIC,30));
        
        Loginbutton = new JButton(new ImageIcon("./src/images/로그인버튼임.gif"));
        Registerbutton = new JButton(new ImageIcon("./src/images/회원가입 버튼.png"));

        Loginbutton.setBounds(280, 435, 127, 113);
        Loginbutton.setBackground(Color.red);
        Loginbutton.setContentAreaFilled(false);
        Loginbutton.setFocusPainted(false);
        Loginbutton.setBorderPainted(false);
       
        
        
        Registerbutton.setBounds(50, 580, 208, 33);
        Registerbutton.setBackground(Color.red);
        Registerbutton.setContentAreaFilled(false);
        Registerbutton.setFocusPainted(false);
        Registerbutton.setBorderPainted(false);
        
        
        Panel panel = new Panel();
        panel.add(Loginbutton);
        panel.add(Registerbutton);
        panel.add(text1); 
    	 panel.add(text2);
        panel.setLayout( null ); 
        this.add(panel); 
        this.setSize(1200,719);
        this.setVisible(true);  

        Loginbutton.addActionListener(this);
        Registerbutton.addActionListener(this);
           
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
    	if(e.getSource() == Loginbutton) {
      		
      		
    	    try {
    	    	String s;
    	    	String[] array;
    	    	
    	    	BufferedReader list = new BufferedReader(new FileReader("회원명단.txt"));
    	    	
    	    	
    	    	while((s=list.readLine())!=null) {
    	    		array=s.split("/");
    	    	
    	    		if(text1.getText().equals(array[0])&&text2.getText().equals(array[1]))
    	    		{
    	    			
    	    			 new GameSelect();
    	    	    	 new LoginSuccess();	
    	    	    	 dispose();
    	    	  	   
    	    			
    	    			
    	    	  	    break;
    	    		}
    	    		else {
    	    			new Failed();
    	    			break;
    	    		}
    	    	}
    	    	list.close();
    	    }catch(IOException error) {
    	    	
    	    }
    	  	    
    	  	}
    	
    	if(e.getSource() == Registerbutton) {
    		new register();
    		dispose();
    	}
    	
    	
    	
    	
    }
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }
