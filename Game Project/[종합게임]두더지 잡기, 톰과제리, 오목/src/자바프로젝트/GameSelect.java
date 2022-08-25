package 자바프로젝트;

import java.awt.*;
import javax.swing.*;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class GameSelect extends JFrame{
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/게임선택.png"); 
    Image back = backgroundimage.getImage(); 
    JLabel Packman;
    JLabel Mole;
    JLabel Omok;
    JLabel Packman1;
    JLabel Mole1;
    JLabel Omok1;
    JLabel Name;
    
    int select = 1;
    
    GameSelect(){
        this.setTitle("이동국오락기"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Name = new JLabel("");
  	  Name.setBounds(150,440,400,100);
  	  Name.setFont(new Font("굵은고딕", Font.BOLD | Font.ITALIC, 40));
        
        Panel panel = new Panel();
        panel.setLayout( null ); 
        Packman = new JLabel(new ImageIcon("./src/images/3-3.jpg"));
        Mole = new JLabel(new ImageIcon("./src/images/1-1.png"));
        Omok = new JLabel(new ImageIcon("./src/images/2-2.jpg"));
        Packman1 = new JLabel(new ImageIcon("./src/images/c.jpg"));
        Mole1 = new JLabel(new ImageIcon("./src/images/a.png"));
        Omok1 = new JLabel(new ImageIcon("./src/images/v.jpg"));
        
        
        Omok.setBounds(680, 130, 150,150);
        Mole.setBounds(480, 125, 150,150);
        Packman.setBounds(880, 130, 150,150);
        Omok1.setBounds(680, 130, 150,150);
        Mole1.setBounds(480, 125, 150,150);
        Packman1.setBounds(880, 130, 150,150);
        panel.add(Name);
        panel.add(Omok);
        this.add(panel); 
        this.setSize(1200,700);
        this.setVisible(true);  
        name();
        
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
            	
            	int keyCode = event.getKeyCode();
            	
  
            	
            	
            	if(keyCode == KeyEvent.VK_SPACE) {
            		
                	if(select == 0) {
                		new mole1();
                	    dispose();
                	}
                	else if(select == 1) {
                		new omokstart();
                	    dispose();
                	}
                	else if(select == 2) {
                		new pacmanstart();
                	    dispose();
                	}
            		
                	}
            	
            	
            	if(keyCode == KeyEvent.VK_RIGHT) {
            		System.out.println(select);
            		panel.remove(Omok);
            		            if(select >= 0 && select < 2) {
            		            	select += 1;
            		            	if(select == 0) {
            		            		panel.remove(Mole);
            		            		panel.remove(Omok);
            		            		panel.remove(Packman);
            		            		panel.remove(Mole1);
            		            		panel.remove(Omok1);
            		            		panel.remove(Packman1);
            		            		panel.add(Mole);
            		            	    panel.add(Packman1);
            		            	    panel.add(Omok1);

            		            	    Packman1.updateUI();
            		            	    Omok1.updateUI();
            		            		Mole.updateUI();
            		            	}
            		            	else if(select == 1) {
            		            		
            		            		panel.remove(Mole);
            		            		panel.remove(Omok);
            		            		panel.remove(Packman);
            		            		panel.remove(Mole1);
            		            		panel.remove(Omok1);
            		            		panel.remove(Packman1);
            		            		
            		            		 panel.add(Omok);
            		            	
            		            		 panel.add(Packman1);
             		            	    panel.add(Mole1);

             		            	    Packman1.updateUI();
             		            	    Mole1.updateUI();
            		            		 
            		            		Omok.updateUI();
            		            	}
            		            	else if(select == 2) {
            		            		panel.remove(Mole);
            		            		panel.remove(Omok);
            		            		panel.remove(Packman);
            		            		panel.remove(Mole1);
            		            		panel.remove(Omok1);
            		            		panel.remove(Packman1);
            		            		 panel.add(Packman);   
            		            		 
            		            		 panel.add(Mole1);
             		            	    panel.add(Omok1);

             		            	    Mole1.updateUI();
             		            	    Omok1.updateUI();
            		            		 
            		            		Packman.updateUI();
            		            		
            		            	}
            		            }
            	}
            	else if(keyCode == KeyEvent.VK_LEFT) {
            		System.out.println(select);
            		if(select > 0 && select <= 2) {
            			select -= 1;
            			if(select == 0) {
            				
            				panel.remove(Mole);
		            		panel.remove(Omok);
		            		panel.remove(Packman);
		            		panel.remove(Mole1);
		            		panel.remove(Omok1);
		            		panel.remove(Packman1);
		            		 panel.add(Mole);
		            		 
		            		 panel.add(Packman1);
 		            	    panel.add(Omok1);

 		            	    Packman1.updateUI();
 		            	    Omok1.updateUI();
		            		 
		            		Mole.updateUI();
		            	}
		            	else if(select == 1) {
		            		panel.remove(Mole);
		            		panel.remove(Omok);
		            		panel.remove(Packman);
		            		panel.remove(Mole1);
		            		panel.remove(Omok1);
		            		panel.remove(Packman1);
		            		 panel.add(Omok);
		            		 
		            		 panel.add(Packman1);
 		            	    panel.add(Mole1);

 		            	    Packman1.updateUI();
 		            	    Mole1.updateUI();
		            		
		            		Omok.updateUI();
		            	}
		            	else if(select == 2) {
		            		panel.remove(Mole);
		            		panel.remove(Omok);
		            		panel.remove(Packman);
		            		panel.remove(Mole1);
		            		panel.remove(Omok1);
		            		panel.remove(Packman1);
		            		
		            		
		            		 panel.add(Packman);
		            		 
		            		 panel.add(Mole1);
 		            	    panel.add(Omok1);

 		            	    Mole1.updateUI();
 		            	    Omok1.updateUI();
		            		 
		            		Packman.updateUI();
		            	}
            			
		            }
            		
                }
            	
            	
                
            }
            });  
        
        
        
       
        
    }
       
    public void name() {
    	try {
	    	String s;
	    	String[] array;
	    	
	    	BufferedReader list = new BufferedReader(new FileReader("회원명단.txt"));
	    	
	    	
	    	while((s=list.readLine())!=null) {
	    		array=s.split("/");
	    		
	    	Name.setText(""+array[0]);
              
	    	}
	    	list.close();
	    }catch(Exception error) {
	    	
	    }
    }
    
    
    class Panel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this);
        }
    }
    }

