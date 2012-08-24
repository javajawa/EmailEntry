package emailentry;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

public class MailmanLink implements IReg
{
	private final String list;

	private final static String format =
		"http://mailman.ic.ac.uk/mailman/subscribe/%s/?email=%s&fullname=%s";

	public MailmanLink(String list)
	{
		this.list = list;
	}

	public void regist(String email, String name)
	{
		final String url = String.format(format, list, email, name);
		final HttpURLConnection conn;
		try
		{
			conn = (HttpURLConnection)new URL(url).openConnection();

			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Can not write to mailman");
		}
		catch (IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}
}

