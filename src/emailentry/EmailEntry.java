package emailentry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class EmailEntry extends JFrame
{
	private final static String BACKGROUND = "./background.png";
	private final static long serialVersionUID = 1L;

	private final JTextField txtAddy;
	private final JTextField txtName;

	private final IReg regist;

	public EmailEntry() throws IOException
	{
		super();

		regist = new TextFile(); // Or new MailmanLink("list-name");

		/**
		 * Manual layout and sizing, defaulting to maximised
		 */
		setLayout(null);
		setSize(900, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		/**
		 * Set up the background image
		 */
		setContentPane(new JLabel(new ImageIcon(BACKGROUND)));

		/**
		 * Configure the fonts and colors the components will use
		 */
		Font typeFont = this.getContentPane().getFont().deriveFont((float)48);
		Font mainFont = this.getContentPane().getFont().deriveFont((float)54);
		Color textColor = Color.WHITE;

		/**
		 * Email address field and label
		 */
		JLabel lblAddy = new JLabel("Email Address:", SwingConstants.LEFT);
		lblAddy.setFont(mainFont);
		lblAddy.setForeground(Color.white);
		lblAddy.setBounds(25, 0, 800, 100);
		add(lblAddy);

		txtAddy = new JTextField();
		txtAddy.setFont(typeFont);
		txtAddy.setBounds(50, 80, 800, 80);
		add(txtAddy);

		/**
		 * Name field and label
		 */
		JLabel lblName = new JLabel("Name (Optional):", SwingConstants.LEFT);
		lblName.setFont(mainFont);
		lblName.setForeground(Color.white);
		lblName.setBounds(25, 150, 800, 80);
		add(lblName);

		txtName = new JTextField();
		txtName.setFont(typeFont);
		txtName.setBounds(50, 230, 800, 80);
		add(txtName);

		/**
		 * Submit button
		 */
		final JButton cmdSubmit = new JButton("Submit");
		cmdSubmit.setFont(mainFont);
		cmdSubmit.setBounds(600, 340, 250, 80);
		add(cmdSubmit);

		/**
		 * Add code to write to file when submit is clicked
		 */
		cmdSubmit.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (txtAddy.getText().isEmpty())
						return;

					regist.regist(txtAddy.getText(), txtName.getText());

					txtAddy.setText("");
					txtName.setText("");
					txtAddy.requestFocusInWindow();
				}
			}
		);

		/**
		 * Automatically submit when the enter key is pressed on any field
		 */
		KeyListener k = new KeyListener()
		{
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyPressed(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					cmdSubmit.doClick();
			}
		};

		txtAddy.addKeyListener(k);
		txtName.addKeyListener(k);
		cmdSubmit.addKeyListener(k);

		/**
		 * Show the window
		 */
		setVisible(true);
	}

	/**
	 * Program launch
	 * @throws IOException if the target file can not be opened
	 */
	public static void main(String [] args) throws IOException
	{
		new EmailEntry();
	}
}
