#include <iostream>
#include <string>
#include "flyer.h"

using namespace std;

class bird : public flyer, virtual public animal {
    private:
        string color;
    public:
        bird(float ceiling, float duration, string species, int lifespan, string tint) : flyer(ceiling, duration), animal(species, lifespan) {
            this->color = tint;
        }
        string getColor() {
            return color;
        }
};

