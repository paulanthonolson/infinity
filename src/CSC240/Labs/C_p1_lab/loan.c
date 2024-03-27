#include <stdio.h>
int main() {
	int Month;
	float Start;
	float Interest;
	float Pay;
	float Close;

printf("Enter the Starting-amount: ");
scanf("%f", &Start);
printf("%7.2f\n", Start);

printf("Enter the Payment-amount: ");
scanf("%f", &Pay);
printf("%6.2f\n", Pay);

printf("Enter the Annual-interest (1 - 100): ");
scanf("%f", &Interest);
printf("%5.2f\n", Interest);

float Balance = Start;

Interest = Start * ((Interest / 100) / 12);

float End_Balance = Balance + Interest - Pay;
Month = 1;

printf("%3s,%7s,%5s,%6s %7s", "Month", "Start", "Interest", "Pay", "Close");


while (Balance > 0.0){

	Interest = Balance * ((Interest/ 100) / 12);
	End_Balance = Balance + Interest - Pay;

	
if (Balance + Interest < Pay){
	Pay = Balance + Interest;
}
Close = Balance + Interest - Pay;
printf("%03d %7.2f %5.2f %6.2f %7.2f\n", Month, Balance, Interest, Pay, Close);
Balance = Close;
Month++;

}

return 0;
}