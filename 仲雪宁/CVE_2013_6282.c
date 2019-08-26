#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <sys/socket.h>

int check_BUG(){
	int is_BUG;
	//do detect
	int sFd = socket(2, 1, 6);
    if(sFd < 0)
    {
        return errno == 0 || errno == 1 ? -1 : errno;
    }

    int ret = -1;

    //Random kernel address
    uint32_t address = 0xc02278cc;

    int e1;
    errno = 0;

    ret = setsockopt(sFd, 0, SO_REUSEADDR, (void*)address , 1);
    e1 = errno;

    printf("ret : %d",ret);
    printf("errno: %d\n", errno);
    perror("setsockopt");

    if(ret == -1 && e1 == 14) is_BUG=0;; //Not vulnerable
    if(ret == 0 && e1 == 0) is_BUG= 1; //Vulnerable
    printf("%d\n",is_BUG);
    //return errno == 0 || errno == 1 ? -1 : errno ; //Bad test
	//错误返回errno
	printf("错误原因:%d\n%s\n", errno, strerror(errno));
	//return errno;
	//...
	if(is_BUG){
		printf("vuln");	
		return -2;
	}
	else{
		printf("not vuln");	
		return -1;
	}
}

int main(){
	return check_BUG();
}
