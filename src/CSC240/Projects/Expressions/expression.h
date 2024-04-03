#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

class expression {
    private:
        
        
    public:
    
    int value = 0;
    expression *expr1 = 0;
    expression *expr2 = 0;
    char op = 0;
    char expr_string[100];
    
    virtual int eval() = 0;

    virtual char* infix() = 0;

    virtual char* postfix() = 0;

    
};

class constant : public expression {
    
    public:
    
    constant (int i){
        
        value = i;
      
        }

    int eval(){
        
        return value;
    }

    char* infix(){
     
        sprintf(expr_string, "%d", value);
        return expr_string;
    }

    char* postfix(){
         sprintf(expr_string, "%d", value);
        return expr_string;
    }
};

class unop : public expression {
    private:
        expression *expr1 = 0;
        char op = 0;
    public:

  
    
    unop(char op, expression *e){
        this -> op = op;
        expr1 = e;

    }

    int eval() {
        value = expr1 -> eval();
    try{
        switch (op){
            case '+' :
                return value;

            case '-' :
                return -value;
            default: throw "invalid urnary operator"
              ;
        }
        
    } catch (const char* error){
        cout << "Error: " << error <<endl;
    }
    return 0;
    }
    

    char* infix(){
        
         sprintf(expr_string, "(%c %s)", op, expr1 -> infix());
        return expr_string;
    }

    char* postfix(){
       
       sprintf(expr_string, "%s ~", expr1->postfix());
       return expr_string;
    }
};

class binop : public expression {
    private:
        char op = 0;
        expression *expr1 = 0;
        expression *expr2 = 0;
        int value2 = 0;
        
    public:

   binop(char op, expression* e1, expression* e2){
        this -> op = op;
        expr1 = e1;
        expr2 = e2;

    }
    
    int eval(){
    try{
        value = expr1 -> eval();
        value2 = expr2 -> eval();
    
        switch (op){
            case '+' :
                return value + value2;
            case '-' :
                return value - value2;
            case '*' :
                return value * value2;
            case '/' : 
                if (value2 == 0){
                printf ("Division by 0 is not allowed.");
                } else
                return value / value2;
            default:
               ;
        }
        
    }catch (const char* error){
        cout << "Error " << error << endl;
    }
    return 0;
    }

    char* infix(){
         sprintf(expr_string, "(%s %c %s)", expr1 -> infix(), op, expr2 -> infix());
         return expr_string;
    }

    char* postfix(){
        sprintf(expr_string, "%s %s %c", expr1 -> postfix(), expr2 -> postfix(), op);
        return expr_string;
    }

};