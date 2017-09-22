package hashFunction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import interfaceUsed.Hashing;

public class hashAction implements Hashing {
	MessageDigest _messageDigest;
	String message;
	byte[] encodedHashMessage;
	public hashAction() {
		try {
		_messageDigest=MessageDigest.getInstance("SHA-512");
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Override
	public void enterMessage(String _message) {
		// TODO Auto-generated method stub
		message=_message;
	}
	@Override
	public void doHashEncoding() {
		// TODO Auto-generated method stub
		encodedHashMessage=_messageDigest.digest(message.getBytes());
		
	}
	@Override
	public String showHashedMessage() {
		// TODO Auto-generated method stub
		String encodedMessage=new String(Base64.getEncoder().encode(encodedHashMessage));
		return encodedMessage;
	}
}
