package caesarChiper;

import static org.junit.Assert.*;

import org.junit.Test;

public class testingCaesarChiper {
	String messageToEncode="sagar";
	int shiftingBit=2;
	char shiftingDirn='l';
	String encodedMessage="qyeyp";
	caesarChiper _caesarChiperTest=new caesarChiper(messageToEncode,shiftingBit,shiftingDirn);
	
	@Test
	public void test() {
		_caesarChiperTest.startEncryption();
		assertEquals(encodedMessage,_caesarChiperTest.getEncryptMessage());
		_caesarChiperTest.startDecryption();
		assertEquals(messageToEncode,_caesarChiperTest.getDecryptedMessage());
	}
}
