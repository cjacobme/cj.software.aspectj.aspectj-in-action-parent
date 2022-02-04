package cj.software.aspectj.own.assertj;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class SimpleTest
{
	@Test
	public void thisWillFail()
	{
		int number = 1;
		assertThat(number).as("number").isEqualTo(2);
		// all classes in package org.assertj.core
		// and from these all methods which have names that start with "assert"
	}
}
