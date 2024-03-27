#include <iostream>

using namespace std;

class A {
public:
  A()  { cout << "A's constructor called" << endl; }
};

class B: public A {
public:
  float y;
  B()  { cout << "B's constructor called" << endl; }
};

class C: public A {
public:
  bool z;
  C()  { cout << "C's constructor called" << endl; }
};

class D: public B, public C {
public:
  long l;
  D()  { cout << "D's constructor called" << endl; }
};

int main() {
    D d;
    d.y = 2.0; d.z = true; d.l = 1L;
    return 0;
}
