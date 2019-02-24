#include <string>
#include <cstdio>
using namespace std;

class Solution
{
  public:
    int scoreOfParentheses(string S)
    {
        int l = S.length();
        // 基本情况
        if (l < 2)
            return 0;
        if (l == 2)
            return 1;
        if (l == 4)
            return 2;
        // 切分字符串
        int current = 0, index = 0;
        for (; index < l; index++)
        {
            if (S[index] == '(')
                current++;
            else
                current--;
            if (current == 0)
                break;
        }
        int part1 = 0, part2 = 0;
        // 左边部分可能存在嵌套（左右两侧都是括号，相互对应）
        if (index == 1)
            part1 = 1;
        else
            part1 = 2 * scoreOfParentheses(S.substr(1, index - 1));
        // 右侧无法判定，故需要再检测……
        if (l == index + 1)
            part2 = 0;
        else
            part2 = scoreOfParentheses(S.substr(index + 1, l - index));
        return part1 + part2;
    }
};

int main()
{
    string s = "()()()()((()(((()))((())(((((()))()()())))))))";
    printf("%d\n", Solution().scoreOfParentheses(s));
}