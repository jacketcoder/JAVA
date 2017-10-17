package managedAES;

import interfaceUsed.decrypt;
import interfaceUsed.encrypt;

public class Entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String secretKey = "ssshhhhhhhhhhh!!!!";
		final String secretKey1 = "ssshhhhhhhhhyh!!!!";
		AES aes=new AES();
		encrypt e=new AES();
		decrypt d=new AES();
		System.out.println(aes.encrypt("ramas", secretKey1));
		System.out.println(aes.decrypt(aes.encrypt("ramas", secretKey1), secretKey1));
		
		System.out.println(e.startEncryption("rama", secretKey));
	
		System.out.println(d.startDecryption(e.startEncryption("ram", secretKey), secretKey));
	}

}
