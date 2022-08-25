package 애니팡;

import java.awt.*;
import javax.swing.*;
import java.awt.TextField;
import java.awt.Frame;

 class gameover extends JFrame { //회원가입 성공시 나오는 팝업창

	 ImageIcon backgroundimage = new ImageIcon("./src/images/gameover.png");//패녈 배경에 이미지 넣기
	    Image background = backgroundimage.getImage();//패녈 배경에 이미지 넣기
	    
	    
	    
  gameover() {
	  new RANK();
	  Panel panel = new Panel();

      panel.setLayout( null );
      this.add(panel);
      this.setBackground(Color.yellow);
      this.setSize(800,395);
      this.setVisible(true);
	  this.setTitle("D & S Game");
     
      

  }
  

  
  class Panel extends JPanel{ //패녈 배경에 이미지 넣기
      
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          g.drawImage(background,0,0,getWidth(),getHeight(),this);
      }
  }
  
}
