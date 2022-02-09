package com.csgi.word.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordCount 
{
	private final Logger log = LoggerFactory.getLogger(WordCount.class);
	
	
	/**
	 * @param stringList - List of strings/words 
	 * @param character - to check word starts with given character in the list 
	 * @param length - More that this length words will get return in list 
	 * @return map - Integer - Count of words who starts with given character
	 * 			   - List<String> - List of words having length more than given @Param length.
	 * @author Piyush   
	 */
	public Map<Integer, List<String>> countWords(List<String> stringList, String character, int length)
	{
		Map<Integer, List<String>> map = null;
		Integer count = 0;
		List<String> list = null;
		
		if(stringList.size() < 1 && character == null) 
			log.error("Either character or strings list must not be empty/null.");
		
		list = new ArrayList<String>();
		
		for (int i = 0; i < stringList.size(); i++) 
		{
			String word = stringList.get(i);
			//For checking string start with given character and increment count
			if(word != null && word.startsWith(character)) 
			{
				count++;
				//Add word to list having length more than 5
				if(word.length() > length) list.add(word);
			}
		} 
		map = new HashMap<Integer, List<String>>();
		map.put(count, list);
		
		//Map will return count of Words starts with given character in Integer as Key 
		//and list of words whose length is more than 5
		return map;
	}
}
