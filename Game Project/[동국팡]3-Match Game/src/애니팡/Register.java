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

 class restart extends JFrame implements ActionListener {

	 
	 ImageIcon back = new ImageIcon("./src/images/register.png"); //패녈 배경에 이미지 넣기
	    Image background = back.getImage(); //패녈 배경에 이미지 넣기
	    JButton Loginbutton;
	    public int ID, PA, NAME, d , e; 
	    
	    TextField text1;
	    TextField text2;
	    TextField text3;
	    TextField text4;
	    TextField text5;
	    JButton check;
	    
  restart() {
	  
	  Panel panel = new Panel();
	  
	  Loginbutton = new JButton(new ImageIcon("./src/images/회원가입(1).png"));
       check = new JButton(new ImageIcon("./src/images/확인버튼.gif"));
       text1= new TextField(); //아이디 칸
       text2= new TextField(); //비밀번호 칸
       text3= new TextField(); //비밀번호 재확인 칸
       text4= new TextField(); //핸드폰 번호 칸
       text5= new TextField(); //이름 넣는 칸
      
      
      text1.setBounds(320, 150, 300, 45); //아이디 칸 위치 및 크기 
      text2.setBounds(320, 200, 300, 45); //비밀번호 칸 위치 및 크기
      text3.setBounds(320, 250, 300, 45); //비밀번호 재확인 칸 위치 및 크기
      text4.setBounds(320, 300, 300, 45); //핸드폰 번호 칸 위치 및 크기
      text5.setBounds(320, 350, 300, 45); //이름 넣는 칸 위치 및 크기
      
      text2.setEchoChar('*');
      text3.setEchoChar('*');
      panel.setLayout( null );
      this.add(panel);
      this.setBackground(Color.yellow);
      this.setSize(800,600);
      this.setVisible(true);
	  this.setTitle("D & S Game");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  panel.add(text1); //아이디 칸 위치 및 크기 
	  panel.add(text2);//비밀번호 칸 위치 및 크기
	  panel.add(text3);//비밀번호 재확인 칸 위치 및 크기
	  panel.add(text4);//핸드폰 번호 칸 위치 및 크기
	  panel.add(text5);//이름 넣는 칸 위치 및 크기
	 
	  check.setBounds(650, 250, 80, 39);
	  check.setBackground(Color.red);
      check.setContentAreaFilled(false);
      check.setFocusPainted(false);
      
      check.addActionListener(this);
	  
	  panel.add(check);
	  
	  panel.add(text2);
	  panel.add(Loginbutton);//로그인버튼
	  
      Loginbutton.setBounds(180, 430, 476, 88);
      Loginbutton.setBackground(Color.red);
      Loginbutton.setContentAreaFilled(false);
      Loginbutton.setFocusPainted(false);
      Loginbutton.addActionListener(this);
	  
  }
  
  
  
  @Override
  public void actionPerformed(ActionEvent e) { 
  	
  	if(e.getSource() == Loginbutton) { 
  		dispose();//버튼 클릭시 현재 창 없어짐
  		
  		new gogo();//회원가입 성공 팝업창
  	 new LoginStart(); //로그인 창
  	 

  	try {
    BufferedWriter playregister = new BufferedWriter(new FileWriter("회원명단.txt", true));
    playregister.write(text1.getText()+"/");
    playregister.write(text2.getText()+"/");
    playregister.write(text3.getText()+"/");
    playregister.write(text4.getText()+"/");
    playregister.write(text5.getText()+"\r\n");
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
  
  
  
  class Panel extends JPanel{ //패녈 배경에 이미지 넣기
      
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(background,0,0,getWidth(),getHeight(),this);
      }
  }
  
  public static void Register(String args[]) {
	  new restart();
	  
  }
  
}
