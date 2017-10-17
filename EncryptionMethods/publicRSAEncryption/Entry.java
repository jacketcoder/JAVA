package publicRSAEncryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import interfaceUsed.encryptDecrypt;

public class Entry {
	public static void main(String []args) {
		String message="sagar{}|:<?::|";
		encryptDecrypt publicRSA=new RSA();
		KeyPairGenerator keyPairGenerator=null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyPairGenerator.initialize(1024);
		KeyPair keyPair=keyPairGenerator.genKeyPair();
		publicRSA.startEncryption(keyPair.getPublic(),message)	;
		String encryptedMessage=publicRSA.getEncryptedData();
		System.out.println("encryptedMessage is  "+encryptedMessage);
		publicRSA.startDecryption(keyPair.getPrivate(), publicRSA.getEncryptedData());
		System.out.println("decryptedMessage is  "+publicRSA.getDecryptedData());
		
		
	}

}
