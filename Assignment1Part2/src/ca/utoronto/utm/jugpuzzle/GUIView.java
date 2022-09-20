package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JProgressBar;
/**
 * This class Allows the jugs to display using JProgressBar implementation
 */
public class GUIView extends JProgressBar implements Observer {
	private static final long serialVersionUID = 1L;
	private int index;
	public GUIView(int index) {
		this.index = index;
	}
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jugPuzzle = (JugPuzzle)o;		
		//sets the max and mins of the progress bars with the respective jugs
		this.setMaximum(jugPuzzle.jugs[this.index].getCapacity());
		this.setMinimum(0);
		this.setValue(jugPuzzle.jugs[this.index].getAmount());
		this.setString(""+jugPuzzle.jugs[this.index].getAmount()+"/"+jugPuzzle.jugs[this.index].getCapacity());
		this.setStringPainted(true);
	}
}