package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class ButtonActionListener implements ActionListener {
	private JugPuzzle jugpuzzle;
	private ButtonOrderTracker btnAction;
	private int index;
	ButtonActionListener(JugPuzzle jugpuzzle, ButtonOrderTracker btnAction, int index){
		this.jugpuzzle = jugpuzzle;
		this.btnAction = btnAction;
		this.index = index;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// checks if any button was pressed if both are pressed, then makes the move
		// if none are pressed, makes the first one the index of the button
		// if the first is pressed, makes the second one the index of the button
		// when the user wins the game is disabled but u may press reset and a pop up window comes up
		if (this.jugpuzzle.getIsPuzzleSolved() == true){
			JOptionPane.showMessageDialog(null,"You Won in "+this.jugpuzzle.getMoves()+
					" Moves! Press 'New Game' To Play Again","You Win!", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
		if (btnAction.first == -1) {
			btnAction.first = this.index;
		}
		else if(btnAction.second == -1) {
			btnAction.second = this.index;	
		}	
		if (btnAction.first!=-1 && btnAction.second!=-1) {
			this.jugpuzzle.move(btnAction.first, btnAction.second);
			btnAction.reset();
			if (this.jugpuzzle.getIsPuzzleSolved()) {
				JOptionPane.showMessageDialog(null,"You Won in "+this.jugpuzzle.getMoves()+
						" Moves! Press 'New Game' To Play Again","You Win!", JOptionPane.INFORMATION_MESSAGE);
				}
			}	 
		}
	}
}