#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    if (!(cin >> T)) return 0;

    for (int t = 1; t <= T; t++) {
        int size;
        cin >> size;

        vector<int> people(size);
        for (int i = 0; i < size; i++) {
            cin >> people[i];
        }

        // 오름차순 정렬
        sort(people.begin(), people.end());

        int len = INT_MAX;
        int answer = 0;

        for (int i : people) {
            int now = abs(i);

            if (now < len) {
                len = now;
                answer = 1;
            } else if (now == len) {
                answer++;
            } else {
                break;
            }
        }

        // 수정된 출력 형식 반영 (#t len answer)
        cout << "#" << t << " " << len << " " << answer << "\n";
    }

    return 0;
}
