//http://www.ardendertat.com/2012/01/02/programming-interview-questions-24-find-next-higher-number-with-same-digits/
public class NextLargeNumberWithTheSameDigits {

	//idea: scan from right to left, and stop at the first place that a[i] < a[i+1]
	//  then find the smallest number on the right of j > i, that a[j] > a[i]
	//  swap a[i]  and a[j], and sort all digits on the right of j
	//e.g.,  1 5 6 4 3  => first  find 5,  then  swap 5 with 3
	//   1 3 6 4 5 ==>  1 3 4 5 6
	
}
