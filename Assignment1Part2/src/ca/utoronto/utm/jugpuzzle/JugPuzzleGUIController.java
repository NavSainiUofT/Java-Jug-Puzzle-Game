package ca.utoronto.utm.jugpuzzle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
/**
 * This class is the Controller for the visual jugpuzzle game and it
 * links with the model (JugPuzzle) and the View (GUIView) to implement
 * the MVC method. It alows the user to see the moves they are making
 * and gives them an interface that is more effective than the console
 * 
 */
public class JugPuzzleGUIController {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gameGUI();
			}
		});
	}
	/**
	 * This method initializes the GUI and creates the layout
	 * it also calls the required methods accordingly to run the game
	 * @param null
	 * @return null
	 */
	public static void gameGUI() {
		//model
		JugPuzzle jp = new JugPuzzle();
		//view
		// the number arguments represent the jug indexes. this way
		// we do not need to touch the jug class at all
		// added a special case to display the moves with 3
		//providing code simplicity
		GUIView guiView1 = new GUIView(0);
		GUIView guiView2 = new GUIView(1);
		GUIView guiView3 = new GUIView(2);
		//calls the seperate GUIView created for the moves
		GUIView2 guiViewMoves = new GUIView2();
		//link view and model
		jp.addObserver(guiView1);
		jp.addObserver(guiView2);
		jp.addObserver(guiView3);
		jp.addObserver(guiViewMoves);
		guiViewMoves.setHorizontalAlignment(JLabel.CENTER);
		JFrame frame = new JFrame("JugPuzzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(5,2));
		JButton b1,b2,b3,b4,b5,b6;
		// make buttons
		b1 = new JButton("Jug 0");
		b2 = new JButton("Jug 1");
		b3 = new JButton("Jug 2");
		b4 = new JButton("New Game");
		b5 = new JButton("Help");
		b6 = new JButton("Quit");
		//adds buttons and jlabels to the gui interface
		frame.getContentPane().add(guiView1);
		frame.getContentPane().add(b1);
		frame.getContentPane().add(guiView2);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(guiView3);
		frame.getContentPane().add(b3);
		frame.getContentPane().add(b4);
		frame.getContentPane().add(guiViewMoves);
		frame.getContentPane().add(b5);
		frame.getContentPane().add(b6);
		// this keeps track of which button is pressed first or second
		ButtonOrderTracker buttonOrderTracker = new ButtonOrderTracker();
		//passed the first and second buttons if pressed to the action listener 
		//with the index which represents its respective jug.
		ButtonActionListener jgb1 = new ButtonActionListener(jp,buttonOrderTracker,0);
		ButtonActionListener jgb2 = new ButtonActionListener(jp,buttonOrderTracker,1);
		ButtonActionListener jgb3 = new ButtonActionListener(jp,buttonOrderTracker,2);
		ButtonActionListenerNewGame newgame = new ButtonActionListenerNewGame(jp,buttonOrderTracker);
		ButtonActionListenerHelp help = new ButtonActionListenerHelp();
		ButtonActionListenerQuit quit = new ButtonActionListenerQuit(frame);
		//adds the listener to each button respectively
		b1.addActionListener(jgb1);
		b2.addActionListener(jgb2);
		b3.addActionListener(jgb3);
		//adds actions to the newgame button and the help button
		b4.addActionListener(newgame);
		b5.addActionListener(help);
		//allows the user to quit via quit button
		b6.addActionListener(quit);
		frame.pack();
		frame.setVisible(true);
	}
}