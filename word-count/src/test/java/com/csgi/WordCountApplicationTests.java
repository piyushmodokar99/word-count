package com.csgi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.csgi.word.count.WordCount;
import com.csgi.word.count.WordCountFunctional;

@SpringBootTest(classes = {WordCount.class, WordCountFunctional.class})
class WordCountApplicationTests {

	//@Test
	void contextLoads() {
	}
	
	static WordCount wordCount = null;
	static WordCountFunctional wordCountFunctional = null;
	static List<String> list = null;
	final int WORD_LONGER_THAN = 5;
	
	@BeforeAll
	public static void createObj()
	{
		wordCount = new WordCount();
		wordCountFunctional = new WordCountFunctional();
		list = Arrays.asList("Pune","Akola","Mumbai","Delhi","Morshi","Piyush","Faizan","Michael","mumbai","man", "", "melbourne");
	}
	
	@Test
	void testWordCountStartsWithCharM()
	{
		String character = "M";
		Map<Integer, List<String>> expected = new HashMap<Integer, List<String>>();
		expected.put(3, Arrays.asList("Mumbai", "Morshi", "Michael"));
		
		assertEquals(expected, wordCount.countWords(list, character, WORD_LONGER_THAN));
	}
	
	@Test
	void testWordCountStartsWithCharm()
	{
		String character = "m";
		Map<Integer, List<String>> expected = new HashMap<Integer, List<String>>();
		expected.put(3, Arrays.asList("mumbai", "melbourne"));
		
		assertEquals(expected, wordCount.countWords(list, character, WORD_LONGER_THAN));
	}
	
	@Test
	void testWordCountFunctionalStartsWithCharm()
	{
		String character = "m";
		Map<Integer, List<String>> expected = new HashMap<Integer, List<String>>();
		expected.put(3, Arrays.asList("mumbai", "melbourne"));
		
		assertEquals(expected, wordCountFunctional.countWords(list, character, WORD_LONGER_THAN));
	}
}