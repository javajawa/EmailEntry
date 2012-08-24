package emailentry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextFile implements IReg
{

	private final static String FILE = "emails.tsv";

	private final BufferedWriter out;

	public TextFile() throws IOException
	{
		/**
		 * Attempt to open the target file
		 */
		out = new BufferedWriter(new FileWriter(FILE, true));
	}

	public void regist(String email, String name)
	{
		try
		{
			out.write(String.format("%s\t%s\n", email, name));
			out.flush();
		}
		catch (IOException ex)
		{
			Logger.getLogger("EmailEntry").log(Level.SEVERE, null, ex);
			return;
		}
	}

	/**
	 * Make sure the file is written to when the application is closed
	 */
	protected void dispose()
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
	}
}

