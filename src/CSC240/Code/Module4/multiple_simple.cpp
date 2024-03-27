#include <iostream>

using namespace std;

class A {
public:
  int x;
  A()  { cout << "A's constructor called" << endl; }
};
 
class B {
public:
  float y;
  B()  { cout << "B's constructor called" << endl; }
};
 
class C: public B, public A {
public:
  bool z;
  C()  { cout << "C's constructor called" << endl; }
};
 
int main() {
    C c;
    c.x = 1; c.y = 2.0; c.z = true;
    return 0;
}
