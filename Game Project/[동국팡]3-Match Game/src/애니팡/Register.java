package �ִ���;

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

	 
	 ImageIcon back = new ImageIcon("./src/images/register.png"); //�г� ��濡 �̹��� �ֱ�
	    Image background = back.getImage(); //�г� ��濡 �̹��� �ֱ�
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
	  
	  Loginbutton = new JButton(new ImageIcon("./src/images/ȸ������(1).png"));
       check = new JButton(new ImageIcon("./src/images/Ȯ�ι�ư.gif"));
       text1= new TextField(); //���̵� ĭ
       text2= new TextField(); //��й�ȣ ĭ
       text3= new TextField(); //��й�ȣ ��Ȯ�� ĭ
       text4= new TextField(); //�ڵ��� ��ȣ ĭ
       text5= new TextField(); //�̸� �ִ� ĭ
      
      
      text1.setBounds(320, 150, 300, 45); //���̵� ĭ ��ġ �� ũ�� 
      text2.setBounds(320, 200, 300, 45); //��й�ȣ ĭ ��ġ �� ũ��
      text3.setBounds(320, 250, 300, 45); //��й�ȣ ��Ȯ�� ĭ ��ġ �� ũ��
      text4.setBounds(320, 300, 300, 45); //�ڵ��� ��ȣ ĭ ��ġ �� ũ��
      text5.setBounds(320, 350, 300, 45); //�̸� �ִ� ĭ ��ġ �� ũ��
      
      text2.setEchoChar('*');
      text3.setEchoChar('*');
      panel.setLayout( null );
      this.add(panel);
      this.setBackground(Color.yellow);
      this.setSize(800,600);
      this.setVisible(true);
	  this.setTitle("D & S Game");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  panel.add(text1); //���̵� ĭ ��ġ �� ũ�� 
	  panel.add(text2);//��й�ȣ ĭ ��ġ �� ũ��
	  panel.add(text3);//��й�ȣ ��Ȯ�� ĭ ��ġ �� ũ��
	  panel.add(text4);//�ڵ��� ��ȣ ĭ ��ġ �� ũ��
	  panel.add(text5);//�̸� �ִ� ĭ ��ġ �� ũ��
	 
	  check.setBounds(650, 250, 80, 39);
	  check.setBackground(Color.red);
      check.setContentAreaFilled(false);
      check.setFocusPainted(false);
      
      check.addActionListener(this);
	  
	  panel.add(check);
	  
	  panel.add(text2);
	  panel.add(Loginbutton);//�α��ι�ư
	  
      Loginbutton.setBounds(180, 430, 476, 88);
      Loginbutton.setBackground(Color.red);
      Loginbutton.setContentAreaFilled(false);
      Loginbutton.setFocusPainted(false);
      Loginbutton.addActionListener(this);
	  
  }
  
  
  
  @Override
  public void actionPerformed(ActionEvent e) { 
  	
  	if(e.getSource() == Loginbutton) { 
  		dispose();//��ư Ŭ���� ���� â ������
  		
  		new gogo();//ȸ������ ���� �˾�â
  	 new LoginStart(); //�α��� â
  	 

  	try {
    BufferedWriter playregister = new BufferedWriter(new FileWriter("ȸ�����.txt", true));
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
  
  
  
  class Panel extends JPanel{ //�г� ��濡 �̹��� �ֱ�
      
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(background,0,0,getWidth(),getHeight(),this);
      }
  }
  
  public static void Register(String args[]) {
	  new restart();
	  
  }
  
}
