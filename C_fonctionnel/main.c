#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <curl/curl.h>

int main(int argc, char *argv[])
{
    //ouverture du port pour se connecter a l'arduino
    int fd;
    fd = open("/dev/ttyACM0", O_RDWR | O_NOCTTY);
    printf("fd opened as %i\n", fd);

    char *buf;ssize_t n;
    int i,j,k,compt;
    __uint32_t tik;
    char curent_weather[10],prevision_weather[10];
    do {
        char* buf; //redeclaration d'un buffeur pour pouvoir faire des malloc dans le do while
        buf = malloc(32);
        CURL *curl;
        CURLcode res;
        //Initialisation de CURL_GLobal
        curl_global_init(CURL_GLOBAL_ALL);
        //Initialisation de CURL_easy
        curl = curl_easy_init();
        struct curl_slist *list = NULL;

        if(fd != -1) {//si la connection est etablie

            //Lecture du buffeur
            n = read(fd, buf,32);
            if (*buf != '\n') {
                buf[n] = 0;
                i = 0;
                compt = 0;
                j = 0;
                k = 0;

                while (buf[i] != '\n') {
                    if (buf[i] == ' ') { //si on rencontre un espace on passe au mot suivant
                        compt++;
                    }
                    switch (compt) {
                        case 1:         //si c'est le premier mot
                            if (buf[i] != ' ') {
                                curent_weather[j] = buf[i];
                                j++;
                            }
                            break;
                        case 2:         //si c'est le second mot
                            if (buf[i] != ' ') {
                                prevision_weather[k] = buf[i];
                                k++;
                            }
                            break;
                    }
                    //buf[i] = 0;
                    i++;
                }
                tik++; //on compte le nombre d'occurence

                printf("\n");
                printf("%d", tik);
                printf("%s", curent_weather);
                printf("%s", prevision_weather);
                printf("\n");

                char *msg_json;//on creer un message json
                msg_json = malloc(1024);
                sprintf(msg_json,
                        "{\"timestamp\":%d,\"weather\":[{\"dfn\":0,\"weather\":\"%s\"},{\"dfn\":1,\"weather\":\"%s\"}]}", tik,
                        curent_weather, prevision_weather);
                if (curl) {
                    //Specifie la route sur la quelle on POST
                    curl_easy_setopt(curl, CURLOPT_URL, "https://limonade-equipe7.herokuapp.com/metrology");
                    //On specifie le message a envoyer
                    curl_easy_setopt(curl, CURLOPT_POSTFIELDS, msg_json);
                    list = curl_slist_append(list, "content-Type:application/json");
                    curl_easy_setopt(curl, CURLOPT_HTTPHEADER, list);
                    //Recupere le message de retour pour verifier si le code a bien ete recu
                    res = curl_easy_perform(curl);
                    if (res != CURLE_OK) {
                        printf("curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
                    }
                    printf("\n");
                    //on remet a zero toutes les valeurs
                    free(msg_json);
                    free(buf);
                    curl_easy_cleanup(curl);
                }
                curl_global_cleanup();

                for (i = 0; i < 10; i++) {
                    curent_weather[i] = 0;
                    prevision_weather[i] = 0;
                }
            }
        }
    } while (buf[n]!='0');
}