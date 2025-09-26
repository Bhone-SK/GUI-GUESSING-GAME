/**
 * A hard guessing game. The only hints are right or wrong.
 * @author Bhone Sin Kyal
 * @version December 13 2024
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import java.util.Random;
import javax.swing.JScrollPane;
public class GuessingGameHardFrame extends JFrame
{
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 550;
	
	private static final int DESCRIPTION_WIDTH = 800;
	private static final int DESCRIPTION_HEIGHT = 30;
	
	private static final int CAT_WIDTH = 100;
	private static final int CAT_HEIGHT = 100;
	
	private static final int MESSAGES_WIDTH = 400;
	private static final int MESSAGES_HEIGHT = 20;
	private static final int FONT_SIZE_DESCRIPTION = 18;
	private static final int FONT_SIZE_AFTER_GUESS = 60;
	
	private static final int GUESSING_LABEL_FONT_SIZE = 30;
	
	private static final int GUESS_BAR_ROW = 4;
	private static final int GUESS_BAR_COLUMN = 5;
	
	private int correctNum;
	
	private JPanel panelForCat = new JPanel();//To display the cat
	private JLabel guessingLabel;
	private static JTextArea messagesAfterGuess;
	private JPanel panelForGuess;
	private static JTextField guessInput;
	private JButton guessEnter;
	private JComponent neutralCat;
	private JScrollPane guessScroll;
	private JTextArea previousGuessArea;
	
	public GuessingGameHardFrame()
	{
		setTitle("This is a hard guessing game. Can you pass?");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		previousGuessArea = new JTextArea(GUESS_BAR_ROW, GUESS_BAR_COLUMN);
		previousGuessArea.setEditable(false);
		setLayout(new BorderLayout());
		createDiscription();
		createGuessPanel();
		createCatFace();
		Random rand = new Random();
		correctNum = rand.nextInt(10);
		correctNum++;

	}
	/**
	 * Changes the value of the correct guess.
	 * @param newCorrectNum the new correct guess
	 */
	public void setCorrectNum(int newCorrectNum)
	{
		correctNum = newCorrectNum;
	}
	/**
	 * Gets the correct answer.
	 * @return the correct answer
	 */
	public int getCorrectNum()
	{
		return correctNum;
	}
	/**
	 * Gets the width of the frame.
	 * @return Width of the frame
	 */
	public int getFrameWidth() 
	{
	    return FRAME_WIDTH;
	}
	/**
	 * Gets the height of the frame.
	 * @return The height of the frame
	 */
	public int getFrameHeight() 
	{
	    return FRAME_HEIGHT;
	}
	/**
	 * Gets the width of the text area containing description text.
	 * @return width of the description text area
	 */
	public int getDescriptionWidth() 
	{
	    return DESCRIPTION_WIDTH;
	}
	/**
	 * Gets the height of the text area containing description text.
	 * @return height of the description text area
	 */
	public int getDescriptionHeight() 
	{
	    return DESCRIPTION_HEIGHT;
	}
	/**
	 * Gets the width of the cat component.
	 * @return the width of the cat component
	 */
	public int getCatWidth() 
	{
	    return CAT_WIDTH;
	}
	/**
	 * Gets the height of the cat component.
	 * @return the height of the cat component
	 */
	public int getCatHeight() 
	{
	    return CAT_HEIGHT;
	}
	/**
	 * Gets the width of the text area containing the hints.
	 * @return width of hints text area
	 */
	public int getMessagesWidth() 
	{
	    return MESSAGES_WIDTH;
	}
	/**
	 * Gets the height of the text area containing the hints.
	 * @return height of the hints text area
	 */
	public int getMessagesHeight() 
	{
	    return MESSAGES_HEIGHT;
	}
	/**
	 * Gets the font size for the description text.
	 * @return the font size for the description text.
	 */
	public int getFontSizeDescription() 
	{
	    return FONT_SIZE_DESCRIPTION;
	}
	/**
	 * Gets the font size for the hints.
	 * @return font size for hints
	 */
	public int getFontSizeAfterGuess() 
	{
	    return FONT_SIZE_AFTER_GUESS;
	}
	/**
	 * Gets the font size of the guess label.
	 * @return font size of the guess label
	 */
	public int getGuessingLabelFontSize() 
	{
	    return GUESSING_LABEL_FONT_SIZE;
	}
	/**
	 * Gets the number of rows for the guess bar that displays the guesses entered.
	 * @return rows of the guess bar
	 */
	public int getGuessBarRow() 
	{
	    return GUESS_BAR_ROW;
	}
	/**
	 * Gets the number of columns for the guess bar.
	 * @return columns of the guess bar
	 */
	public int getGuessBarColumn() 
	{
	    return GUESS_BAR_COLUMN;
	}
	/**
	 * Creates the description of the game.
	 */
	public void createDiscription()
	{
		panelForGuess = new JPanel();
		JTextArea discription = new JTextArea("");
		discription.setSize(DESCRIPTION_WIDTH, DESCRIPTION_HEIGHT);
		discription.setText("                           This is a guessing game. Be worried, it's the hard one." + "\n");
		discription.append("                                                I hope you are ready for a big war!" + "\n");
		discription.append("                                               You guess a number between 1 - 10." + "\n");
		discription.append("             If it's correct you win and make kitty happy. If not, good luck hiding from me!" + "\n");		
		discription.setBackground(new Color(135, 206, 235));//Sky blue.	
		discription.setFont(new Font("Papyrus", Font.BOLD, FONT_SIZE_DESCRIPTION));
		discription.setEditable(false);
		panelForGuess.add(discription);
	}
	/**
	 * Creates the cat faces. Neutral, Happy, and Sad.
	 */
	public void createCatFace()
	{
		neutralCat = new NeutralCatFace();
		neutralCat.setPreferredSize(new Dimension(CAT_WIDTH, CAT_HEIGHT));
		neutralCat.setToolTipText("Kitty feels nothing");
		panelForCat.add(neutralCat);
		add(panelForCat, BorderLayout.SOUTH);
	}
	class ClickListener implements ActionListener
	{
		/**
		 * Checks whether the user's guess is correct and display messages accordingly.
		 */
		public void actionPerformed(ActionEvent event)
		{
			int guess = 0;
			try
			{
				guess = Integer.parseInt(guessInput.getText().trim());
				previousGuessArea.append("" + guess + "\n");//Displays the guess to the user in the scroll pane.
			}
			catch (NumberFormatException exception)
			{
				messagesAfterGuess.setText("Oopps. You need to enter an integer!");
			}
			if (guess == correctNum)
			{
				messagesAfterGuess.setText("You win!!! Kitty is happy!!!");
				neutralCat.setToolTipText("Kitty is happy!!");
			}
			else
			{
				neutralCat.setToolTipText("Kitty is saddd....");
				messagesAfterGuess.setText("Wrong...Kitty is sad......");//This is displaying instead of "enter an integer" when enters wrong format
			}
		}
	}
	/**
	 * Makes the panel for the description, result of the guesses, and guess input.
	 */
	public void createGuessPanel()
	{
		messagesAfterGuess = new JTextArea("If you're ready.........GO!");//The initial message for the user.
		messagesAfterGuess.setSize(MESSAGES_WIDTH, MESSAGES_HEIGHT);
		messagesAfterGuess.setFont(new Font("Arial", Font.BOLD, FONT_SIZE_AFTER_GUESS));
		messagesAfterGuess.setBackground(new Color(194, 30, 86));//Rose red.
		messagesAfterGuess.setEditable(false);
		guessInput = new JTextField("             ");
		guessingLabel = new JLabel("Please enter your guess here: ");
		guessingLabel.setFont(new Font("Papyrus", Font.BOLD, GUESSING_LABEL_FONT_SIZE));
		guessEnter = new JButton("Click to see the result");//Checks the user's guess.
		guessScroll = new JScrollPane(previousGuessArea);
		guessEnter.addActionListener(new ClickListener());
		panelForGuess.add(messagesAfterGuess);
		panelForGuess.add(guessingLabel);
		panelForGuess.add(guessInput);
		panelForGuess.add(guessEnter);
		panelForGuess.add(guessScroll);
		panelForGuess.setBackground(new Color(255, 255, 143));//Canary yellow.
		add(panelForGuess);
	}

}
