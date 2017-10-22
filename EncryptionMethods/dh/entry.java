package dh;
import AES.AES_algorithm;
import interfaceUsed.decrypt;
import interfaceUsed.encrypt;
	public class entry { 
	  public static void main(String[] args) throws Exception {
		encrypt eAES=new AES_algorithm();
		String message="hellow";
		DiffieHellman DH=new DiffieHellman();
		DH.generateKeyPair();
		DH.doDHAgreement(DH.getKeyGenA(),DH.getKeyGenB());
		DH.encryptMessage(DH.getaKeyAgree(),eAES ,message);
		System.out.println("encrypted message "+eAES.getEncryptedData());
		decrypt dAES=new AES_algorithm();
		DH.decryptMessage(DH.getbKeyAgree(), dAES, eAES.getEncryptedData());
		System.out.println("decrypted message "+dAES.getDecryptedData());
		
		
	  }
	}


