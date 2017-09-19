package AES;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import interfaceUsed.encryptDecrypt;

public class ASE_algorithm implements encryptDecrypt {
	Cipher AESchiper;
	SecretKey _keySpace;
	SecretKeySpec _keySpaceAlt;
	byte[] message;
	byte[] decryptMessage;
	byte[] encryptedMessage;
	String messageToEncrypt;
	public ASE_algorithm() {}
	public void enterMessage(String messageToEncrypt) {
		System.out.println("original message");
		 this.messageToEncrypt=messageToEncrypt;
		 
	}
	 void generateKey() {
		try {
			KeyGenerator _generator=KeyGenerator.getInstance("AES");
			_keySpace=_generator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void generateKey(String keySpace) {
		 _keySpaceAlt=new SecretKeySpec(keySpace.getBytes(),"AES");
	}
	public void messageToEncrypt() {
		System.out.println("original message"+messageToEncrypt);
		
		 message=messageToEncrypt.getBytes();
		 
	}
	 void getChiperInstance() {
		try {
			AESchiper=Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 void encryptMessage() {
		try {
			getChiperInstance();
			AESchiper.init(Cipher.ENCRYPT_MODE,_keySpace);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 encryptedMessage=AESchiper.doFinal(message);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void decryptMessage() {
		
		try {
			AESchiper.init(Cipher.DECRYPT_MODE,_keySpace);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			decryptMessage=AESchiper.doFinal(encryptedMessage);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	@Override
	public void startEncryption() {
		// TODO Auto-generated method stub
		messageToEncrypt();
		generateKey();
		encryptMessage();
	}
	@Override
	public void startDecryption() {
		decryptMessage();
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEncryptedData() {
		return new String(encryptedMessage);
		// TODO Auto-generated method stub
		//return null;
	}
	@Override
	public String getDecryptedData() {
		return new String(decryptMessage);
		// TODO Auto-generated method stub
		//return null;
	}
}
