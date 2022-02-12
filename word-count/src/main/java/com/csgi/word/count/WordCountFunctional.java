package com.csgi.word.count;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordCountFunctional 
{
	private final Logger log = LoggerFactory.getLogger(WordCountFunctional.class);
	
	public Map<Integer, List<String>> countWords(List<String> stringList, String character, int length)
	{
		Map<Integer, List<String>> map = null;
		
		if(stringList.size() < 1 && character == null) 
			log.error("Either character or word list must not be empty/null.");
		
		List<String> wordList = stringList.stream() 
				.filter(a -> a.startsWith(character) && a.length() > length)
				.collect(Collectors.toList());
		
		Integer count = (int) stringList.stream()
				.filter(c -> c.startsWith(character))
				.count();
		
		map = new HashMap<Integer, List<String>>();
		map.put(count, wordList);
		
		return map;
	}
}