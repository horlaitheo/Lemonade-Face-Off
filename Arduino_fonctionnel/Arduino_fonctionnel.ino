#include <LiquidCrystal.h>

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

LiquidCrystal lcd(8, 9, 4, 5, 6, 7);

int lcd_key     = 0;
int adc_key_in  = 0;
#define btnRIGHT  0
#define btnUP     1
#define btnDOWN   2
#define btnLEFT   3
#define btnSELECT 4
#define btnNONE   5

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

uint32_t tik = 0;
uint32_t horloge = 0;
long accl = 0; //variable pour gerer l'acceleration du jeu 
uint32_t start_time =0;
int jour = 0;

struct weather_s{
  String weather;
};
weather_s tab_weather[5];

String previous_weather = "cloudy";
String current_weather = "cloudy";
int prev_rdm;

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

int read_LCD_buttons()
{
 adc_key_in = analogRead(0);      // read the value from the sensor 
 // my buttons when read are centered at these valies: 0, 144, 329, 504, 741
 // we add approx 50 to those values and check to see if we are close
 if (adc_key_in > 1000) return btnNONE; // We make this the 1st option for speed reasons since it will be the most likely result
 // For V1.1 us this threshold
 if (adc_key_in < 50)   return btnRIGHT;  
 if (adc_key_in < 250)  return btnUP; 
 if (adc_key_in < 450)  return btnDOWN; 
 if (adc_key_in < 650)  return btnLEFT; 
 if (adc_key_in < 850)  return btnSELECT;  

 return btnNONE;  // when all others fail, return this...
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------


//fonction permettant de gerer le temps en fonction de la prevision et les prévision météo
void weather_f(){
  int rdm_weather = random(1, 101);
  int rdm_prev_weather = random(0,5);
  int indice = random(0,2); //indice pour choisir si on fait + ou - quand on n'est pas dans les 88% de certitudes

  if(indice==0){
    indice = -1;
  }
  if(rdm_weather>0 && rdm_weather<88){
    current_weather = previous_weather;
  }
  if(rdm_weather>88 && rdm_weather<=98){
    current_weather = tab_weather[((prev_rdm)+(1*indice)+5)%5].weather;
  }
  if(rdm_weather>98 && rdm_weather<=100){
    current_weather = tab_weather[((prev_rdm)+(2*indice)+5)%5].weather;
  }
  previous_weather= tab_weather[rdm_prev_weather].weather;
  prev_rdm = rdm_prev_weather;
}

//fonction d'affichage
void affichage(){
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print(current_weather);
  lcd.print(">");
  lcd.print(previous_weather); 
  lcd.setCursor(0,1);
  lcd.print("temp h ");
  lcd.print(10000 + accl);
  lcd.print("ms");
}

void setup() {
  Serial.begin(9600);
  Serial.print(tik),Serial.print(" "),Serial.print(current_weather),Serial.print(" " ),Serial.println(previous_weather);
  lcd.begin(16, 2);              // start the library
  lcd.setCursor(0,0);
  lcd.print("Bonjour"); // print a simple message*/
  while(!Serial){
    
  }
  
  //remplissage du tableau de structure pour pouvoir gerer la météo plus facilement
  tab_weather[0].weather=("rainny");
  tab_weather[1].weather=("cloudy");
  tab_weather[2].weather=("sunny");
  tab_weather[3].weather=("heatwave");
  tab_weather[4].weather=("thunderstrom");
}

void loop() { // run over and over      
  if (millis()-horloge >= accl + 10000){
    tik = tik +1;
    Serial.print(tik),Serial.print(" "),Serial.print(current_weather),Serial.print(" " ),Serial.println(previous_weather);
    horloge = millis();
    if(tik%24 == 0){
      weather_f();
    }
    affichage();
  }

  if((read_LCD_buttons() == 1) & ((millis()-start_time)>200)){
    start_time = millis();
    accl = accl +200;
    affichage();
  }
  if((read_LCD_buttons() == 2) & ((millis()-start_time)>200) & accl>-29800){
    start_time = millis();
    accl = accl -200;
    affichage();
  }
}



