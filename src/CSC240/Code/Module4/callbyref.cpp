#include <stdio.h>	

void foo(int m, int &n) {   // m and n are formal parameters
   printf("m = %d, n = %d\n", m, n);
   m = 3; n = 4;	   // Modify m and n.
   printf("m = %d, n = %d\n", m, n);
}

int main() {
   int i = 1, j = 2;	// j is a local variable 
   
   printf("i = %d  j = %d\n", i, j);
   foo(i, j); 	
   printf("i = %d  j = %d\n", i, j);

   return 0;
} 

