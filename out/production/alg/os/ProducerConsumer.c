#define N 100;      //number of slots in the buffer
#define TRUE 1;
int count = 0;      //number of items in the buffer

void producer(void){
    int item;

    while(TRUE){
        item = produce_item();
        if(count == N){
            sleep();
        }
        insert_item(item);
        count++;
        if(count == 1){
            wakeup(consumer);
        }
    }
}

void consumer(void){
    int item;

    while(TRUE){
        if(count == 0){
            sleep();
        }
        item = remove_item();
        count--;
        if(count == N-1){
            wakeup(producer);
        }
        consume_item(item);
    }
}