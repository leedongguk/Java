package 자바프로젝트;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class backgroundmusic {

	backgroundmusic() {
		
		try { 
			do {
			
			Player background = new Player(new FileInputStream("./src/Music/배경음악.mp3")); 
			background.play();
			}
			while(true);
			}
		
		catch(Exception e) { 
			
			}
		
	}
	
}
