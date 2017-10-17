package RC4Encryption;
import interfaceUsed.encryptDecrypt;

public class Entry {
	 public static void main(String[] args) {
		 String data="sagar";
		 encryptDecrypt _RC4=new RC4();
		
		 System.out.println("message is  "+data);
		 _RC4.setMessage(data);
		_RC4.startEncryption();
		System.out.println("encrypted text"+_RC4.getEncryptedData());
		_RC4.startDecryption();
		System.out.println("decrypted text"+_RC4.getDecryptedData());
		
	 }
}
