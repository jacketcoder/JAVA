package digitalsignature;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;

import digitalEnvelop.dataFromURL;
import interfaceUsed.handleData;

public class Entry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// TODO Auto-generated method stub
		KeyPair keyPair=null;
		String dataPath="https://www.gutenberg.org/files/55693/55693-0.txt";
		String fileName="test.txt";
		String message="hellow",CURVE="secp256r1";
		ECDSA ecdsa=new ECDSA();
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("EC","BC");
			keyPairGenerator.initialize(new ECGenParameterSpec(CURVE));
			keyPair=keyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handleData dataHandler= new dataFromURL(dataPath,fileName);
		dataHandler.fetchData();
		ecdsa.signatureGeneration(keyPair.getPrivate(), dataHandler.getData());
		if(ecdsa.signatureVerification(keyPair.getPublic(), dataHandler.getData(), ecdsa.getSignature())) {
			System.out.println("authenticated message "+dataHandler.getData());
		}
		else {
			System.out.println("message has been altered");
		}
	}

}
