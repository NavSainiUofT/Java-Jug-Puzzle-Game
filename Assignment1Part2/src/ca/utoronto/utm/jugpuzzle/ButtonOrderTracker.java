package ca.utoronto.utm.jugpuzzle;
/**
 * This class stores 2 variables that represent the status of which buttons are
 * pressed in order to keep track. If the second button is pressed then a move
 * must be made and the values are changed from negative 1 to the index of the
 * respective jug that is pressed.
 *
 */

public class ButtonOrderTracker {
	public int first;
	public int second;
	public ButtonOrderTracker() {
		//keeping track of whether one two or no buttons are pressed
		this.first = -1;
		this.second = -1;
	}
	/**
	 * resets the variables to -1
	 * @param null
	 * @return null
	 */
	public void reset() {
		this.first = -1;
		this.second = -1;
	}
}