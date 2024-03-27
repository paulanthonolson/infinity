#include <stdio.h>
#include <ctype.h>
int main(int argc, char *argv[])
{

    int currentChar, isNewWord = 1;

    const char *phonetic[26] = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu"};

    FILE *inputFile = fopen(argv[1], "r");

    if (inputFile == NULL)
    {
        printf("Error opening file");
        return 1;
    }

    while ((currentChar = fgetc(inputFile)))
    {
        if (isalpha(currentChar))
        {
            if (isNewWord)
            {
                isNewWord = 0;
            }
            printf("%s ", phonetic[tolower(currentChar) - 'a']);
        }
        else
        {
            printf("%c", currentChar);
            if (!isNewWord)
            {
                printf("\n");
                isNewWord = 1;
            }
        }
    }

    return 0;
}