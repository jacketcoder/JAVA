package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Label;
import javax.swing.JFrame;

public class UI {
	public static void main(String[] args) {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame windowEntry=new JFrame("Encryptions Methods");
		windowEntry.setSize(500,500);
		Label label=new Label();
		windowEntry.getContentPane().add(label, BorderLayout.CENTER);
		String[] encryptionsAlgoNames= {"ASE","CaesarChiper","RC4_Encryption"};
		chooseEncryptionMethod _chooseEncryptionMethod=new chooseEncryptionMethod(windowEntry,encryptionsAlgoNames);
		windowEntry.add(_chooseEncryptionMethod.returnPanel());
		windowEntry.setVisible(true);
		windowEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//windowEntry.pack();
	}
}
