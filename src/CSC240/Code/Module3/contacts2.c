#include <stdio.h>   
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

struct node {
	struct contact *element;
	struct node *next;
};

struct contact {
	char	name[30];
	int	phone;
	char	email[30];
};

struct node *front = NULL;
int count = 0;

void branching(char c);
int insertion();
void search();
void delete();
void printall();

void main() {
	char ch = 'i';

	while (ch != 'q') {
		printf("Enter your selection\n");
		printf("	i: insert a new entry\n");
		printf("	d: delete an entry\n");
		printf("	s: search an entry\n");
		printf("	p: print all entries\n");
		printf("	q: quit \n");

		scanf(" %c",&ch);
		branching(ch);
	}
}

void branching(char c) {    // branch to different tasks
	switch(c)  {
		case 'i': insertion(); break;
		case 's': search();    break;
		case 'd': delete();    break;
		case 'p': printall();  break;
		case 'q': break;
		default : printf("Invalid input %d\n", c); break;
	}
}

int insertion() {    // insert a new entry at the front
	struct contact *c = (struct contact *) malloc(sizeof(struct contact));

	printf("Enter name, phone, email:\n");
	scanf("%s", c->name);
	scanf("%d", &(c->phone));
	scanf("%s", c->email);

	struct node *n = (struct node *) malloc(sizeof(struct node));

	n->element = c;
	n->next = front;
	front = n;

	count++;

	printf("The number of entries = %d\n", count);

	return 0;
}

void search() {    // print phone and email via name
	char sname[30]; 
	int  i;
	struct node *retval;

	printf("please enter the name to be searched for:\n");
	scanf("%s", sname); 	//sname is an array, no &

	struct node *n;

	for (n = front, retval = NULL; n != NULL; retval = n, n = n->next) {
		if (strcmp(sname, n->element->name) == 0) {
			printf("phone = %d\n", n->element->phone);
			printf("email = %s\n", n->element->email);
		}
	}

	printf("The name does not exist.\n");
}

void delete() {  
	struct node *prev;
	struct node *n;
	int found = 0;

	char sname[30]; 
	int  i;

	printf("Enter the name to be searched for:\n");
	scanf("%s", sname); 	//sname is an array, no &

	for (n = front, prev = NULL; n != NULL; prev = n, n = n->next) {
		if (strcmp(sname, n->element->name) == 0) {
			found = 1;
			printf("phone = %d\n", n->element->phone);
			printf("email = %s\n", n->element->email);
			break;
		}
	}

	if (!found) {
		printf("The name does not exist.\n");
	}
	else {
		if (prev == NULL)
			front = front->next;
		else
			prev->next = prev->next->next;
		count--;
	}
}

void printall() {
	struct node *n;
	int i;

	for (n = front, i = 1; n != NULL; n = n->next, i++) {
		printf("%2d) Name : %s\n", i, n->element->name);
		printf("    Phone: %d\n", n->element->phone);
		printf("    Email: %s\n", n->element->email);
	}
}
