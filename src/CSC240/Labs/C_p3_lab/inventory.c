#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void add(char *, float, int);

struct item {
   // Add your fields here
};

struct item *head = NULL;

int main() {
   add("washing machine", 399.95, 17);
   add("rug", 22.50, 4);
   add("couch", 129.98, 5);
   add("blender", 39.95, 1);
   add("poetry magnet set", 4.95, 134);

   // Use a for-loop to print all of the items in the lst, and total each item (cost * quantity)
   // Use this format string: "%20s: %3d x %6.2f = %7.2f\n"

   return 0;
}

void add(char *name, float cost, int quantity) {
   // Create a new struct item
   // Fill it with the vaues passed
   // Link it to the front of the list.
}
