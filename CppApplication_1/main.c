#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
 

int i=0;

// A normal C function that is executed as a thread 
// when its name is specified in pthread_create()
void *myThreadFun(void *vargp)
{
    sleep(1);

        i++;

    printf("fn1 %d\n", i);
    return NULL;
}
void *myThreadFun1(void *vargp)
{   
    sleep(1);
        i++;
    for(int j = 0;j<10000;j++) {
        int k=0;
        k++;
    }
    printf("fn2 %d\n", i);
    return NULL;
}
  
int main()
{
    pthread_t thread_id, thread_id1;
    printf("Before Thread\n");
    pthread_create(&thread_id1, NULL, myThreadFun, NULL);
    pthread_create(&thread_id, NULL, myThreadFun1, NULL);
    pthread_join(thread_id1, NULL);
    pthread_join(thread_id, NULL);
    printf("After Thread\n");
    //exit(0);
}