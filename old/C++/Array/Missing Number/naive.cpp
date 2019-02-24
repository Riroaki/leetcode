#include <vector>
#include <iostream>
using namespace std;

static auto ____ = []() {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return nullptr;
}();

// 看起来，一个for里面一个while，复杂度N2，但是：
// 每次交换至少有一个数就位，所以需要交换的总次数是小于N次的；
// 综合比较的O（N）复杂度，和下面遍历的N复杂度，应该是O（N）的复杂度。
class Solution
{
  public:
    int missingNumber(vector<int> &nums)
    {
        int n = nums.size();
        if (n == 0)
            return 0;
        nums.push_back(-1);
        for (int i = 0; i <= n; i++)
        {
            while (nums[i] != i && nums[i] != -1)
            {
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i <= n; i++)
            if (nums[i] == -1)
                return i;
        // 不可能到这里的，随便return一个值吧
        return -1;
    }
};