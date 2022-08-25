package 자바프로젝트;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class LoginSuccess extends JFrame{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/로그인성공.png"); 
    Image back = backgroundimage.getImage(); 

    
    LoginSuccess(){
        this.setTitle("이동국오락기"); 
        

        Panel panel = new Panel();
        panel.setLayout( null ); 
        this.add(panel); 
        this.setSize(300,500);
        this.setVisible(true);  
           
    }
       
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }

