#include <errno.h>
#include <stdio.h>

int check_BUG(){
	int is_BUG;
	//do detect
	//...
	//错误返回errno
	printf("错误原因:%d\n%s\n", errno, strerror(errno));
	return errno;
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
