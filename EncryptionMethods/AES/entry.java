package AES;
import AES.ASE_algorithm;
import interfaceUsed.encryptDecrypt;

public class entry {
	
	public static void main(String[] args) {
		String message="httpfacebookcom";
	    System.out.println("Starting AES_algorithm");
		System.out.println("Sending message"+" "+message);
		encryptDecrypt _AES_algorithm=new ASE_algorithm();
		_AES_algorithm.enterMessage(message);
		_AES_algorithm.startEncryption();
		String encryptedMessage=_AES_algorithm.getEncryptedData();
		System.out.println("encryptedMessage is  "+encryptedMessage);
		_AES_algorithm.startDecryption();
		System.out.println("decryptedMessage is  "+_AES_algorithm.getDecryptedData());
		
}
}
