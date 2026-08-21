#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int price, int money, int count) {
    long long pay = 0;
    
    for(int i=1; i<=count; i++){
        pay += price * i;
    }
    
    long long answer = pay-money<=0?0:pay-money;
    
    return answer;
}