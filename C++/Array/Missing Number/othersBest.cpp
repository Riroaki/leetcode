#include <vector>
#include <iostream>
using namespace std;

// 这个做法朴素而不失简洁。真是太强了。
class Solution
{
  public:
    int missingNumber(vector<int> &nums)
    {
        int n = nums.size();
        int s = n * (n + 1) / 2;
        for (int k : nums)
            s -= k;
        return s;
    }
};