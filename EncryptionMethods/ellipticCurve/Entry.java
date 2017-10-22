package ellipticCurve;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;

import interfaceUsed.decrypt;
import interfaceUsed.encrypt;

public class Entry {

	public static void main(String[] args) {
		  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// TODO Auto-generated method stub
		KeyPair keyPair=null;
		String message="hellow";
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("EC","BC");
			keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
			keyPair=keyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(message);
		
		encrypt eEC=new EllipticCurve();
		eEC.startEncryption(keyPair.getPublic(), message);
		System.out.println("encrypted message "+eEC.getEncryptedData());
		decrypt dEC=new EllipticCurve();
		dEC.startDecryption(keyPair.getPrivate(), eEC.getEncryptedData());
		System.out.println("decrypted message "+dEC.getDecryptedData());
		
		

	}

}
