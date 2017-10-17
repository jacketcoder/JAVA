package digitalEnvelop;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import AES.AES_algorithm;
import interfaceUsed.encryptDecrypt;
import interfaceUsed.handleData;

public class Entry {
	public static void main(String[] args) {
		String dataPath="https://www.gutenberg.org/files/55693/55693-0.txt";
		String message="www.facebook.com";
		String fileName="test.txt";
		String key="asdfghjklpoiuyte";
		handleData dataHandler= new dataFromURL(dataPath,fileName);
		KeyPairGenerator keyPairGenerator=null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataHandler.fetchData();
		keyPairGenerator.initialize(1024);
		KeyPair keyPair=keyPairGenerator.genKeyPair();
		digitalEnvelop dE=new digitalEnvelop();
		dE.encrypt(key,keyPair.getPublic(),dataHandler.getData());
		dE.decrypt("data.json", keyPair.getPrivate());
		
	
	
	}
}
