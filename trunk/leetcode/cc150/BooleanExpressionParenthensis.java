/**
 * Given a boolen expression, and a result,
 * find ways to count the number of ways of
 * parenthesizing it.
 * 
 * e.g., 1^0|0|1  result = 0
 * 
 * two ways: 1^((0|0)|1)  and 1^(0|(0|1)) 
 * */

public class BooleanExpressionParenthensis {

	/**
	 * 
	 * cast it as a dynamic programminig problem:
	 * 
	 * f(expr, true)  ==  ways to add parenthesis
	 * 
	 * expr can only be a few possiblities
	 * 
	 * expr = expr || expr
	 *      = expr & expr
	 *      = expr ^ expr
	 *      
	 * then, e.g.,
	 * 
	 * f(expr1 || expr1, true) =  f(expr1, true) * f(expr2, true)
	 *                         =  f(expr1, false) * f(expr2, true)
	 *                         =  f(expr1, true) * f(expr2, false)
	 * */
	
}