#include <iostream>
#include "car.h"

using namespace std;

Car car1("Global Model 3");

int main(){

    static Car car2("Local Static Model Y");
    Car car3("Local Automatic Model X");
    Car *car4 = new Car("Heap Model S");

    car1.addTrip(112348);
    car1.addTrip(24563);
    car2.addTrip(3354633);
    car3.addTrip(998363);
    car4->addTrip(34652);

    delete car4;
};