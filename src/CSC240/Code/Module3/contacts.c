#include <stdio.h>   
#include <string.h>
#include <ctype.h>

#define MAX 100

struct contact {
   char	name[30];
   int	phone;
   char	email[30];
};

struct contact contactbook[MAX];  // an array of structures with MAX entries
int tail = 0;

void branching(char c);
int insertion();
int search();
int delete();
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

int insertion() {    // insert a new entry at the end
	if (tail == MAX) {
		printf("There are no more places to insert.\n");
		return -1; 
	}
	else {
		printf("Enter name, phone, email:\n");
		scanf("%s", contactbook[tail].name);
		scanf("%d", &contactbook[tail].phone);
		scanf("%s", contactbook[tail].email);
		tail++;
		printf("The number of entries = %d\n", tail);
		return 0;
	}
}

int search() {    // print phone and email via name
	char sname[30]; 
	int  i;

	printf("Enter the name to be searched for:\n");
	scanf("%s", sname); 	//sname is an array, no &

	for (i=0; i<tail; i++) {
		if (strcmp(sname, contactbook[i].name)== 0) {
			printf("phone = %d\n", contactbook[i].phone);
			printf("email = %s\n", contactbook[i].email);
			return i;
		}
	}

	printf("The name does not exist.\n");
	return -1;
}

int delete() {  
	int i, k;

	k = search();

	if (k != -1) {
		for (i=k; i<tail; i++) {
			strcpy(contactbook[i].name, contactbook[i+1].name);
			contactbook[i].phone = contactbook[i+1].phone;
			strcpy(contactbook[i].email, contactbook[i+1].email);
		}
	 	printf("The index deleted is: %d\n", k);
		tail--;
		return k;
	}
}

void printall() {
	int i;

	for (i=0; i < tail; i++) {
		printf("%2d) Name : %s\n", i+1, contactbook[i].name);
		printf("    Phone: %d\n", contactbook[i].phone);
		printf("    Email: %s\n", contactbook[i].email);
	}
}
