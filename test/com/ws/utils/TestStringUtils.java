/**
 * 
 */
package com.ws.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Chetan
 *
 */
public class TestStringUtils {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.ws.utils.StringUtils#removeExtraWords(java.lang.String)}.
	 */
	@Test
	public void testRemoveExtraWords() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ws.utils.StringUtils#getExtraWordsFromCSV()}.
	 */
	@Test
	public void testGetExtraWordsFromCSV() {
		System.out.println("Size of Set : " + StringUtils.getExtraWordsFromCSV().size());
		System.out.println("Extra words : " + StringUtils.getExtraWordsFromCSV().toString());
	}

	/**
	 * Test method for {@link com.ws.utils.StringUtils#prepareSearchStmt(java.util.List)}.
	 */
	@Test
	public void testPrepareSearchStmt() {
		fail("Not yet implemented");
	}

}
