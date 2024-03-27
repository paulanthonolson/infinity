#include "student.h"

long Student::nextID = 1;

void Student::addClass(int c, int grade){
    totalPoints += c * grade;
    totalCredits += c;
}

float Student::calcGPA(void){
    return (float)totalPoints / totalCredits;
}