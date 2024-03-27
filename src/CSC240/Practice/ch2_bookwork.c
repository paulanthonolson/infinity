#include <stdio.h>
void main() {
    char str[] = "hello", *p;
    int i;
    
    p = str;

    for (i = 0; str[i] != '\0'; i++) {
        str[i]++;
        printf("str: %s, p = %s\n", str, p);
    }
        
    }
