package �ڹ�������Ʈ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class LoginSuccess extends JFrame{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/�α��μ���.png"); 
    Image back = backgroundimage.getImage(); 

    
    LoginSuccess(){
        this.setTitle("�̵���������"); 
        

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

