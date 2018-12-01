#include <vector>
#include <unordered_map>
using namespace std;

class Solution
{
  public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        std::unordered_map<int, int> num_map;

        for (int i = 0; i < nums.size(); ++i)
        {
            if (num_map.count(target - nums[i]))
            {
                return {num_map[target - nums[i]], i};
            }
            else
            {
                num_map[nums[i]] = i;
            }
        }
    }
};