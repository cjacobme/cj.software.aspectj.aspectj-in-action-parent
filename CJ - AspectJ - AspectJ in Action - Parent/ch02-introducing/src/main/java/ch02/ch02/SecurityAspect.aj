package ch02.ch02;


public aspect SecurityAspect
{
	private Authenticator authenticator = new Authenticator();
	
	pointcut secureAccess()
		: execution( * MessageCommunicator.deliver(..));
	
	before() : secureAccess()
	{
		System.out.println("checking ant authenticating user...");
		authenticator.authenticate();
	}
	
	declare warning
		: call (void Authenticator.authenticate())
			&& !within(SecurityAspect)
		: "Authentication should be performed only by Security Acpect";
}
