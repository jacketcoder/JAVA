class caesarChiper{
	int shiftBit,upperBoundary,lowerBoundary;
	char shiftingDirection;
	enum shiftDirn {LEFT,RIGHT,NONE};
	shiftDirn _shiftDirn=shiftDirn.NONE;
	String messageToSend;
	String encryptMessage;
	String messageToReceive;
	caesarChiper(int shiftingBit,char dirn){
		shiftBit=shiftingBit;
		shiftingDirection=dirn;
		upperBoundary=(int)'z';
		lowerBoundary=(int)'a';
		setshiftDirn();
	}
	caesarChiper(int shiftingBit){
		shiftBit=shiftingBit;
		shiftingDirection='l';
		setshiftDirn();
	}
	void setshiftDirn(){
		if(shiftingDirection=='l'||shiftingDirection=='L'){
			 _shiftDirn=shiftDirn.LEFT;
		}
		else if (shiftingDirection=='r'||shiftingDirection=='r'){
			 _shiftDirn=shiftDirn.RIGHT;
		}
		else{
			System.out.println("Shifting in left direction as specified direction is ambigous");
			 _shiftDirn=shiftDirn.LEFT;
		}
	} 
	public void  setMessageToSend(String message){
	messageToSend=message;
	}
	public String  getMessageToSend(){
	return messageToSend;
	}
	public String  getEncryptMessage(){
	return encryptMessage;
	}
	public void encryptMessage(){
		char []encryptedMessageHolder=new char[messageToSend.length()];
		if(_shiftDirn==shiftDirn.LEFT){
			for (int index=0;index<messageToSend.length();index++){
				int initialAscii=(int)messageToSend.charAt(index);
				int finalAscii=initialAscii-shiftBit;
				char encodedLetter=(char)checkLimit(finalAscii);
				encryptedMessageHolder[index]=encodedLetter;
			}
		}
		else{
			for (int index=0;index<messageToSend.length();index++){
				int initialAscii=(int)messageToSend.charAt(index);
				int finalAscii=initialAscii+shiftBit;
				char encodedLetter=(char)checkLimit(finalAscii);
				encryptedMessageHolder[index]=encodedLetter;
			}
			
		}
		encryptMessage=new String(encryptedMessageHolder);
	}
	public int checkLimit(int asciiValue){
		if(asciiValue>upperBoundary){//has value greater that z
			int greaterTerm=upperBoundary-asciiValue;
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
}