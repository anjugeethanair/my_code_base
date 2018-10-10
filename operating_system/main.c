/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Anju
 *
 * Created on August 13, 2018, 7:26 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int val = 0;
pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
// A normal C function that is executed as a thread 
// when its name is specified in pthread_create()
void *firstThread(void *vargp)
{
    sleep(1);
    //pthread_mutex_lock(&mutex1); // comment out
    val+=10;
    pthread_mutex_unlock(&mutex1); // comment out
    printf("First thread \n");
    return NULL;
}

void *secondThread(void *vargp)
{
    sleep(2);
    //pthread_mutex_lock(&mutex1); // comment out
    val*=2;
    pthread_mutex_unlock(&mutex1); // comment out
    printf("Second Thread \n");
    return NULL;
}



/*
 * 
 */
int main(int argc, char** argv) {
    pthread_t thread_id1, thread_id2;
    printf("Before Thread %d \n", val);
    //pthread_mutex_lock(&mutex1); // comment out
    pthread_create(&thread_id2, NULL, secondThread, NULL);
    pthread_create(&thread_id1, NULL, firstThread, NULL);
    pthread_join(thread_id1, NULL);
    pthread_join(thread_id2, NULL);
    printf("After Thread %d \n", val);
    return (EXIT_SUCCESS);
}

