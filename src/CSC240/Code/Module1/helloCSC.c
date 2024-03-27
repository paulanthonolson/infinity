#include <stdio.h>
#include <unistd.h>

#define SIZE 100

void main() {
   char name[SIZE];
   getlogin_r(name, SIZE);

   printf("%s says: \"Hello CSC240!\"\n", name);
}
