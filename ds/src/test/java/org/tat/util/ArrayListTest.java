package org.tat.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
	
	ArrayList<String> testArray;
	int counter;

	@Before
	public void setUp() throws Exception {
		testArray = new ArrayList<String>();
		testArray = new ArrayList<String>(5);
		while(counter<100){
			testArray.add("Test" + counter++);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		Assert.assertTrue("Size is not working", testArray.size() == counter);
	}

	@Test
	public void testAddT() {
		testArray.add("string");
		Assert.assertTrue("not getting added at the right index", testArray.get(testArray.size()-1).equals("string"));
	}

	@Test
	public void testAddTInt() {
		int size = testArray.size();
		testArray.add("suchi", 3);
		Assert.assertTrue("Not getting added at the right index", testArray.get(3) == "suchi");
		Assert.assertTrue("Index did not get updated after the add", testArray.size() == size+1);
	}

	@Test
	public void testRemove() {
		int size = testArray.size();
		String s = testArray.remove(2);
		Assert.assertTrue("removed object is not the right one", s.equals("Test2"));
		Assert.assertTrue("Index did not get updated after the remove", testArray.size() == size-1);
	}
	
	@Test
	public void testRemoveBulk() {
		int size = testArray.size();
		for(int i = size - 1 ; i > 10 ; i--){
			testArray.remove(i);
		}
		
		Assert.assertTrue("removed did not work properly", testArray.size() == 11);
	}
	
	@Test
	public void testRemoveBulkRandom() {
		int size = testArray.size();
		
		for(int i = 0 ; i < 62 ; i++){
			testArray.remove(0);
		}
		Assert.assertTrue("removed did not work properly", testArray.size() == 38);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddInvalidIndex(){
		testArray.add("-1", -1);
		testArray.add("1000", 1000);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testReportInvalidIndex(){
		testArray.remove(-1);
		testArray.remove(1000);
	}

}
