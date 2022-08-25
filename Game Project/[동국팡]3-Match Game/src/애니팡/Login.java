package 애니팡;

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

 class LoginStart extends JFrame implements ActionListener {

	 ImageIcon backgroundimage = new ImageIcon("./src/images/로그인창.png");
	    Image background = backgroundimage.getImage();
	    JButton Loginbutton;
	    JButton Registerbutton;
	    
	    TextField text1;
	    TextField text2;
	    
		 public int q, w, r, t;
		 
		
  LoginStart() {
	  Panel panel = new Panel();
	  
	  Registerbutton = new JButton(new ImageIcon("./src/images/회원가입(1).png"));
      Loginbutton = new JButton(new ImageIcon("./src/images/게임시작.png"));
     text1= new TextField("UsetName");
     text2= new TextField("PassWord");
      
      JLabel pa = new JLabel("PassWord");
      
      text1.setBounds(150, 200, 476, 50);
      text2.setBounds(150, 250, 476, 50);
      
     
      
      panel.setLayout( null );
      this.add(panel);
      this.setBackground(Color.yellow);
      this.setSize(800,600);
      this.setVisible(true);
	  this.setTitle("D & S Game");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  panel.add(text1);
	 
	  text2.setEchoChar('*');
	  
	  panel.add(text2);
	  panel.add(Loginbutton);
	  panel.add(Registerbutton);
	  Registerbutton.setBounds(150, 380, 476, 88);
      Registerbutton.setBackground(Color.red);
      Registerbutton.setContentAreaFilled(false);
      Registerbutton.setFocusPainted(false);
      
      Loginbutton.setBounds(150, 300, 476, 88);
      Loginbutton.setBackground(Color.red);
      Loginbutton.setContentAreaFilled(false);
      Loginbutton.setFocusPainted(false);
      Registerbutton.addActionListener(this);
      Loginbutton.addActionListener(this);
	  
      
	  
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
	  
	  	
  	if(e.getSource() == Registerbutton) {
  		dispose();
  	 new restart();
  	}
  	if(e.getSource() == Loginbutton) {
  		
  		
    try {
    	String s;
    	String[] array;
    	
    	BufferedReader list = new BufferedReader(new FileReader("회원명단.txt"));
    	
    	
    	while((s=list.readLine())!=null) {
    		array=s.split("/");
    	
    		if(text1.getText().equals(array[0])&&text2.getText().equals(array[1]))
    		{
    			
    			dispose();
    	  	    new maingame();
    	  	    
    	  	    new coco();
    	  	    break;
    		}
    	}
    	list.close();
    }catch(IOException error) {
    	
    }
  	    
  	}

  }
  

  class Panel extends JPanel{
      
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(background,0,0,getWidth(),getHeight(),this);
      }
  }
  

  
}