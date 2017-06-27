#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>
#include <curl/curl.h>





int main(int argc, char *argv[])
{
    int fd;
    fd = open("/dev/ttyACM0", O_RDWR | O_NOCTTY);
    printf("fd opened as %i\n", fd);

    char buf[64]={0};ssize_t n;
    int i,j,k,compt;
    __uint32_t tik;
    char curent_weather[10],prevision_weather[10];
    do {
        CURL *curl;
        CURLcode res;
        /* In windows, this will init the winsock stuff */
        curl_global_init(CURL_GLOBAL_ALL);
        /* get a curl handle */
        curl = curl_easy_init();
        struct curl_slist *list = NULL;

        if(fd != -1) {

            /* Receive string from Arduino */
            n = read(fd, buf, 64);
            buf[n] = 0;
            tik++;
            printf("%s", curent_weather);

            compt = 0;j = 0; k = 0; i=0;
            while(buf[i]!='\r'){
                if (buf[i] == ' ') {
                    compt++;
                }
                switch (compt) {
                    case 1:
                        if(buf[i]!=' '){
                            curent_weather[j] = buf[i];
                            j++;
                        }
                        break;
                    case 2:
                        if(buf[i]!=' ') {
                            prevision_weather[k] = buf[i];
                            k++;
                        }
                        break;
                }
                buf[i]=0;
                i++;
            }

            printf("\n");printf("%d", tik);printf("%s", curent_weather);printf("%s", prevision_weather);printf("\n");

            char* msg_json;
            msg_json = malloc(1024);
            sprintf(msg_json,"{\"timestamp\":%d,\"weather\":[{\"dfn\":0,\"weather\":\"%s\"},{\"dfn\":1,\"weather\":\"%s\"]}", tik, curent_weather, prevision_weather);
            if (curl) {
                /* Specify the ULR target */
                curl_easy_setopt(curl, CURLOPT_URL, "https://limonade-equipe7.herokuapp.com/metrology");
                /* Now specify the POST data */
                curl_easy_setopt(curl, CURLOPT_POSTFIELDS, msg_json);
                list = curl_slist_append(list, "content-Type:application/json");
                curl_easy_setopt(curl, CURLOPT_HTTPHEADER, list);
                /* Perform the request, res will get the return code */
                res = curl_easy_perform(curl);
                if (res != CURLE_OK) {
                    printf("curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
                }
                printf("\n");
                free(msg_json);
                curl_easy_cleanup(curl);
            }
            curl_global_cleanup();

            for (i = 0; i < 10; i++) {
                curent_weather[i] = 0;
                prevision_weather[i] = 0;
            }
        }
    } while (buf[n] != '0');
}