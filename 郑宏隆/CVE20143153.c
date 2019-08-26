#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/syscall.h>


#define FUTEX_CMP_REQUEUE_PI    12

int checkIsVulnerable() {
   errno = 0;
   syscall( __NR_futex, 0xc0008000, FUTEX_CMP_REQUEUE_PI, 1, NULL, 0xc0008000, 0 );
   return errno;
}

/*JNIEXPORT jint JNICALL Java_fuzion24_device_vulnerability_vulnerabilities_kernel_CVE_12014_13153_checkFutex(JNIEnv *env, jobject obj){
   return checkIsVulnerable();
}*/

int main( int argc, char *argv[] )
{
    int errCode = checkIsVulnerable();

    switch(errCode)
    {
    case 22:
        printf( "looks like kernel is fixed\n" );
        return 255;
    case 14:
        printf( "looks like kernel is NOT fixed\n" );
        return 254;
    default:
        printf( "Oops, the test doesn\'t work on this kernel\nerrno: %d \"%s\"\n", errno, strerror( errno ) );
        return 0;
    }
    return 0;
}


