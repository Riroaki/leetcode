#include <algorithm>
#include <string>
using namespace std;

// 指明具体exception会提高速度；
// 用positive存是否为正数会提高一点速度。
// 16ms，75%
class Solution {
public:
    int reverse(int x) {
        bool positive = x > 0 ? true : false;
        string s;
        int result = 0;
        
        if(positive)
            s = to_string(x);
        else
            s = to_string(-x);
        std::reverse(s.begin(), s.end());
        try {
            result = stoi(s);
        } catch(std::out_of_range) {
            return 0;
        }
        return positive ? result : -result;
    }
};