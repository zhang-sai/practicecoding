package g;

//http://www.mitbbs.com/article_t/JobHunting/32613555.html
/**
 * 1. Use an array 2^32 to keep track of every integers == roughly 8G memory
 * 
 * 2. use two heaps:
 *    This is not different from the median in stream problem.  Just use 2 heaps, 
one min, the other max.  When k = 50, the two heals are of the same size.  
In more general cases, adjust the heap size accordingly.
*
*  3. use balance tree, and adjust its value to be balanced
 * */
public class TopKPercentNumber {

}