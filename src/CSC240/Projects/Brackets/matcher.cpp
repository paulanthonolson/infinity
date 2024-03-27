#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
    int brackets = 0;
    cin >> brackets;
    string discard;
    getline(cin, discard);
    

    cout << "Matching Brackets: Paul Olson" << endl;

    for (int i = 0; i < brackets; i++) {
        
        string input;
        getline(cin, input);

        stack<char> matcher;
        

        bool isValid = true;
        for (char character : input) {
            if (character == '(' || character == '[' || character == '{' || character == '<') {
                matcher.push(character);
                
            } else if (character == ')' || character == ']' || character == '}' || character == '>') {
                
                if (matcher.empty()) {
                    isValid = false;
                    
                    break;
                    
                }
                

                 
                char top = matcher.top();
                
               
                if ((character == ')' && top == '(') ||
                    (character == ']' && top == '[') ||
                    (character == '}' && top == '{') ||
                    (character == '>' && top == '<')) {
                        
                    matcher.pop();
                    
                    
                     
                } else {
                    isValid = false;
                    break;
                    
                }
                
            }
            
        }
        


        if (isValid && matcher.empty()) {
            
            cout << '1' << ' ';
        } else {
            cout << '0' << ' ';
        }
            
    }
    
    cout << endl;

    return 0;
}
