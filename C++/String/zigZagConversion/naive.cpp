#include <string>
#include <cstdio>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 0 || s.length() < 2)
            return s;
        string result[numRows];
        int index = 0;
        bool upward = false;
        
        while(index < s.length()) {
            int i=0;
            if(upward) {
                for(;i<numRows-2 && (index+i)<s.length();i++)
                    result[numRows-2-i] += s[index+i];
                index += i;
            } else {
                for(;i<numRows && (index+i)<s.length();i++)
                    result[i] += s[index+i];
                index += i;
            }
            upward = !upward;
        }
        for(int i=0;i<numRows;i++)
            printf("%s\t", result[i].c_str());
        for(int i=1;i<numRows;i++)
            result[0] += result[i];
        return result[0];
    }
};

int main() {
    string s = "LEETCODEISHIRING";
    printf("%s\n", Solution().convert(s, 4).c_str());
    return 0;
}