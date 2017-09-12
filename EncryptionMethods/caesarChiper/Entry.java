package caesarChiper;

import interfaceUsed.encryptDecrypt;

public class Entry {
	 public static void main(String[] args) {
			String message="httpfacebookcom";
	        System.out.println("Starting caesarChiper");
			System.out.println("Sending message"+" "+message);
			encryptDecrypt _caesarChiper=new caesarChiper(message,2,'l');
			_caesarChiper.startEncryption();
			String encryptedMessage=_caesarChiper.getEncryptedData();
			System.out.println("encryptedMessage is  "+encryptedMessage);
			_caesarChiper.startDecryption();
			System.out.println("decryptedMessage is  "+_caesarChiper.getDecryptedData());
			System.out.println("breaking the caesarChiper code by brute attack");
			breakingChiper _breakingChiper=new breakingChiper(_caesarChiper.getEncryptedData(),"http");
			_breakingChiper.doBruteAttack();
			
	 }
}
