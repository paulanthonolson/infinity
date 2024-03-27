#include <string.h>

void main() {
   struct contact {
      char name[30];
      int phone;
      char email[30];
   };

   struct contact c;

   strcpy(c.name, "Prof. Eckert");
   c.phone = 5551212;
   strcpy(c.email, "profeckert@emcc.edu");
}
