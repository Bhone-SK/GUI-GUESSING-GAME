/**
 * Draws the cat face.
 * @author Bhone Sin Kyal
 * @version December 12 2024
 */
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
public class NeutralCatFace extends JComponent
{
	/**
	 * Makes a neutral face.
	 */
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
        g.fillOval(25, 25, 50, 50); // Head

        g.setColor(Color.PINK);
        g.fillArc(25, 27, 12, 17, 33, 190); // Left outer ear
        g.fillArc(60, 25, 12, 17, 330, 185); // Right outer ear

        g.setColor(new Color(248, 200, 220));
        g.fillArc(28, 29, 7, 12, 30, 180); // Left inner ear
        g.fillArc(63, 27, 7, 12, 335, 180); // Right inner ear

        g.setColor(new Color(228, 208, 10));
        g.fillOval(40, 40, 5, 8); // Left eye
        g.fillOval(55, 40, 5, 8); // Right eye


        g.setColor(Color.BLACK);
        g.drawLine(15, 40, 30, 45); // First left whisker
        g.drawLine(15, 50, 30, 50); // Second left whisker
        g.drawLine(15, 60, 30, 55); // Third left whisker
        g.drawLine(70, 45, 85, 40); // First right whisker
        g.drawLine(70, 50, 85, 50); // Second right whisker
        g.drawLine(70, 55, 85, 60); // Third right whisker
	}
}
