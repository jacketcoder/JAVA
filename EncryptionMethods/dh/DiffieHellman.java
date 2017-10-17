package dh;
	import java.math.BigInteger;
	import java.security.KeyPair;
	import java.security.KeyPairGenerator;
	import java.security.MessageDigest;
	import java.security.SecureRandom;
	import java.security.Security;

	import javax.crypto.KeyAgreement;
	import javax.crypto.spec.DHParameterSpec;
	public class DiffieHellman {
	  private static BigInteger g512 = new BigInteger("1234567890");

	  private static BigInteger p512 = new BigInteger("1234598760");

	  private static Integer l512 = 12;
	  
	  public static void main(String[] args) throws Exception {
	    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

	    DHParameterSpec dhParams = new DHParameterSpec(p512, g512,l512);
	    
	    KeyPairGenerator keyGenA = KeyPairGenerator.getInstance("DH", "BC");
	    keyGenA.initialize(dhParams, new SecureRandom());
	    
	    KeyPairGenerator keyGenB = KeyPairGenerator.getInstance("DH", "BC");
	    keyGenB.initialize(dhParams, new SecureRandom());
	    
	    KeyAgreement aKeyAgree = KeyAgreement.getInstance("DH", "BC");
	    KeyPair aPair = keyGenA.generateKeyPair();
	    KeyAgreement bKeyAgree = KeyAgreement.getInstance("DH", "BC");
	    KeyPair bPair = keyGenB.generateKeyPair();

	    aKeyAgree.init(aPair.getPrivate());
	    bKeyAgree.init(bPair.getPrivate());

	    aKeyAgree.doPhase(bPair.getPublic(), true);
	    bKeyAgree.doPhase(aPair.getPublic(), true);

	    MessageDigest hash = MessageDigest.getInstance("SHA1", "BC");
	    System.out.println(new String(hash.digest(aKeyAgree.generateSecret())));
	    System.out.println(new String(hash.digest(bKeyAgree.generateSecret())));
	  }
	}


