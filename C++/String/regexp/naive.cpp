#include <string>
#include <cstdio>
#include <iostream>
using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        int i=0, j=0, slen = s.length(), plen = p.length(), firstStar = p.find('*');

        if(firstStar == 0)
            return false;
        if(firstStar == -1) {
            if(slen != plen)
                return false;
            for(;i<slen;i++)
                if(s[i] != p[i] && p[i] != '.')
                    return false;
            return true;
        } else {
            // 匹配*号前一位的之前的字符，因为肯定是一对一的
            if(isMatch(s.substr(i, firstStar - 1), p.substr(j, firstStar - 1)) == false)
                return false;
            char lastCh = p[firstStar-1];
            // i 对应前面的字符，不能
            i = firstStar - 1;
            j = firstStar + 1;
            // 需要检查之后的字符
            if(lastCh == '.') {
                // .*是最后的字符，所以肯定通过
                if(j == plen)
                    return true;
                // 最小的字符数量
                int minCh = 0;
                // 连续的*是非法的
                if(p[j] == '*')
                    return false;
                // 连续出现.，计算最小字符数量
                while(p[j] == '.') {
                    minCh++;
                    i++;
                }
                int nextStar = p.substr(j).find('*');
                if(nextStar == -1) {
                    // 如果没有*了，后面的字符串p和s应该是一一对应的
                    // j = firstStar + 1
                    // plen - j 是模式串*后面的字符数，
                    // slen - plen + j 是对应模式串*后面的字符串
                    if(slen - plen + j - i < minCh)
                        return false;
                    if(isMatch(s.substr(slen - plen + j), p.substr(j)) == false)
                        return false;
                } else {
                    // 待定
                    return true;
                }
            } else {
                // a*a = aaa,这个case过不去
                // 之前的字符是字母，可以重复0-n次
                while(s[i] == lastCh)
                    i++;
                return isMatch(s.substr(i), p.substr(j));
            }
        }
        return true;
    }
};

int main(void) {
    Solution sol = Solution();
    string s, p;
    while(true) {
        cin>>s;
        if(s == "q")
            break;
        cin>>p;
        printf("%d", sol.isMatch(s, p));
    }
}