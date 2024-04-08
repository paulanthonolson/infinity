#include <iostream>
#include <string>
#include "animal.h"

using namespace std;

class flyer : virtual public animal {
    private:
                float max_altitude;
                float max_duration;
          public:
                flyer(int max_alt, int max_dur) : animal("", 0) {
                    this->max_altitude = max_alt;
                    this->max_duration = max_dur;
                }
                float getMaxAltitude() {
                    return max_altitude;
                }
                float getMaxDuration() {
                    return max_duration;
                }
};

