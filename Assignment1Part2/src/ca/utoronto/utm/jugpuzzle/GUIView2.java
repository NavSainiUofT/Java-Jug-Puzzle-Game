package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
/**
 * This class allows the moves to show
 */
public class GUIView2 extends JLabel implements Observer {
	private static final long serialVersionUID = 1L;
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jugPuzzle = (JugPuzzle)o;
		this.setText("Moves: "+jugPuzzle.getMoves());
	}
}