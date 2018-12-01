#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

static const auto _____ = []()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	return nullptr;
}();

inline int absVal(int a) {
    return a >= 0 ? a : -a;
}

class Solution {
public:
    int findClosestBetween(vector<int> &nums, int target, int i, int j) {
        // 两侧都比需要逼近的值小/大
        if(((nums[i] - target) ^ (nums[j] - target)) >= 0) {
            if(absVal(nums[i + 1] - target) < absVal(nums[j - 1] - target))
                return nums[i + i];
            return nums[j - 1];
        } else {  // 两侧和逼近的值比，一侧大一侧小
            // 那自然是i侧小而j侧大了，所以如果新的数k比target小那么在[k, j]之间找，否则在[i, k]之间找。
            // 待续。。
            int l=i, r=j, m;
            
        }
    }

    int threeSumClosest(vector<int>& nums, int target) {
        // if(nums.size() < 3)
        //     return 0;
        std::sort(nums.begin(), nums.end());
        int diff = absVal(target), closest, n = nums.size();
        // 为了避免重复计算，这里i，j从两头逼近，k只能取他们两个中间
        for(int i=0;i<n-2;i++) {
            for(int j=n-1;j>i+1;j--) {
                if(i == j) continue;
                int currentTarget = target - nums[i] - nums[j];
                int currentClosest = findClosestBetween(nums, currentTarget, i, j);
                int currentDiff = absVal(currentTarget - currentClosest);
                if(currentDiff < diff) {
                    closest = currentTarget + currentClosest;
                    diff = currentDiff;
                }
            }
        }
        return closest;
    }
};