#include "Arduino.h"

// Pins
const int ledPin = 13;
const int buttonPin = 2;

// Program state
int state = 0;  // 0=Starting, 1=Waiting for input, 2=Transmitting

// Button state
int buttonState = HIGH;      // Current state of the button
int lastButtonState = HIGH;  // Previous state of the button
unsigned long lastDebounceTime = 0; // Timestamp of last button press
unsigned long debounceDelay = 50; // Period to wait before accepting valid button press

// Message
String message = "";
bool messageComplete = false;

// Morse code timing (milliseconds)
const int dotDuration = 200;
const int dashDuration = dotDuration * 3;
const int elementSpace = dotDuration;
const int letterSpace = dotDuration * 3;
const int wordSpace = dotDuration * 7;

// forward function declarations

void handleButtonPress();
void checkSerialInput();
void transmitMorse();

// Morse code definitions
const char* morse[] = {
  ".-",     // A
  "-...",   // B
  "-.-.",   // C
  "-..",    // D
  ".",      // E
  "..-.",   // F
  "--.",    // G
  "....",   // H
  "..",     // I
  ".---",   // J
  "-.-",    // K
  ".-..",   // L
  "--",     // M
  "-.",     // N
  "---",    // O
  ".--.",   // P
  "--.-",   // Q
  ".-.",    // R
  "...",    // S
  "-",      // T
  "..-",    // U
  "...-",   // V
  ".--",    // W
  "-..-",   // X
  "-.--",   // Y
  "--.."    // Z
};

void setup() {
  // Set up pins
  pinMode(ledPin, OUTPUT);
  pinMode(buttonPin, INPUT_PULLUP);
  
  // Set up serial
  Serial.begin(9600);
  
  // Wait for serial to initialize
  delay(1000);
  
  // Print startup message
  Serial.println("\n\n=== Morse Code Transmitter ===");
  Serial.println("Press the button to start");
}

void loop() {
  // Read the button
  int reading = digitalRead(buttonPin);
  
  // Check for button state change with debounce
  if (reading != lastButtonState) {
    lastDebounceTime = millis();
  }
  
  // If debounce time has passed, check for a real button press
  if ((millis() - lastDebounceTime) > debounceDelay) {
    // If the reading is different from current button state
    if (reading != buttonState) {
      buttonState = reading;
      
      // Button was pressed (LOW with pull-up resistor)
      if (buttonState == LOW) {
        handleButtonPress();
      }
    }
  }
  
  // Save the reading for next time
  lastButtonState = reading;
  
  // Check for serial input when waiting for it
  if (state == 1) {
    checkSerialInput();
  }
  
  // If in transmitting state, send the Morse code
  if (state == 2) {
    transmitMorse();
  }
}

// Handle button press
void handleButtonPress() {
  // Blink LED to acknowledge
  digitalWrite(ledPin, HIGH);
  delay(100);
  digitalWrite(ledPin, LOW);
  
  Serial.println("\n>>> BUTTON PRESSED <<<");
  
  // If transmitting, stop and ask for new input
  if (state == 2) {
    state = 1;
    Serial.println("Transmission stopped");
    Serial.println("Enter a new message:");
    message = "";
    messageComplete = false;
  }
  // If starting or waiting for input, prompt for input
  else {
    state = 1;
    Serial.println("Please enter your message and press Enter:");
    Serial.print("Input: "); // Add input prompt
    message = "";
    messageComplete = false;
  }
}

// Check for and process serial input
void checkSerialInput() {
  // Read input when available
  while (Serial.available() > 0) {
    // Flash LED briefly to show activity
    digitalWrite(ledPin, HIGH);
    delay(5);
    digitalWrite(ledPin, LOW);
    
    // Get new character
    char inChar = (char)Serial.read();
    
    // If it's a newline or carriage return
    if (inChar == '\n' || inChar == '\r') {
      if (message.length() > 0) {
        // Message is complete
        messageComplete = true;
      }
    } else {
      // Add character to the message
      message += inChar;
      
      // Echo the character back to the Serial Monitor
      Serial.print(inChar); // Echo character as it's typed
    }
    
    // Small delay to let buffer fill
    delay(2);
  }
  
  // If message is complete, start transmission
  if (messageComplete) {
    Serial.print("\nComplete message received: \"");
    Serial.print(message);
    Serial.println("\"");
    Serial.println("Beginning Morse code transmission...");
    Serial.println("Press button again to stop and enter new message");
    
    // Change state to transmitting
    state = 2;
    messageComplete = false;
  }
}

// Transmit the message in Morse code
void transmitMorse() {
  Serial.println("\nTransmitting message:");
  
  // Process each character
  for (unsigned int i = 0; i < message.length(); i++) {
    // Convert to lowercase
    char c = tolower(message.charAt(i));
    
    // Handle space
    if (c == ' ') {
      Serial.println("<space>");
      delay(wordSpace);
      continue;
    }
    
    // Only process letters a-z
    if (c >= 'a' && c <= 'z') {
      int index = c - 'a';
      
      // Print the letter and its code
      Serial.print(c);
      Serial.print(": ");
      Serial.println(morse[index]);
      
      // Send the morse code
      const char* code = morse[index];
      for (int j = 0; code[j] != '\0'; j++) {
        // Check if button has been pressed
        if (digitalRead(buttonPin) == LOW) {
          delay(50);  // Small debounce
          if (digitalRead(buttonPin) == LOW) {
            return;  // Exit if button is pressed
          }
        }
        
        // Send dot or dash
        if (code[j] == '.') {
          digitalWrite(ledPin, HIGH);
          delay(dotDuration);
          digitalWrite(ledPin, LOW);
        } else if (code[j] == '-') {
          digitalWrite(ledPin, HIGH);
          delay(dashDuration);
          digitalWrite(ledPin, LOW);
        }
        
        // Space between elements
        if (code[j+1] != '\0') {
          delay(elementSpace);
        }
      }
      
      // Space between letters
      delay(letterSpace);
    }
  }
  
  // End of message
  Serial.println("\nMessage complete, repeating...");
  delay(wordSpace * 2);
}