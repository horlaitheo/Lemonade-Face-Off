#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>
#include <curl/curl.h>





int main(int argc, char *argv[])
{
    CURL *curl;
    CURLcode res;
/* In windows, this will init the winsock stuff */
    curl_global_init(CURL_GLOBAL_ALL);
/* get a curl handle */
    curl = curl_easy_init();
    struct curl_slist *list = NULL;

    ssize_t n;
    int fd, i;
    char buf[64];
    struct termios toptions;
    __uint32_t tik= 0;
    char curent_weather[10],prevision_weather[10];

    /* open serial port */
    printf("\n");
    fd = open("/dev/ttyACM1", O_RDWR | O_NOCTTY);
    printf("fd opened as %i\n", fd);


    /* get current serial port settings */
    tcgetattr(fd, &toptions);
    /* set 9600 baud both ways */
    cfsetispeed(&toptions, B9600);
    cfsetospeed(&toptions, B9600);
    /* 8 bits, no parity, no stop bits */
    toptions.c_cflag &= ~PARENB;
    toptions.c_cflag &= ~CSTOPB;
    toptions.c_cflag &= ~CSIZE;
    toptions.c_cflag |= CS8;
    /* Canonical mode */
    toptions.c_lflag |= ICANON;
    /* commit the serial port settings */
    tcsetattr(fd, TCSANOW, &toptions);

    //printf("Byte :%i, ", (int)buf[0]);
    do{
            /* Receive string from Arduino */
        n = read(fd, buf, 64);
        buf[n] = 0;
        tik ++ ;

        int compt = 0;
        int j=0, k=0;

        for(i=0;i<64;i++){
            if(buf[i]=='@'){
                compt = 0;
            }
            if(buf[i]==' ') {
                compt++;
            }
            switch(compt) {
                case 1:
                    curent_weather[j]=buf[i];
                    j++;
                    break;
                case 2:
                    prevision_weather[k]=buf[i];
                    k++;
                    break;
            }
        }
        printf("%i", tik);
        printf("%s", curent_weather);
        printf("%s", prevision_weather);
        printf("\n");

        /* First set the URL that is about to receive our POST. This URL can
        just as well be a https:// URL if that is what should receive the
        data. */
        curl_easy_setopt(curl, CURLOPT_URL, "https://limonade-equipe7.herokuapp.com/metrology");
        /* Now specify the POST data */
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, "{\"timestamp\": \"tik\",\"weather\":[{\"dfn\":0,\"weather\":curent_weather},{\"dfn\":1,\"weather\":prevision_weather]}");

        list = curl_slist_append(list, "content-Type:application/json");
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, list);

        /* Perform the request, res will get the return code */
        res = curl_easy_perform(curl);
        curl_global_cleanup();

        for(i=0;i<10;i++){
            curent_weather[i]='\0';
            prevision_weather[i]='\0';
        }
    }while(buf[n]!='0');

}