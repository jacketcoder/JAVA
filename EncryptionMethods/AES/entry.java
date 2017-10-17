package AES;
import AES.AES_algorithm;
import digitalEnvelop.dataFromURL;
import interfaceUsed.decrypt;
import interfaceUsed.encrypt;
import interfaceUsed.encryptDecrypt;
import interfaceUsed.handleData;

public class entry {
	
	public static void main(String[] args) {
		String message="httpfacebookcom";
		String dataPath="https://www.gutenberg.org/files/55693/55693-0.txt";
		String fileName="test.txt";
		String key="asdfghjklpoiuyte";
		//handleData dataHandler= new dataFromURL(dataPath,fileName);
		//dataHandler.fetchData();
	    System.out.println("Starting AES_algorithm");
		System.out.println("Sending message"+" "+message);
		encrypt e=new AES_algorithm();
		e.startEncryption(key, message);
		System.out.println("encryptedMessage is  "+ e.getEncryptedData());
		decrypt d=new AES_algorithm();
		d.startDecryption(key, e.getEncryptedData());
		System.out.println("decryptedMessage is  "+ d.getDecryptedData());
		
		
}
}
