#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;

// 宏定义：骚的一批
// 用旧字典序置换新的序：太tm骚了
// 最后用string自带的比较：真的骚
#define forp(i, s, n) for (int(i) = (s); (i) < (n); (i)++)
class Solution
{
  public:
    bool isAlienSorted(vector<string> &words, string order)
    {
        int n = words.size();
        if (n == 1)
            return true;
        int len = order.size();
        string temporder(len, 'a');
        forp(i, 0, len)
        {
            temporder[order[i] - 'a'] = i + 'a';
        }
        forp(i, 0, n)
        {
            int m = words[i].size();
            forp(j, 0, m)
                words[i][j] = temporder[words[i][j] - 'a'];
        }
        forp(i, 1, n)
        {
            if (words[i] < words[i - 1])
                return false;
        }
        return true;
    }
};