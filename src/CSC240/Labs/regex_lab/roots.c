#include <stdio.h>
#include <math.h>

#define FALSE 0
#define TRUE 1

int main() {
   const float EPSILON = 0.0001;
   float a, b, c; 
   float r1, r2, real, imag;
   int done = FALSE;

   printf("\n\tSolving Quadratic Equations\n\n");

   while (TRUE) {
      printf("Enter coefficient a (0.0 to stop): ");
      scanf("%f", &a);
      if (fabs(a) < EPSILON) break;
      printf("Enter coefficient b: ");
      scanf("%f", &b);
      printf("Enter coefficient c: ");
      scanf("%f", &c);
   
      float determinant = (b * b) - (4.0 * a * c); 
   
      if(determinant > 0.0) {    // Two real roots
         r1 = (-b + sqrt(determinant)) / (2.0 *a);
         r2 = (-b - sqrt(determinant)) / (2.0 *a);
         printf("\nThere are two real roots: %.4f and %.4f\n\n", r1, r2);
      } else if(fabs(determinant) <= EPSILON) {  // One real root
         r1 = -b/(2.0 * a);
         printf("\nThere is one real root: %.4f\n\n", r1);
      } else { // Two imaginary roots
         real = -b / (2.0 * a);
         imag = sqrt(-determinant) / (2.0 * a);
         printf("\nRoots are two imaginary roots: %.4f +/- %.4fi\n\n", real, imag);
      } 
   }

   printf("\n");
   return 0;
}
