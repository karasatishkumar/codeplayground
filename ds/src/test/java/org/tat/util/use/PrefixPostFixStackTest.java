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
		
		String output = pPFS.inFixToPostFix("A+B*C");
		Assert.assertEquals("ABC*+", output);
		output = pPFS.inFixToPostFix("3*(2+5)");
		Assert.assertEquals("325+*", output);
		output = pPFS.inFixToPostFix("[[{{A*(B+C)}-D}+E]*F]");
		Assert.assertEquals("ABC+*D–E+F*", output);
		output = pPFS.inFixToPostFix("((((1*(2+3))-3)+4)*5)");
		Assert.assertEquals("123+*3–4+5*", output);
	}

}
