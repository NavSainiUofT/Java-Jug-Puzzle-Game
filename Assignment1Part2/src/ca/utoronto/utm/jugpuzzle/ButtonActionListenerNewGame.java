package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Resets the jug puzzle to the starting state
 *
 */
public class ButtonActionListenerNewGame implements ActionListener {
	private JugPuzzle jugPuzzle;
	private ButtonOrderTracker buttonOrderTracker;
	ButtonActionListenerNewGame(JugPuzzle jugPuzzle,ButtonOrderTracker buttonOrderTracker){
		this.jugPuzzle = jugPuzzle;
		this.buttonOrderTracker = buttonOrderTracker;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.jugPuzzle.reset();
		this.buttonOrderTracker.reset();
	}
}