#include <iostream>
#include "expression.h"

using namespace std;

int main(int argc, char *argv[]) {
	
	// Simple constant expression for Suggested Step #3
	/*expression 8expression *e = new unop('-', new constant(-5));
	cout << "Evaluate: " << e-> eval() << endl;
	cout << "Infix: " << e-> infix() << endl;
	cout << "Postfix: " << e-> postfix() << endl;
	return 0;*/
	
	// Simple unop expression for Suggested Step #6
	// expression *e = new unop('-', new constant(3));

	//Complete binop expression for Suggested Step #9
	expression *e = new binop('*',
			new unop('-', new constant(3)),
			new binop('+',
				new constant(4),
				new binop('/',
					new constant(9),
					new constant(3)
				)
			)
		);
	cout << "Expressions: Paul Olson" << endl;
	cout << endl;
	cout << "Evaluate: " << e->eval() << endl;
	cout << "Infix: " << e->infix() << endl;
	cout << "Postfix: " << e->postfix() << endl;
	
	return 0;
}

