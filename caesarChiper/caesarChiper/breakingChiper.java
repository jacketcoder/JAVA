package caesarChiper;
public class breakingChiper {
	decryptionAlgo _decryptionAlgo;
	String encryptedMessage;
	int maxKey;
	int assumedShiftingBit;
	String assumedMessageStarting;
	breakingChiper(String message,String assumeMessage){
		 assumedShiftingBit = 0;
		 maxKey=25;
		 encryptedMessage=message;
		 assumedMessageStarting=assumeMessage;
		 _decryptionAlgo=new decryptionAlgo();
	}
	void doBruteAttack() {
		for (int shiftingBit=assumedShiftingBit;shiftingBit<=maxKey;shiftingBit++) {
			_decryptionAlgo.decryptMessage(encryptedMessage, 'l', shiftingBit);
			//System.out.println("decryptedMessage is  "+_decryptionAlgo.getDecryptedMessage());
			 if(_decryptionAlgo.getDecryptedMessage().contains(assumedMessageStarting)) {
				 System.out.println("decryptedMessage is matched message is  "+_decryptionAlgo.getDecryptedMessage());
				break;	 
			 }
		}
	}

}
