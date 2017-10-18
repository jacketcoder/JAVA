package digitalEnvelop;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import AES.AES_algorithm;
import interfaceUsed.encryptDecrypt;
import interfaceUsed.handleData;
import publicRSAEncryption.RSA;

public class digitalEnvelop {
	encryptDecrypt publicRSAEncryptionAlgo;
	encryptDecrypt AESAlgo;
	JSONObject json;
	public digitalEnvelop(encryptDecrypt aes,encryptDecrypt rsa,JSONObject json) {
		AESAlgo=aes;
		publicRSAEncryptionAlgo=rsa;
		this.json=json;
	}
	void encrypt(String key,PublicKey publicKey,String message) {
		AESAlgo.startEncryption(key,message);
		publicRSAEncryptionAlgo.startEncryption(publicKey,key);
		json.put("encryptedKey",publicRSAEncryptionAlgo.getEncryptedData());
		json.put("encryptedtext", AESAlgo.getEncryptedData());
		//json.put("encryptedKey","sagar");
		//json.put("encryptedtext","bhusal");
		try {
			FileWriter fileWriter=new FileWriter("data.json");
			fileWriter.write(json.toJSONString());
			fileWriter.flush();
			System.out.println(json);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	void decrypt(String jsonFileName,PrivateKey privateKey) {
		  JSONParser parser = new JSONParser();
		   try {
			Object obj = parser.parse(new FileReader(jsonFileName));
			 JSONObject jsonObject = (JSONObject) obj;
			 
	            String encryptedKey = (String) jsonObject.get("encryptedKey");
	            String encryptedtext = (String) jsonObject.get("encryptedtext");
	           // System.out.println(encryptedKey);
	            publicRSAEncryptionAlgo.startDecryption(privateKey,publicRSAEncryptionAlgo.getEncryptedData());
	           AESAlgo.startDecryption(publicRSAEncryptionAlgo.getDecryptedData() ,encryptedtext);
	           System.out.println(AESAlgo.getDecryptedData());
	            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
