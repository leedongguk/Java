package �ִ���;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;

import ����������.PlayMusic;


class start extends JFrame implements ActionListener {
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/qwe.jpg"); //�гο� ��� �ֱ�(1)
    Image back = backgroundimage.getImage(); //�гο� ��� �ֱ�(2)
     
    JButton gamestartbutton; //���ӽ��۹�ư
   
    
    
    start(){
        this.setTitle("D & S Game"); //Ÿ��Ʋ ����
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        gamestartbutton = new JButton(new ImageIcon("./src/images/���ӽ��۹�ư.gif"));//���ӽ��۹�ư�� �̹��� ����
        
        
         
        Panel panel = new Panel();
        
        panel.setLayout( null ); //�г��� ������ ��ġ�� ����
        panel.add(gamestartbutton);//�г� ���� ��ư�� �߰�
        gamestartbutton.setBounds(230, 350, 210, 75); //���ӽ��� ��ư ��ġ �� ũ�� ����
        gamestartbutton.setBackground(Color.red); //���ӽ��۹�ư ������ ����
        gamestartbutton.setContentAreaFilled(false);//��ư���� ���ǥ�� ����
        gamestartbutton.setFocusPainted(false);//��ư ��Ŀ�� ǥ�ü���
        gamestartbutton.addActionListener(this);//���ӽ��۹�ư�� �̺�Ʈ �߰�
        
        this.add(panel); //�г� �߰�
        this.setSize(692,506);//�г� ������ ����
        this.setVisible(true);
        new PlayMusic();//������� Ʋ��
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource() == gamestartbutton) { //���ӽ��� ��ư�� ��������
    		
    		dispose(); //���� â�� ��������
    	 new LoginStart(); //�α��ν�ŸƮâ�� ����
    	 new error();
    	
    	 
    	}
    	
    	
    }
    class Panel extends JPanel{ //�гο� ��� �ֱ�(3)
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    
    
    
}



public class gamestart {
    public static void main(String[] args) {
         new start();
    } 
}

