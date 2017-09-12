package RC4Encryption;

import static org.junit.Assert.*;

import org.junit.Test;

import interfaceUsed.encryptDecrypt;

public class testingRC4 {
	 String data= "RC4PROGRAM";
	 String key= "A";
	 message _message=new message(data,key);
	 encryptDecrypt _RC4=new RC4(_message);
	@Test
	public void test() {
		_RC4.startEncryption();
		//assertEquals(encodedMessage,_RC4.getEncryptedData());
		_RC4.startDecryption();
		assertEquals(data,_RC4.getDecryptedData());
	}

}
