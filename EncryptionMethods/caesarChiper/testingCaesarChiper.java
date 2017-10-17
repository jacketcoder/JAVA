package caesarChiper;

import static org.junit.Assert.*;

import org.junit.Test;

import interfaceUsed.encryptDecrypt;

public class testingCaesarChiper {
	String messageToEncode="sagar";
	int shiftingBit=2;
	char shiftingDirn='l';
	String encodedMessage="qyeyp";
	encryptDecrypt _caesarChiperTest=new caesarChiper();
	
	@Test
	public void test() {
		_caesarChiperTest.setMessage(messageToEncode);
		_caesarChiperTest.startEncryption();
		assertEquals(encodedMessage,_caesarChiperTest.getEncryptedData());
		_caesarChiperTest.startDecryption();
		assertEquals(messageToEncode,_caesarChiperTest.getDecryptedData());
	}
}
