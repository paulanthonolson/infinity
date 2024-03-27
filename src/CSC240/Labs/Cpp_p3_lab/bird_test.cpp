#include <iostream>
#include "bird.h"

using namespace std;

int main() {
   bird eagle(10000.00, 5.5, "Eagle", 70, "black/white");

   cout << "Species      : " << eagle.getSpecies()     << endl;
   cout << "Lifespan     : " << eagle.getAvgLifespan() << " years" << endl;
   cout << "Max. altitude: " << eagle.getMaxAltitude() << " feet" << endl;
   cout << "Max. duration: " << eagle.getMaxDuration() << " hours" << endl;
   cout << "Color        : " << eagle.getColor()       << endl;
}
