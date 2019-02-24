#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;

static auto ____ = []() {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return nullptr;
}();

// 用哈希表存字典，其实比较消耗空间
class Solution
{
  public:
    bool isAlienSorted(vector<string> &words, string order)
    {
        int n = words.size();
        unordered_map<char, int> dict;
        for (int i = 0; i < order.length(); i++)
            dict[order[i]] = i;
        for (int i = 0; i < n - 1; i++)
        {
            int index = 0, l1 = words[i].length(), l2 = words[i + 1].length();
            int lmin = l1 < l2 ? l1 : l2;
            bool less = true;
            for (; index < lmin; index++)
                if (dict[words[i][index]] > dict[words[i + 1][index]])
                {
                    less = false;
                    break;
                }
                else if (dict[words[i][index]] < dict[words[i + 1][index]])
                    break;
            if (index < lmin)
            {
                if (less == false)
                    return false;
            }
            else if (lmin == l2)
                return false;
        }
        return true;
    }
};