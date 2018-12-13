#include <vector>
#include <iostream>
using namespace std;
static auto ____ = []() {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return nullptr;
}();

class Solution
{
  public:
    int maxArea(vector<int> &heights)
    {
        int start = 0, end = heights.size() - 1, max = 0, tmp;
        while (start < end)
        {
            if (heights[start] >= heights[end])
            {
                tmp = heights[end] * (end - start);
                end--;
            }
            else
            {
                tmp = heights[start] * (end - start);
                start++;
            }
            if (tmp > max)
                max = tmp;
        }
        return max;
    }
};