package �ִ���;

import java.awt.*;
import javax.swing.*;
import java.awt.TextField;
import java.awt.Frame;

 class coco extends JFrame { //ȸ������ ������ ������ �˾�â

	 ImageIcon backgroundimage = new ImageIcon("./src/images/�α��μ���.png");//�г� ��濡 �̹��� �ֱ�
	    Image background = backgroundimage.getImage();//�г� ��濡 �̹��� �ֱ�
   
	    coco() {
	  Panel panel = new Panel();

      panel.setLayout( null );
      this.add(panel);
      this.setBackground(Color.yellow);
      this.setSize(400,250);
      this.setVisible(true);
	  this.setTitle("D & S Game");
     
      

  }
  

  
  class Panel extends JPanel{ //�г� ��濡 �̹��� �ֱ�
      
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(background,0,0,getWidth(),getHeight(),this);
      }
  }
  
  public static void good(String args[]) {
	  new coco();
  }
  
}