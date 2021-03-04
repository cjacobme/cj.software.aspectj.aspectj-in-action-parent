package ch02.ch02;

import java.time.OffsetDateTime;

public aspect TrackingAspect
{
	declare parents: MessageCommunicator implements AccessTracked;

	private OffsetDateTime AccessTracked.lastAccessTime;
	
	public void AccessTracked.updateLastAccessedTime()
	{
		lastAccessTime = OffsetDateTime.now();
		System.out.println("accessed " + lastAccessTime);
	}
	
	public OffsetDateTime AccessTracked.getLastAccessTime()
	{
		return lastAccessTime;
	}

	private static interface AccessTracked 
	{
	}

	before(AccessTracked accessTracked) 
		: execution(* AccessTracked+.* (..))
		&& !execution(*  AccessTracked.*(..))
		&& this(accessTracked)
	{
		accessTracked.updateLastAccessedTime();
	}
}
