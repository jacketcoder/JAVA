package RC4Encryption;
import interfaceUsed.encryptDecrypt;
public class RC4 implements encryptDecrypt {
	message _message;
	KSA _KSA;
	PRGA _PRGA;
	public RC4(){
		 String key= "A";
		  _message=new message(key);
		  
	}
	public  void startEncryption() {
		_KSA=new KSA(_message.getKeyChar());
		  _PRGA=new PRGA(_message.getPlainMessage().length());
		_KSA.scrambleStateVector();
		_PRGA.generateStream(_KSA.getStateSize(),_KSA.getStateVector());
		_PRGA.encryptText(_message.getCharPlainMessage());
	}
	public void startDecryption() {
		_PRGA.decryptText();
	}
	public char[] convertIntToText(int[]data) {
		char []dataStore=new char[data.length];
		for(int index=0;index<data.length;index++) {
			dataStore[index]=(char)data[index];
		}
		return dataStore;
	}
	public String getEncryptedData() {
		return new String(convertIntToText(_PRGA.getChiperText()));
	}
	public String getDecryptedData() {
		return new String(convertIntToText(_PRGA.getDecryptText()));
		
	}
	@Override
	public void enterMessage(String messageToEncrypt) {
		_message.setMessage(messageToEncrypt);
		// TODO Auto-generated method stub
		
	}
}
