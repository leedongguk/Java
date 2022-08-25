package 애니팡;

import java.awt.*;
import javax.swing.*;
import java.awt.TextField;
import java.awt.Frame;

 class coco extends JFrame { //회원가입 성공시 나오는 팝업창

	 ImageIcon backgroundimage = new ImageIcon("./src/images/로그인성공.png");//패녈 배경에 이미지 넣기
	    Image background = backgroundimage.getImage();//패녈 배경에 이미지 넣기
   
	    coco() {
	  Panel panel = new Panel();

      panel.setLayout( null );
      this.add(panel);
      this.setBackground(Color.yellow);
      this.setSize(400,250);
      this.setVisible(true);
	  this.setTitle("D & S Game");
     
      

  }
  

  
  class Panel extends JPanel{ //패녈 배경에 이미지 넣기
      
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(background,0,0,getWidth(),getHeight(),this);
      }
  }
  
  public static void good(String args[]) {
	  new coco();
  }
  
}