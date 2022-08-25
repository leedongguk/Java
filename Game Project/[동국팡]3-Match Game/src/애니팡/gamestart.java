package 애니팡;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;

import 동국세인팡.PlayMusic;


class start extends JFrame implements ActionListener {
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/qwe.jpg"); //패널에 배경 넣기(1)
    Image back = backgroundimage.getImage(); //패널에 배경 넣기(2)
     
    JButton gamestartbutton; //게임시작버튼
   
    
    
    start(){
        this.setTitle("D & S Game"); //타이틀 제목
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        gamestartbutton = new JButton(new ImageIcon("./src/images/게임시작버튼.gif"));//게임시작버튼에 이미지 삽입
        
        
         
        Panel panel = new Panel();
        
        panel.setLayout( null ); //패널을 절대적 위치로 설정
        panel.add(gamestartbutton);//패널 위에 버튼을 추가
        gamestartbutton.setBounds(230, 350, 210, 75); //게임시작 버튼 위치 및 크기 설정
        gamestartbutton.setBackground(Color.red); //게임시작버튼 바탕색 설정
        gamestartbutton.setContentAreaFilled(false);//버튼영역 배경표시 설정
        gamestartbutton.setFocusPainted(false);//버튼 포커스 표시설정
        gamestartbutton.addActionListener(this);//게임시작버튼에 이벤트 추가
        
        this.add(panel); //패널 추가
        this.setSize(692,506);//패널 사이즈 설정
        this.setVisible(true);
        new PlayMusic();//배경음악 틀기
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource() == gamestartbutton) { //게임시작 버튼이 눌려지면
    		
    		dispose(); //현재 창이 없어지고
    	 new LoginStart(); //로그인스타트창이 켜짐
    	 new error();
    	
    	 
    	}
    	
    	
    }
    class Panel extends JPanel{ //패널에 배경 넣기(3)
            
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

