#include "Arduino.h"

 String inputString = "";         // String to hold incoming data
 boolean stringComplete = false;  // Whether the string is complete
 
 void setup() {
   // Initialize serial
   Serial.begin(9600);
   
   // Wait for serial port to connect
   delay(1000);
   
   // Clear the serial monitor
   Serial.println("\n\n\n");
   Serial.println("====== SERIAL INPUT TEST ======");
   Serial.println("Type something and press ENTER");
   Serial.println("It will be echoed back to you");
   Serial.println("==============================");
 }
 
 void loop() {
   // Check for any available serial data
   while (Serial.available() > 0) {
     // Get the new byte
     char inChar = (char)Serial.read();
     
     // Echo each character as it's typed (optional)
     Serial.print(inChar);
     
     // If the incoming character is a newline, set a flag
     // so the main loop can process the string
     if (inChar == '\n' || inChar == '\r') {
       stringComplete = true;
     } else {
       // Add it to the inputString
       inputString += inChar;
     }
   }
   
   // Process the string when a newline arrives
   if (stringComplete) {
     Serial.print("\nYou entered: '");
     Serial.print(inputString);
     Serial.println("'");
     Serial.println("------------------");
     Serial.println("Type something else:");
     
     // Clear the string for new input
     inputString = "";
     stringComplete = false;
   }
 }