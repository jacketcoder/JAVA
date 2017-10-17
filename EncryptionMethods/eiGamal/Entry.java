package eiGamal;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;

public class Entry {

	public static void main(String[] args) {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// TODO Auto-generated method stub
		
		KeyPairGenerator generator=null;
		try {
			generator = KeyPairGenerator.getInstance("ElGamal","BC");
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SecureRandom random = new SecureRandom();
		generator.initialize(256, random); // keep it at least 160 bit
		KeyPair keyPair = generator.genKeyPair();
		// Public key
		PublicKey pubKey = keyPair.getPublic();
		// Private key
		PrivateKey privateKey = keyPair.getPrivate();
		EIGamal eiGamal=new EIGamal();
		eiGamal.startEncryption(pubKey, "www.facebook.com");
		System.out.println(eiGamal.getEncryptedData());
		eiGamal.startDecryption(privateKey, eiGamal.getEncryptedData());
		System.out.println(eiGamal.getDecryptedData());
		
		

	}

}
