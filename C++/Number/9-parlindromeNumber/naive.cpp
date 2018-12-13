static const auto _ = []()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return nullptr;
}();

class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0) return false;
        int y = x, tmp=0;
        while(y) {
            tmp = tmp * 10 + y % 10;
            y /= 10;
        }
        return x == tmp;
    }
};