#include <string>
#include <cstdio>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int len = (int)s.length(), start = 0;
        if(len == 0)
            return string("");
        int mat[len][len], maxLen = 1;
        memset(mat, 0, sizeof(mat));
        for(int i=0;i<len;i++) mat[i][i] = 1;
        for(int i=0;i<len-1;i++) {
            if(s[i] == s[i+1]) {
                mat[i][i+1] = 2;
                maxLen = 2;
                start = i;
            }
        }
        for(int j=2;j<len;j++) {
            for(int i=0;i+j<len;i++) {
                if(mat[i+1][i+j-1] == 0) continue;
                if(s[i+j] == s[i]) {
                    mat[i][i+j] = mat[i+1][i+j-1] + 2;
                    if(mat[i][i+j] > maxLen) {
                        maxLen = mat[i][i+j];
                        start = i;
                    }
                }
            }
        }

        // for(int i=0;i<len;i++) {
        //     for(int j=0;j<len;j++) {
        //         if(mat[i][j] == 0)
        //             printf("  ");
        //         else printf("%d ", mat[i][j]);
        //     }
        //     printf("\n");
        // }
        return s.substr(start, maxLen);
    }
};

int main() {
    string s = "aaabaaaa";
    printf("%s", Solution().longestPalindrome(s).c_str());
    return 0;
}