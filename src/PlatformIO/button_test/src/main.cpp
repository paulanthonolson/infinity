#include "Arduino.h"

const int buttonPin = 2;

// Variables for button state
int lastButtonState = HIGH;    // Last reading from the button
int currentButtonState = HIGH; // Current button state
unsigned long lastDebounceTime = 0;  // Last time the button state changed
unsigned long debounceDelay = 50;    // Debounce time in milliseconds
int buttonPressCount = 0;     // Counter for button presses

void setup() {
  // Initialize serial communication
  Serial.begin(9600);
  
  // Set button pin as input with pull-up resistor
  pinMode(buttonPin, INPUT_PULLUP);
  
  Serial.println("Button Test Program");
  Serial.println("Press the button to test. Each press should increment the counter.");
  Serial.println("-----------------------------");
}

void loop() {
  // Read the current state of the button (will be LOW when pressed due to pull-up)
  int reading = digitalRead(buttonPin);
  
  // Check if the button state has changed
  if (reading != lastButtonState) {
    // Reset the debounce timer
    lastDebounceTime = millis();
  }
  
  // Wait for the button state to stabilize (debouncing)
  if ((millis() - lastDebounceTime) > debounceDelay) {
    // If the button state has changed
    if (reading != currentButtonState) {
      currentButtonState = reading;
      
      // If the button was pressed (LOW with pull-up resistor)
      if (currentButtonState == LOW) {
        buttonPressCount++;
        Serial.print("Button pressed! Count: ");
        Serial.println(buttonPressCount);
        
        // Flash the built-in LED on pin 13 to give visual feedback
        digitalWrite(LED_BUILTIN, HIGH);
        delay(200);
        digitalWrite(LED_BUILTIN, LOW);
      }
    }
  }
  
  // Save the current reading for the next loop
  lastButtonState = reading;
}