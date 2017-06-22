/*
  Software serial multple serial test

 Receives from the hardware serial, sends to software serial.
 Receives from software serial, sends to hardware serial.

 The circuit:
 * RX is digital pin 10 (connect to TX of other device)
 * TX is digital pin 11 (connect to RX of other device)

 Note:
 Not all pins on the Mega and Mega 2560 support change interrupts,
 so only the following can be used for RX:
 10, 11, 12, 13, 50, 51, 52, 53, 62, 63, 64, 65, 66, 67, 68, 69

 Not all pins on the Leonardo and Micro support change interrupts,
 so only the following can be used for RX:
 8, 9, 10, 11, 14 (MISO), 15 (SCK), 16 (MOSI).

 created back in the mists of time
 modified 25 May 2012
 by Tom Igoe
 based on Mikal Hart's example

 This example code is in the public domain.

 */
#include <SoftwareSerial.h>

#define LED 12

SoftwareSerial mySerial(10, 11); // RX, TX

void setup() {
  pinMode(LED, OUTPUT);
  // Open serial communications and wait for port to open:
  Serial.begin(57600);
  mySerial.begin(9600);
  while (!Serial) {
    ; // wait for serial port to connect. Needed for native USB port only
  }
  Serial.write("pd");
  mySerial.write("pute");

  Serial.println(Serial.read());

  // set the data rate for the SoftwareSerial port
  
  mySerial.println(mySerial.read());
}

void loop() { // run over and over
  if (mySerial.available()) {
    Serial.write("rainy");
    Serial.println("bonjour");
    digitalWrite(LED, HIGH);
    
    
  }

  //send to computer
  if (Serial.available()) {
    digitalWrite(LED, LOW);
    Serial.println("0");
    mySerial.write("hello");
  }
}

