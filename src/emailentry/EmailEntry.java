package emailentry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
	private final static String FILE = "emails.tsv";
	private final static String BACKGROUND = "./background.png";
	private final static long serialVersionUID = 1L;

	private final JTextField txtAddy;
	private final JTextField txtName;
	private final BufferedWriter out;

	public EmailEntry() throws IOException
	{
		super();

		out = new BufferedWriter(new FileWriter(FILE, true));

		setContentPane(new JLabel(new ImageIcon(BACKGROUND)));

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Font typeFont = this.getContentPane().getFont().deriveFont((float)48);
		Font mainFont = this.getContentPane().getFont().deriveFont((float)54);
		setLayout(null);
		setSize(900, 500);

		JLabel lblAddy = new JLabel("Email Address:", SwingConstants.LEFT);
		lblAddy.setFont(mainFont);
		lblAddy.setForeground(Color.white);
		lblAddy.setBounds(25, 0, 800, 100);
		add(lblAddy);

		txtAddy = new JTextField();
		txtAddy.setFont(typeFont);
		txtAddy.setBounds(50, 80, 800, 80);
		add(txtAddy);

		JLabel lblName = new JLabel("Name (Optional):", SwingConstants.LEFT);
		lblName.setFont(mainFont);
		lblName.setForeground(Color.white);
		lblName.setBounds(25, 150, 800, 80);
		add(lblName);

		txtName = new JTextField();
		txtName.setFont(typeFont);
		txtName.setBounds(50, 230, 800, 80);
		add(txtName);

		final JButton cmdSubmit = new JButton("Submit");
		cmdSubmit.setFont(mainFont);
		cmdSubmit.setBounds(600, 340, 250, 80);
		add(cmdSubmit);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		cmdSubmit.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (txtAddy.getText().isEmpty())
						return;

					try
					{
						out.write(String.format("%s\t%s\n", txtAddy.getText(), txtName.getText()));
						out.flush();
					}
					catch (IOException ex)
					{
						Logger.getLogger("EmailEntry").log(Level.SEVERE, null, ex);
						return;
					}

					txtAddy.setText("");
					txtName.setText("");
					txtAddy.requestFocusInWindow();
				}
			}
		);

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

		setVisible(true);
	}

	@Override
	public void dispose()
	{
		try
		{
			out.flush();
			out.close();
		}
		catch (IOException ex)
		{
			Logger.getLogger("EmailEntry").log(Level.SEVERE, null, ex);
		}
		finally
		{
			super.dispose();
		}
	}

	public static void main(String [] args) throws IOException
	{
		new EmailEntry();
	}
}
