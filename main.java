//import caesarChiper.caesarChiper;
class main {
    public static void main(String[] args) {
		String message="azi";
        System.out.println("Starting caesarChiper");
		System.out.println("Sending message"+" "+message);
		caesarChiper _caesarChiper=new caesarChiper(3,'l');
		_caesarChiper.setMessageToSend(message);
		_caesarChiper.encryptMessage();
		String encryptedMessage=_caesarChiper.getEncryptMessage();
		System.out.println(encryptedMessage);
    }
}