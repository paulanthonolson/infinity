#include <iostream>

using namespace std;

class Thing {
   private:
      string name;

   public:
      Thing() : Thing("unnamed") { };
      Thing(string n) { 
         name = n;
         cout << "Thing \"" << name << "\" created" << endl;
      }
      ~Thing() { 
         cout << "Thing \"" << name << "\" destroyed" << endl;
      }
};

Thing sg("static global variable");

int main() {
   cout << "Starting main()" << endl;

   static Thing sl("static local variable");
   Thing al("automatic local variable");
   Thing aa[5];

   Thing *h;

   for (int i = 0; i < 3; i++) {
      h = new Thing("heap " + to_string(i));
   }

   delete h;

   cout << "Leaving main()" << endl;

   return 0;
}

