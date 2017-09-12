package caesarChiper;

public class caesarChiper {
	message _message;
	encryptionAlgo _encryptionAlgo;
	decryptionAlgo _decryptionAlgo;
	int shiftBit,upperBoundary,lowerBoundary;
	String  encryptMessage,messageToReceive;
	caesarChiper(String sendingMessage,int shiftingBit,char dirn){
		shiftBit=shiftingBit;
		upperBoundary=(int)'z';
		lowerBoundary=(int)'a';
		_message=new message(sendingMessage,shiftingBit,dirn);
		_encryptionAlgo=new encryptionAlgo();
		_decryptionAlgo=new decryptionAlgo();
		
	}
	public String  getEncryptMessage(){
	return _encryptionAlgo.getEncryptMessage();
	}
	public String getDecryptedMessage() {
		return _decryptionAlgo.getDecryptedMessage();
	}
	public void startEncryption() {
		_encryptionAlgo.encryptMessage(_message.getMessageToSend(),
				_message.getDirection(), _message.getShiftBit());
	}
	public void startDecryption() {
		_decryptionAlgo.decryptMessage(_encryptionAlgo.getEncryptMessage(),
				_message.getDirection(), _message.getShiftBit());
		}
}