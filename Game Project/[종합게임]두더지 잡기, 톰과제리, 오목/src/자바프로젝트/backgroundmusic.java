package �ڹ�������Ʈ;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class backgroundmusic {

	backgroundmusic() {
		
		try { 
			do {
			
			Player background = new Player(new FileInputStream("./src/Music/�������.mp3")); 
			background.play();
			}
			while(true);
			}
		
		catch(Exception e) { 
			
			}
		
	}
	
}
