#include <string>
#include <cstdio>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0, len = s.length(), maxLen = 0, tempLen = len ? 1 : 0;
        string sub = s.substr(start, tempLen);
        for(int i=1;i<len;i++) {
            int index = sub.find(s[i]);
            if(index == -1) {
                sub += s[i];
                tempLen += 1;
                if(tempLen > maxLen)
                    maxLen = tempLen;
            } else {
                sub = sub.substr(index + 1) + s[i];
                tempLen -= index;
            }
        }
        if(tempLen > maxLen)
            maxLen = tempLen;

        return maxLen;
    }
};

int main(void) {
    Solution sol = Solution();
    string s("abaabbab!ba");
    printf("%d", sol.lengthOfLongestSubstring(s));
}