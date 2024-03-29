#include <iostream>

using namespace std;

class Car {
    
    private:
    string name;
    long odometer;

    public:
    Car(string n){
        odometer = 0L;
        name = n;
        cout << "Constructed the car: " << name << endl;
    }

    ~Car(){
        cout << "Destructed the car: " << name << " with " << odometer << " miles." << endl;
    
    }

    string getName(){
        return name;
    }

    long getOdometer(){
        return odometer;
    }

    void addTrip(int mileage){
        odometer += mileage;
    }
    
};