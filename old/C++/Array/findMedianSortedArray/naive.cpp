#include <vector>
using namespace std;

// 如果直接用double a数组的话，从int到double的转换会消耗大量时间；
// 本来的排名是战胜60%左右；
// 改成int，并在最后转double，这样的排名是战胜了95%左右
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int a[] = {0, 0};
        int i = 0, j = 0, len1 = nums1.size(), len2 = nums2.size();
        int middle = (len1 + len2) / 2;
        while(i < len1 || j < len2) {
            a[0] = a[1];
            if(i == len1) a[1] = nums2[j++];
            else if(j == len2) a[1] = nums1[i++];
            else if(nums1[i] < nums2[j]) a[1] = nums1[i++];
            else a[1] = nums2[j++];
            if(i + j > middle) break;
        }
        if((len1 + len2) % 2) return double(a[1]);
        else return (a[0] + a[1]) / 2.0;
    }
};

int main() {
    vector<int> a, b;
    a.push_back(1);
    a.push_back(3);
    b.push_back(2);
    printf("%lf", Solution().findMedianSortedArrays(a, b));
}