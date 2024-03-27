#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void add(char *, float, int);

struct item {
   // Add your fields here
   char name[32];
   int quantity;
   float price;
   struct item *next;
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

   for (int i = 0; i < 5; i++) {
      printf("%20s: %3d x %6.2f = %7.2f\n", head->name, head->quantity, head->price, head->quantity * head->price);
      head = head->next;
   }

   return 0;
}

void add(char *name, float cost, int quantity) {
   
   struct item *new_item = malloc(sizeof(struct item));
   strcpy(new_item->name, name);
   new_item->quantity = quantity;
   new_item->price = cost;
   new_item->next = head;
   head = new_item;

  
}
