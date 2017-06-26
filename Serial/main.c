#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>


#define DEBUG 1

int main(int argc, char *argv[])
{
    ssize_t n;
    int fd, i;
    char buf[64];
    struct termios toptions;
    int tik= 0;

    /* open serial port */
    printf("\n");
    fd = open("/dev/ttyACM0", O_RDWR | O_NOCTTY);
    printf("fd opened as %i\n", fd);

    /* wait for the Arduino to reboot */
    usleep(3500000);

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
    for(i = 0;i<1000;i++) {
        /* Receive string from Arduino */
        n = read(fd, buf, 64);
        buf[n] = 0;
        if (buf[1] == '1') {
            tik = tik + 1;
            printf("tik: %i\n", tik);
            printf("heure :%i\n", tik % 24);
        }
    }

}