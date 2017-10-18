package digitalEnvelop;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.json.simple.JSONObject;

import AES.AES_algorithm;
import interfaceUsed.encryptDecrypt;
import interfaceUsed.handleData;
import publicRSAEncryption.RSA;

public class Entry {
	public static void main(String[] args) {
		String dataPath="https://www.gutenberg.org/files/55693/55693-0.txt";
		String message="www.facebook.com";
		String fileName="test.txt";
		String key="asdfghjklpoiuyte";
		
		handleData dataHandler= new dataFromURL(dataPath,fileName);
		//dataHandler.fetchData();
		
		KeyPairGenerator keyPairGenerator=null;
		//KeyGenerator keyForAES=null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			// keyForAES=KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyPairGenerator.initialize(1024);
		KeyPair keyPair=keyPairGenerator.genKeyPair();
		//keyForAES.init(256); // for example
		//SecretKey secretKey = keyForAES.generateKey();
		
		
		
		digitalEnvelop dE=new digitalEnvelop(new AES_algorithm(),new RSA(),new JSONObject());
		dE.encrypt(key,keyPair.getPublic(),message);
		dE.decrypt("data.json", keyPair.getPrivate());
		
	
	
	}
}
