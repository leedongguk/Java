package �ִ���;


import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;

 class RANK extends JFrame implements ActionListener { //ȸ������ ������ ������ �˾�â

	 ImageIcon back = new ImageIcon("./src/images/��ŷ2.png");//�г� ��濡 �̹��� �ֱ�
	    Image background = back.getImage();//�г� ��濡 �̹��� �ֱ�
	    JButton restart;
	    JLabel Name;
	    JLabel Npoint;
	    
  RANK() {
	  Name = new JLabel("");
	  Name.setBounds(90,240,900,100);
	  Name.setFont(new Font("�������", Font.BOLD | Font.ITALIC, 40));
	  Npoint = new JLabel("");
	  Npoint.setBounds(330,240,1000,100);
	  Npoint.setFont(new Font("�������", Font.BOLD | Font.ITALIC, 40));
	  Panel panel = new Panel();
	  restart = new JButton(new ImageIcon("./src/images/���Ӵٽý���.gif"));
      panel.setLayout( null );
      this.add(panel);
      this.setBackground(Color.yellow);
      this.setSize(600,700);
      this.setVisible(true);
	  this.setTitle("D & S Game");
	  
	  try {
	    	String s;
	    	String[] array;
	    	
	    	BufferedReader list = new BufferedReader(new FileReader("ȸ�����.txt"));
	    	
	    	
	    	while((s=list.readLine())!=null) {
	    		array=s.split("/");
	    		
	    	Name.setText(""+array[4]);
              
	    	}
	    	list.close();
	    }catch(Exception error) {
	    	
	    }
	  
	  try {
	    	String as;
	    	String[] aarray;
	    	
	    	BufferedReader list = new BufferedReader(new FileReader("ȸ������.txt"));
	    	
	    	
	    	while((as=list.readLine())!=null) {
	    		aarray=as.split("/");
	    		
	    		Npoint.setText("Point_"+aarray[0]);
            
	    	}
	    	list.close();
	    }catch(Exception error) {
	    	
	    }
	  
	  
     
	  restart.setBounds(180, 400, 210, 82);
	  restart.setBackground(Color.red);
	  restart.setContentAreaFilled(false);
	  restart.setFocusPainted(false);
	  restart.addActionListener(this);
 panel.add(restart);
 panel.add(Name);
 panel.add(Npoint);
  }
  

  
  class Panel extends JPanel{ //�г� ��濡 �̹��� �ֱ�
      
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(background,0,0,getWidth(),getHeight(),this);
      }
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e) {
	  
	  	

  	if(e.getSource() == restart) {

  	    dispose();
  	    new maingame();

  	}

  }
  
}