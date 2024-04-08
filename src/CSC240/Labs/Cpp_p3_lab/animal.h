#include <iostream>
#include <string>
using namespace std;

class animal {
private:
    string species;
    int avg_lifespan;
public:
    animal(string species, int avg_lifespan) {
        this->species = species;
        this->avg_lifespan = avg_lifespan;
    }
    string getSpecies() { return species; }
    int getAvgLifespan() { return avg_lifespan; }
};