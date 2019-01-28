#include <vector>
#include <cstdio>
#include <algorithm>
using namespace std;

// 直接暴力三重循环会比较慢，
// 先排序，然后从最小的正数（或者0）隔开的两部分中各自抽一个；
// 然后再在这两个之间抽一个，看三者的和是不是0；
// 外层循环用临时变量放两个数字的和，减少重复运算；
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> re;
        // 比三个元素还少
        if(n < 3)
            return re;
        // 排序
        sort(nums.begin(), nums.end());
        // 全部非负，或者全部非正
        if((nums.back() | nums[0]) >= 0) {
            // **注意可能存在两头有三个0的情况
            if(nums[0] + nums[1] + nums[2] == 0 || nums[n-1] + nums[n-2] + nums[n-3] == 0) {
                vector<int> temp;
                temp.push_back(0);
                temp.push_back(0);
                temp.push_back(0);
                re.push_back(temp);
            }
            return re;
        }
        // // 正负分割线
        // int index = 0;
        // for(;index<n;index++)
        //     if(nums[index] >= 0)
        //         break;
        int tmp1, tmp2;
        // 这里如果用index找到最小正数，边界会模糊不清的，所以需要用nums[i]的正负来判断边界
        vector<vector<int>> uniqueSum;
        for(int i=0;nums[i]<=0;i++) {
            tmp1 = nums[i];
            for(int j=n-1;nums[j]>=0;j--) {
                tmp2 = nums[j] + tmp1;
                // 肯定找不到的情况
                if(tmp2 + tmp1 > 0 || tmp2 + nums[j] < 0)
                    continue;
                for(int k=i+1;k<j;k++) {
                    if(tmp2 + nums[k] == 0) {
                        vector<int> temp;
                        temp.push_back(tmp1);
                        temp.push_back(nums[k]);
                        temp.push_back(nums[j]);
                        // 去重
                        if(std::find(re.begin(), re.end(), temp) != re.end())
                            continue;
                        re.push_back(temp);
                    }
                }
            }
        }
        return re;
    }
};

int main() {
    int arr[] = {6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5};
    vector<int> nums;
    for(int i=0;i<sizeof(arr)/sizeof(int);i++)
        nums.push_back(arr[i]);
    vector<vector<int>> re = Solution().threeSum(nums);
    for(int i=0;i<re.size();i++) {
        vector<int> tmp = re[i];
        for(int j=0;j<3;j++) {
            printf("%d ", tmp[j]);
        }
        printf("\n");
    }
}