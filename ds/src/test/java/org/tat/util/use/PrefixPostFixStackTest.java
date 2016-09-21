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

		String output = pPFS.inFixToPostFix("A + B * C", " ");
		Assert.assertEquals("A B C * +", output);
		output = pPFS.inFixToPostFix("3 * ( 2 + 5 )", " ");
		Assert.assertEquals("3 2 5 + *", output);
		output = pPFS.inFixToPostFix("[ [ { { A * ( B + C ) } - D } + E ] * F ]", " ");
		Assert.assertEquals("A B C + * D - E + F *", output);
		output = pPFS.inFixToPostFix("( ( ( ( 1 * ( 2 + 3 ) ) + 3 ) + 4 ) * 5 )", " ");
		Assert.assertEquals("1 2 3 + * 3 + 4 + 5 *", output);
		output = pPFS.inFixToPostFix("A2 + B1 * C3", " ");
		Assert.assertEquals("A2 B1 C3 * +", output);
	}
	
	@Test
	public void testInFixToPreFix() {

		String output = pPFS.inFixToPreFix("A + ( B * C )", " ");
		Assert.assertEquals("+ A * B C", output);
	}
	
	@Test
	public void testEvalPostFix() {

		String output = pPFS.evalPostFix("1 2 3 * +", " ");
		Assert.assertEquals("7", output);
		
		output = pPFS.evalPostFix("1 2 3 + * 3 + 4 + 5 *", " ");
		Assert.assertEquals("60", output);
		
		output = pPFS.evalPostFix(pPFS.inFixToPostFix("( ( ( ( 1 * ( 2 + 3 ) ) + 3 ) - 4 ) * 5 )", " "), " ");
		Assert.assertEquals("20", output);
	}
	
	@Test
	public void testEvalPreFix() {

		String output = pPFS.evalPreFix(pPFS.inFixToPreFix("1 + ( 2 * 3 )", " "), " ");
		Assert.assertEquals("7", output);
	}

}
