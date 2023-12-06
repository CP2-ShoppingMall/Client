import home.MainFrame;
import kimit.api.ClientWrapper;

import javax.swing.*;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored)
		{

		}

		ClientWrapper.init("chuncheon.kimit.kro.kr", 8000); // set address "localhost" when testing. it needs running server.
		try
		{
			ClientWrapper.get().getClient().connect();
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "서버 연결 실패!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		new MainFrame();
	}
}
