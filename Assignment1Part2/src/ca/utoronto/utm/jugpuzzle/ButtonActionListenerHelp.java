package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *When the help button is pressed, gives the user information about the game
 *
 */
public class ButtonActionListenerHelp implements ActionListener {
	ButtonActionListenerHelp (){
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"Welcome To 'Jug Puzzle'. "
				+ "You may click a jug \n to select it and then click the jug you wish to pour into.\n"
				+ " The game is won when jug 0 and jug 1 \n have a quantity of 4 in each of them. Good Luck!","Help",JOptionPane.INFORMATION_MESSAGE);
		}
	}