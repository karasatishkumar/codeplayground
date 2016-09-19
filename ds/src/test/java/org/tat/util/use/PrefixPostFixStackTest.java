package org.tat.util.use;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrefixPostFixStackTest {
	
	PrefixPostFixStack pPFS = new PrefixPostFixStack();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPreFixToPostFix() {
		
		String output = pPFS.preFixToPostFix("A+B*C"); //A+(B*C) -> A+(BC*) -> A(BC*)+ -> ABC*+
		Assert.assertEquals("ABC*+", output);
	}

}
