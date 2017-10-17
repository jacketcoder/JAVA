package caesarChiper;

import java.security.PrivateKey;
import java.security.PublicKey;

import interfaceUsed.encryptDecrypt;

public class caesarChiper implements encryptDecrypt {
	message _message;
	encryptionAlgo _encryptionAlgo;
	decryptionAlgo _decryptionAlgo;
	int shiftBit,upperBoundary,lowerBoundary;
	String  encryptMessage,messageToReceive;
	public caesarChiper(){
		shiftBit='l';
		upperBoundary=(int)'z';
		lowerBoundary=(int)'a';
		_message=new message();
		_encryptionAlgo=new encryptionAlgo();
		_decryptionAlgo=new decryptionAlgo();
	
		
	}
	public void startEncryption() {
		_encryptionAlgo.encryptMessage(_message.getMessageToSend(),
				_message.getDirection(), _message.getShiftBit());
	}
	public void startDecryption() {
		_decryptionAlgo.decryptMessage(_encryptionAlgo.getEncryptMessage(),
				_message.getDirection(), _message.getShiftBit());
		}
	@Override
	public String getEncryptedData() {
		return _encryptionAlgo.getEncryptMessage();
	}
	@Override
	public String getDecryptedData() {
		// TODO Auto-generated method stub
		return _decryptionAlgo.getDecryptedMessage();
	}
	@Override
	public void startEncryption(String key, String messageToEncrypt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startEncryption(PublicKey key, String messageToEncrypt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startDecryption(PrivateKey key, String messageToDecrypt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startDecryption(String key, String chiperText) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setMessage(String message) {
		  _message.setMessage(message);
		// TODO Auto-generated method stub
		
	}
}