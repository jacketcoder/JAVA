package dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.DHParameterSpec;

import interfaceUsed.decrypt;
import interfaceUsed.encrypt;

public class DiffieHellman {
	  private static BigInteger g512 = new BigInteger("1234567890");
	  private static BigInteger p512 = new BigInteger("1234598760");
	  private static Integer l512 = 12;
	  
	  DHParameterSpec dhParams ;
	  KeyAgreement aKeyAgree,bKeyAgree;
	  KeyPairGenerator keyGenA, keyGenB;
	  public KeyPairGenerator getKeyGenA() {
		return keyGenA;
	}
	public KeyPairGenerator getKeyGenB() {
		return keyGenB;
	}
	public KeyAgreement getaKeyAgree() {
		return aKeyAgree;
	}
	public KeyAgreement getbKeyAgree() {
		return bKeyAgree;
	}

	  public DiffieHellman() {
		  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		   dhParams = new DHParameterSpec(p512, g512,l512);
	  }
	  void generateKeyPair() {
		try {
			keyGenA = KeyPairGenerator.getInstance("DH", "BC");
			keyGenA.initialize(dhParams, new SecureRandom());
			  keyGenB = KeyPairGenerator.getInstance("DH", "BC");
			    keyGenB.initialize(dhParams, new SecureRandom());
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		  
	  }
	  void doDHAgreement(KeyPairGenerator A,KeyPairGenerator B) {
		try {
			aKeyAgree = KeyAgreement.getInstance("DH", "BC");
			  bKeyAgree = KeyAgreement.getInstance("DH", "BC");
			 KeyPair aPair = A.generateKeyPair();
			   
			    KeyPair bPair = B.generateKeyPair();

			    aKeyAgree.init(aPair.getPrivate());
			    bKeyAgree.init(bPair.getPrivate());

			    aKeyAgree.doPhase(bPair.getPublic(), true);
			    bKeyAgree.doPhase(aPair.getPublic(), true);
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	  }
	  void encryptMessage(KeyAgreement keyAgreement,encrypt eAES,String messageToEncode) {
		  
		  MessageDigest hash;
		try {
			hash = MessageDigest.getInstance("SHA1", "BC");
			byte[] key=hash.digest(keyAgreement.generateSecret());
			//System.out.println(new String(hash.digest(keyAgreement.generateSecret())));
			eAES.startEncryption(Arrays.copyOf(key, 16),messageToEncode);
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		  
	  }
 void decryptMessage(KeyAgreement keyAgreement,decrypt dAES,String cipherText) {
		  MessageDigest hash;
		try {
			hash = MessageDigest.getInstance("SHA1", "BC");
			byte[] key=hash.digest(keyAgreement.generateSecret());
			dAES.startDecryption(Arrays.copyOf(key, 16),cipherText);
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  
	  
}
