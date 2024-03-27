#include <stdio.h>

typedef enum { Sat, Sun, Mon, Tue, Wed, Thu, Fri } day; 

int main() {
   day  x = Mon, y = Fri;

   while (x <= y) {
      printf("Another great day at school! (%d)\n", x);
      x++;
   }

   for (x = Sat; x <= Sun; x++) {
      printf("Another sad day binge-watching Netflix (%d)\n", x);
   }
}
