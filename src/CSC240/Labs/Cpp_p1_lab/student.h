#include <cstring>

class Student {
    private:
    char name[64];
    long ID;
    int totalPoints;
    int totalCredits;
    static long nextID;
    public:
    Student(const char *n){
        strcpy(name, n);
        ID = nextID++;
        totalPoints = 0;
        totalCredits = 0;
    }
    char *getName(){
        return name;
    }
    long getID(){
        return ID;
    }
    void addClass(int c, int grade);
    float calcGPA(void);
};
