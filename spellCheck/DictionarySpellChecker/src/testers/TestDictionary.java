package testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import newsom.Dictionary;

class TestDictionary {
	
	private Dictionary testDictionary;

	@Test
	void test() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	void bstAdd() {
		// ARRANGE
		testDictionary = new Dictionary();
		
		// ACT
		testDictionary.insertWordNode("apple");
		testDictionary.insertWordNode("banana");
		testDictionary.insertWordNode("acorn");
		
		// ASSERT
		assertEquals("apple", testDictionary.root.key, "Root should be 'apple'");
		assertEquals("banana", testDictionary.root.right.key, "Right child of root should be 'banana'");
		assertEquals("acorn", testDictionary.root.left.key, "Left child of root should be 'acorn'");
	}
	
	@Test
	void bstInOrd() {
		// ARRANGE
		testDictionary = new Dictionary();
		
		// ACT
		testDictionary.insertWordNode("apple");
		testDictionary.insertWordNode("banana");
		testDictionary.insertWordNode("acorn");
		testDictionary.insertWordNode("cherry");
		testDictionary.insertWordNode("cedar");
		
		// ASSERT
		String expectedInOrd = "acorn apple banana cedar cherry ";
		testDictionary.inorder();
		String actualInOrd = testDictionary.displayTxt;
		assertEquals(expectedInOrd, actualInOrd, "In-order traversal should return words in alphabetical order");
		
	}
	
	@Test
	void bstDelete() {
		// ARRANGE
		testDictionary = new Dictionary();
		
		// ACT
		testDictionary.insertWordNode("apple");
		testDictionary.insertWordNode("banana");
		testDictionary.insertWordNode("acorn");
		testDictionary.insertWordNode("cherry");
		testDictionary.insertWordNode("cedar");
		testDictionary.checkWord("apple");
		
		// ASSERT
		assertEquals("banana", testDictionary.root.key, "Root should be 'banana' after deleting 'apple'");
		assertEquals("acorn", testDictionary.root.left.key, "Left child of root should be 'acorn'");
		String expectedInOrdAftDel = "acorn banana cedar cherry ";
		testDictionary.inorder();
		String actualInOrdAftDel = testDictionary.displayTxt;
		assertEquals(expectedInOrdAftDel, actualInOrdAftDel, "In-order traversal should return words in alphabetical order.");
	}

}
