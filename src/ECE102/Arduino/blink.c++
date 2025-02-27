#include "Arduino.h"

/*
 * Hello World with Morse Code Blink
 * 
 * This program prints "hello world" to the serial monitor and
 * blinks the same message in Morse code using the built-in LED.
 * 
 * For Arduino Uno, the built-in LED is on pin 13.
 */

// Define pin for the built-in LED
const int ledPin = 13;

// Timing parameters for Morse code (in milliseconds)
const int dotDuration = 200;
const int dashDuration = dotDuration * 3;
const int elementSpace = dotDuration;
const int letterSpace = dotDuration * 3;
const int wordSpace = dotDuration * 7;

// Morse code definitions (A-Z)
const char* morseCode[] = {
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

// Function prototypes (forward declarations)
void blinkMorseMessage(String message);
void blinkLetter(char letter);
void blinkDot();
void blinkDash();

void setup() {
  // Initialize the digital pin as an output
  pinMode(ledPin, OUTPUT);
  
  // Initialize serial communication at 9600 bits per second
  Serial.begin(115200);
  
  }

void loop() {

  // Print "hello world" to the serial monitor
  Serial.println("hello world");

  // Blink "hello world" in Morse code
  blinkMorseMessage("hello world");
  
  // Pause between message repetitions
  delay(wordSpace * 2);
}

// Function to blink a message in Morse code
void blinkMorseMessage(String message) {
  // Convert message to lowercase
  message.toLowerCase();
  
  // Iterate through each character in the message
  for (unsigned int i = 0; i < message.length(); i++) {
    char c = message.charAt(i);
    
    // Handle space between words
    if (c == ' ') {
      delay(wordSpace);
    }
    // Handle letters (a-z)
    else if (c >= 'a' && c <= 'z') {
      blinkLetter(c);
      // Only add letter space if not the last character or if the next isn't a space
      if (i < message.length() - 1 && message.charAt(i + 1) != ' ') {
        delay(letterSpace);
      }
    }
    // Other characters (numbers, punctuation) are skipped
  }
}

// Function to blink a single letter in Morse code
void blinkLetter(char letter) {
  // Get Morse code for the letter
  int index = letter - 'a';
  
  // Check if the letter is in range (a-z)
  if (index >= 0 && index < 26) {
    const char* morse = morseCode[index];
    
    // Blink the Morse code pattern
    for (int i = 0; morse[i] != '\0'; i++) {
      if (morse[i] == '.') {
        blinkDot();
      } else if (morse[i] == '-') {
        blinkDash();
      }
      delay(elementSpace);
    }
  }
  // If character is not a-z, we just skip it
}

// Function to blink a dot
void blinkDot() {
  digitalWrite(ledPin, HIGH);
  delay(dotDuration);
  digitalWrite(ledPin, LOW);
}

// Function to blink a dash
void blinkDash() {
  digitalWrite(ledPin, HIGH);
  delay(dashDuration);
  digitalWrite(ledPin, LOW);
}