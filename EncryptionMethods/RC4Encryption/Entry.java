package RC4Encryption;
import interfaceUsed.encryptDecrypt;

public class Entry {
	 public static void main(String[] args) {
		 String data= "RC4PROGRAM";
		 String key= "A";
		 message _message=new message(data,key);
		
		 encryptDecrypt _RC4=new RC4(_message);
		_RC4.startEncryption();
		System.out.println("encrypted text"+_RC4.getEncryptedData());
		_RC4.startDecryption();
		System.out.println("decrypted text"+_RC4.getDecryptedData());
		
	 }
}
