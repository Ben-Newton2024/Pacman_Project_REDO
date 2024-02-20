package Old_Code;
/*
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Gifrunner extends JPanel {

	public static void audio(String fileNameWav) 
	{
		try 
		{
			File file = new File(fileNameWav);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} 
		catch (Exception e) 
		{
			System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
		}
	}
	
	
	private static String arg;
	
	public static void gifffy(String File, String Filewav)
	{
		arg = File;
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JLabel l = new JLabel();
		ImageIcon icon = new ImageIcon(arg);  
		int y = icon.getIconHeight();
		int x = icon.getIconWidth();
		f.setSize(x,y);
		f.setVisible(true);
		l.setIcon(icon);
		p.add(l);
		f.getContentPane().add(p);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		audio(Filewav);
	}
}

 */
