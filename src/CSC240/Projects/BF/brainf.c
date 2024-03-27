
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    
    if (argc < 2) {
        printf("Usage: <brainfuck filename> %s \n", argv[0]);
        return 1;
    }

    char *filename = argv[1];
    
    FILE *inputFile = fopen(filename, "r");
    if (inputFile == NULL) {
        printf("Error opening file\n");
        return 1;
    }

    char codeArray[1000];
    int codeRead = fread(codeArray, 1, sizeof(codeArray) - 1, inputFile);
    fclose(inputFile);
    codeArray[codeRead] = '\0';

 
int bfArray[100] = {0};
int *dataPointer = bfArray;
int loopLevel = 0;
char *programPointer = codeArray;
char *loopStartPositions[1000];

printf("Paul Olson\nBrainf Interpreter\n");


while((*programPointer) != '\0') {
       
        switch (*programPointer) {
            case '>':
                // Move the data pointer to the next data element. There is no largest element.
                dataPointer++;
                break;
            case '<':
                // Move the Data Pointer to the previous data element. Print an error and stop execution if the Data Pointer goes negative.
                
                if(dataPointer == bfArray){
                    printf("Error: Data Pointer is negative\n");
                    return 1;
                }
                dataPointer--;
                break;
            case '+':
                // Increment the current data element
                (*dataPointer)++;
                break;
            case '-':
                // Decrement the current data element. Data elements can go negative.
                (*dataPointer)--;
                break;
            case ':':
                // Print the current data element.
                printf("%d\t", *dataPointer);
                break;
            case ';':
                // Set the value of the current data element to an integer value supplied by the user. Prompt the user with a ?
                printf("?");
                scanf("%d", dataPointer);
                break;
            case '[':
                // If the integer at the current data pointer is zero, move the Code Pointer to the right to the matching ]. Otherwise, do nothing. Print an error and stop execution if there is no matching brace
                 if (*dataPointer == 0) {
                    
                    int brackets = 1;
                    while (brackets != 0) {
                        programPointer++;
                        if (*programPointer == '[') brackets++;
                        else if (*programPointer == ']') brackets--;
                    }
                } else {
                 
                    loopStartPositions[loopLevel++] = programPointer;
                }
                break;
            case ']':
                // Move the Code Pointer left to the matching [. Print an error and stop execution if there is no matching brace
                  if (*dataPointer != 0) {
                    
                    programPointer = loopStartPositions[loopLevel - 1];
                } else {
                    
                    loopLevel--;
                }
                break;
            case ' ': 
            case '\t': 
            case '\n': 
            case '\r': 
            case '\f':
            case '\v':
                break;

            default:
                // Ignore any other characters
                printf("Warning: Ignored unexpected character '%c'.\n", *programPointer);
                break;
        }
        programPointer++;
    }
     
     return 0;
}

    




	
    
    
   

