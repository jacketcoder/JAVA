package caesarChiper;
public class encryptionAlgo {
	String encryptMessage;
	int upperBoundary,lowerBoundary;
	encryptionAlgo(){
		upperBoundary=(int)'z';
		lowerBoundary=(int)'a';
	}
	public void encryptMessage(String message,char dirn,int shiftBit){
		char []encryptedMessageHolder=new char[message.length()];
		if(dirn=='l'){
			for (int index=0;index<message.length();index++){
				int initialAscii=(int)message.charAt(index);
				int finalAscii=initialAscii-shiftBit;
				char encodedLetter=(char)checkLimit(finalAscii);
				encryptedMessageHolder[index]=encodedLetter;
			}
		}
		else{
			for (int index=0;index<message.length();index++){
				int initialAscii=(int)message.charAt(index);
				int finalAscii=initialAscii+shiftBit;
				char encodedLetter=(char)checkLimit(finalAscii);
				encryptedMessageHolder[index]=encodedLetter;
			}
			
		}
		encryptMessage=new String(encryptedMessageHolder);
	}
	public int checkLimit(int asciiValue){
		if(asciiValue>upperBoundary){//has value greater that z
			int greaterTerm=asciiValue-upperBoundary;
			greaterTerm--;
			int modifiedAscii=lowerBoundary+greaterTerm;
			return modifiedAscii;
		}
		else if(asciiValue<lowerBoundary){
			int lowerTerm=lowerBoundary-asciiValue;
			lowerTerm--;
			int modifiedAscii=upperBoundary-lowerTerm;
			return modifiedAscii;
			
		}
		else{
			return asciiValue;
		}
		
	}
	public String getEncryptMessage() {
		return encryptMessage;
	}
}
