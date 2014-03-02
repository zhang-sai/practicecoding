package basics;

/**
 * what is little/big endian, how to tell if one machine is little or big 
endian machine?
 * */
public class BigSmallEndian {

	/**
	 * Little and big endian are two ways of storing multibyte data-types
	 * ( int, float, etc). In little endian machines, last byte of binary
	 * representation of the multibyte data-type is stored first. On the other hand,
	 * in big endian machines, first byte of binary representation of the multibyte
	 * data-type is stored first.
	 * 
	 * Suppose integer is stored as 4 bytes (For those who are using DOS based compilers such
	 * as C++ 3.0 , integer is 2 bytes) then a variable x with value 0×01234567
	 * will be stored as following.
	 * 
	 * Big endian:   ---low stack-  12 34 56 78 --- high stack--
	 * little endian:   ---low stack--  78 56 34  12 --- high stack-- 
	 * */
	
	/**
	 * #include <stdio.h>
int main() 
{
   unsigned int i = 1;
   char *c = (char*)&i;
   if (*c)    
       printf("Little endian");
   else
       printf("Big endian");
   getchar();
   return 0;
}

In the above program, a character pointer c is pointing to an integer i.
Since size of character is 1 byte when the character pointer is de-referenced
it will contain only first byte of integer. If machine is little endian then *c
will be 1 (because last byte is stored first) and if machine is big endian then *c will be 0.
	 * 
	 * */
}
