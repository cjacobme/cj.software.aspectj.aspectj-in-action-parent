package ch02.ch03;

public class Main
{
	public static void main(String[] args)
	{
		MessageCommunicator messageCommunicator = new MessageCommunicator();
		messageCommunicator.deliver("Wanna learn AspectJ?");
		messageCommunicator.deliver("Harry", "having fun?");
		// following line gets a compiler warning:
		// new Authenticator().authenticate();
	}
}
