package �ִ���;

import java.io.FileInputStream;
import javazoom.jl.player.Player;


public class impact  { //javazoom����Ʈ���� system Library�� �߰���.
	
	public impact() { //���ӽ����Ҷ� ����������� ����.
		
		try { 
		
			FileInputStream fis = new FileInputStream("./src/Music/��Ʈ����.mp3");
			Player playMp3 = new Player(fis); 
			playMp3.play();
	
			}
		
		catch(Exception e) { 
			System.out.println(e);
			}
		} 


		
	}
