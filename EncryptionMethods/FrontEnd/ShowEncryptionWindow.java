package FrontEnd;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AES.ASE_algorithm;
import RC4Encryption.RC4;
import caesarChiper.caesarChiper;
import hashFunction.hashAction;
import hashingSHA.SHA3Hashing;
import interfaceUsed.Hashing;
import interfaceUsed.encryptDecrypt;

public class ShowEncryptionWindow {
	Box verticalBox;
	Label label;
	JPanel panel;
	JTextField messageEntry,encryptedMessage,decryptedMessage;
	JFrame windowEntry;
	JLabel message,encryptedMessageL,decryptedMessageL;
	encryptDecrypt _encryptDecrypt;
	Hashing hashing;
	JButton startProcess,closeWindow;
	boolean encrypt;
	ShowEncryptionWindow(int index){
		
		windowEntry=new JFrame(InitializeAlgo(index));
		 label=new Label();
		windowEntry.setSize(500,500);
		panel = new JPanel();
		windowEntry.getContentPane().add(label, BorderLayout.CENTER);
		windowEntry.add(panel);
		verticalBox=Box.createVerticalBox();
		panel.add(verticalBox);
		
		
		message=addLabelsOnFrame(message,"message to encrypt");
		panel.add(message);
		messageEntry=addTextBox(messageEntry);
		panel.add(messageEntry);
		
		if(encrypt) {
		encryptedMessageL=addLabelsOnFrame(encryptedMessageL,"encrypted message");
		panel.add(encryptedMessageL);
		encryptedMessage=addTextBox(encryptedMessage);
		panel.add(encryptedMessage);
		
		decryptedMessageL=addLabelsOnFrame(decryptedMessageL,"decrypted message");
		panel.add(decryptedMessageL);
		decryptedMessage=addTextBox(decryptedMessage);
		panel.add(decryptedMessage);
		}
		else {
			decryptedMessageL=addLabelsOnFrame(decryptedMessageL,"hashed message");
			panel.add(decryptedMessageL);
			decryptedMessage=addTextBox(decryptedMessage);
			panel.add(decryptedMessage);	
		}
		startProcess=new JButton(" Start "+windowEntry.getTitle());
		panel.add(startProcess);
		startProcess.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					doAction();
				}
	          });
		closeWindow=new JButton("Close Window");
		panel.add(closeWindow);
		closeWindow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				windowEntry.dispose();
			}
          });
		windowEntry.setVisible(true);
		//windowEntry.pack();
	}
	void doAction() {
		String messageToEncrypt=messageEntry.getText();
		//messageEntry.setText("Ada");
		if(encrypt) {
		System.out.println("Sending message"+" "+messageToEncrypt);
		_encryptDecrypt.enterMessage(messageToEncrypt);
		_encryptDecrypt.startEncryption();
		_encryptDecrypt.startDecryption();
		encryptedMessage.setText(_encryptDecrypt.getEncryptedData());
		decryptedMessage.setText(_encryptDecrypt.getDecryptedData());
		}
		else {
			System.out.println("message to hash"+" "+messageToEncrypt);
			hashing.enterMessage(messageToEncrypt);
			hashing.doHashEncoding();
			decryptedMessage.setText(hashing.showHashedMessage());
			
			
		}
	}
	String InitializeAlgo(int index) {
		switch(index) {
		case 0:{
			//ASE
			_encryptDecrypt=new ASE_algorithm();
			encrypt=true;
			return "ASE_algorithm";
		}
			
		case 1:{
			//ASE
			_encryptDecrypt=new caesarChiper();
			encrypt=true;
			return "caesarChiper";
	}
	
		case 2:{
			//ASE
			_encryptDecrypt=new RC4();
			encrypt=true;
			return "RC4";
			
			}
		
		case 3:{
		//simple hash
			hashing=new hashAction();
			encrypt=false;
			return"hashAction";
			
		}
		case 4:{
			hashing=new SHA3Hashing();
			encrypt=false;
			return "SHA3Hashing";
		}
		}
		return null;
	}
	
	JLabel addLabelsOnFrame(JLabel label,String displayWords) {
		label=new JLabel();
		label.setText(displayWords);
		return label;
		
	}
	 JTextField addTextBox(JTextField textBox) {
		textBox=new JTextField();
		textBox.setColumns(30);
		return textBox;
	}
	
}
