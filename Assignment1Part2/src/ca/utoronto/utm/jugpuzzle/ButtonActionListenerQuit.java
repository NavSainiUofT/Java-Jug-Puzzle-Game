package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *When the help button is pressed, gives the user information about the game
 *
 */
public class ButtonActionListenerQuit implements ActionListener {
	private JFrame frame;
	ButtonActionListenerQuit(JFrame frame){
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		}
	}