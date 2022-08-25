package 애니팡;

import java.io.FileInputStream;
import javazoom.jl.player.Player;


public class impact  { //javazoom사이트에서 system Library를 추가함.
	
	public impact() { //게임시작할때 배경음악으로 나옴.
		
		try { 
		
			FileInputStream fis = new FileInputStream("./src/Music/터트릴때.mp3");
			Player playMp3 = new Player(fis); 
			playMp3.play();
	
			}
		
		catch(Exception e) { 
			System.out.println(e);
			}
		} 


		
	}
