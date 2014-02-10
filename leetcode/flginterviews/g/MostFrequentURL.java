package g;

/**
 * https://sites.google.com/site/countminsketch/
 * 
 * 0. the most frequent urls in the past minute, hour, day
 * 
 * http://stackoverflow.com/questions/3260653/algorithm-to-find-top-10-search-terms
 * 
 * 1. most frequent urls all the time
 * 
 * 2. most frequent in the last month
 * */

/***
 * 
 *  0. most frequent urls in the past second, min, and hour
 *  
 * 
 *  1. most frequent urls all the time
 *     if exact is needed, the solution would be pretty slow, otherwise, approximation
 *     - use count-min to keep track of all counts
 *     - use a priority queue is keep track of the most frequent k elements
 *     
 *     https://github.com/cs186-fa12/fa12/blob/master/hw5/README.md
 *  
 *  another similar way:
 *  
 *  
       - Look at each item in the stream.
       - If the term exists in the map, increment the associated counter.
       - Otherwise, if the map has fewer candidates than you're looking for,
         add it to the map with a count of one.
       - However, if the map is "full", decrement the counter in each entry.
       If any counter reaches zero during this process, remove it from the map.
       
        (
        if you limit the map to 99 entries, you are guaranteed to find
        any term that occurs more than 1/(1 + 99) (1%) of the time
        ) //this is the special case
 *  
 * 
 *  2. most frequent in the last month 
 *  assign each word to an integer, since integer comparison is much faster than string.
 *     words: 4 millions, ip address ~ 255*255*255*255 == 500 million
 *     all URL links: 1 billion, but the integer's range is over 4 billion
 *     
 *     The system will absorbs incoming sentences until memory becomes fully
 *     utilized (Ya, we need a MemoryManager). After taking N sentences and
 *     storing in memory, the system pauses, and starts tokenize each sentence
 *     into words and phrases. Each token (word or phrase) is counted.

       For highly frequent tokens, they are always kept in memory. For less
       frequent tokens, they are sorted based on IDs (remember we translate
       the String into an array of integers), and serialized into a disk file.
       
       put all word-frequency map in memory only
       
       At end of day, the system will have many frequent tokens with frequency
       stored in memory, and many other less frequent tokens stored in several
       disk files (and each file is sorted).

       The system flush the in-memory map into a disk file (sort it). Now, the
       problem becomes merging a set of sorted disk file. Using similar process, we would get one sorted disk file at the end.
 * 
 * */

public class MostFrequentURL {

	/**
	 * Use multiple hash function to keep track of the count number, and
	 * get the minimal values
	 * 
	 * To obtain the count of an element, we take the minimum of the k fields that correspond to that element (as given by the hashes). This makes intuitive sense. Out of the k values, probably some have been incremented on other elements also (if there were collisions on the hash values).
	 * 
	 * */
	
}
