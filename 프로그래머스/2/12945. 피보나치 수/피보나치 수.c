#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer, n1 = 0, n2 = 1, count = 1;
    int c = 1234567;

    if (n <= 2) {
        return 1;
    } //예외

    while (count < n) {
        answer = ((n1 % c) + (n2 % c) )% c;
        n1 = n2;
        n2 = answer;
        count++;

        if (count == n) {
            break;
        }
    }

    return answer;
}