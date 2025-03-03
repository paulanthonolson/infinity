#include "Arduino.h"

 const int buttonPin = 2;  // Button pin
 const int ledPin = 13;    // LED pin
 
 // Simple state machine
 enum State {
   STATE_1,  // LED off
   STATE_2,  // LED blinking slowly
   STATE_3   // LED blinking quickly
 };
 
 State currentState = STATE_1;
 
 // Button variables
 int lastButtonState = HIGH;  // Last button reading
 int buttonState = HIGH;      // Current debounced button state
 unsigned long lastDebounceTime = 0;
 unsigned long debounceDelay = 50;  // Debounce time in milliseconds
 
 // Blink timing
 unsigned long lastBlinkTime = 0;
 int ledState = LOW;
 
 void setup() {
   pinMode(buttonPin, INPUT_PULLUP);
   pinMode(ledPin, OUTPUT);
   digitalWrite(ledPin, LOW);  // Start with LED off
   
   Serial.begin(9600);
   delay(1000);  // Give serial time to initialize
   
   Serial.println("\n\n=== Button State Test ===");
   Serial.println("Current state: STATE_1 (LED off)");
   Serial.println("Press the button to change states");
 }
 
 void loop() {
   // Read the button
   int reading = digitalRead(buttonPin);
   
   // Print the raw reading every second for debugging
   static unsigned long lastPrintTime = 0;
   if (millis() - lastPrintTime > 1000) {
     Serial.print("Button reading: ");
     Serial.println(reading == HIGH ? "HIGH" : "LOW");
     lastPrintTime = millis();
   }
   
   // Check if the button reading has changed
   if (reading != lastButtonState) {
     // Reset the debounce timer
     lastDebounceTime = millis();
   }
   
   // Check if button state is stable
   if ((millis() - lastDebounceTime) > debounceDelay) {
     // If the reading has changed
     if (reading != buttonState) {
       buttonState = reading;
       
       // If the button is pressed (LOW with pull-up resistor)
       if (buttonState == LOW) {
         // Button press detected, change state
         Serial.println("\n!!! BUTTON PRESS DETECTED !!!");
         
         // Cycle to next state
         switch (currentState) {
           case STATE_1:
             currentState = STATE_2;
             Serial.println("Changed to STATE_2 (slow blink)");
             break;
             
           case STATE_2:
             currentState = STATE_3;
             Serial.println("Changed to STATE_3 (fast blink)");
             break;
             
           case STATE_3:
             currentState = STATE_1;
             Serial.println("Changed to STATE_1 (LED off)");
             digitalWrite(ledPin, LOW);  // Turn off LED immediately
             break;
         }
       }
     }
   }
   
   // Store the button reading for next loop
   lastButtonState = reading;
   
   // Handle LED based on current state
   switch (currentState) {
     case STATE_1:
       // LED off
       digitalWrite(ledPin, LOW);
       break;
       
     case STATE_2:
       // Slow blink (500ms)
       if (millis() - lastBlinkTime > 500) {
         lastBlinkTime = millis();
         ledState = (ledState == LOW) ? HIGH : LOW;
         digitalWrite(ledPin, ledState);
       }
       break;
       
     case STATE_3:
       // Fast blink (100ms)
       if (millis() - lastBlinkTime > 100) {
         lastBlinkTime = millis();
         ledState = (ledState == LOW) ? HIGH : LOW;
         digitalWrite(ledPin, ledState);
       }
       break;
   }
 }