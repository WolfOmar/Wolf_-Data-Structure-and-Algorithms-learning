#define FALSE 0;
#define TRUE 1;
#define N 2;    /* number of processes */

int turn;   /* whose turn is it */
int interested[N];  /* all values initially 0 */

void enter_region(int processes){   //process  is 0 or 1
    int other;  //number of other process
    other = 1-processes;        //the opposite of process
    interested[processes] = TRUE;       //show that you are interested
    turn = processes;       //set flag
    while(turn==processes && interested[other]==TRUE);
}

void leave_region(int processes){       //process:who is leaving
    interested[processes] = FALSE;      // indicate departure from critical region
}