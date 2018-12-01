static int io_speedup = []()
{
	ios::sync_with_stdio(false);    // cin与stdin禁止同步
	cin.tie(NULL);                  //cin与cout解除绑定
	return 0;
}();

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size(), re=nums[0];
        for(int i=1;i<n;i++) re ^= nums[i];
        return re;
    }
};