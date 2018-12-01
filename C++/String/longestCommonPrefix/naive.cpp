#include <string>
#include <vector>
#include <iostream>
using namespace std;

static const auto _____ = []()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	return nullptr;
}();

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.empty())
            return "";
        string prefix = strs[0];
        for(int i=1;i<strs.size();i++) {
            int index = 0;
            while(strs[i][index] == prefix[index])
                index++;
            prefix = prefix.substr(0, index - 1);
            if(index == 0)
                break;
        }
        return prefix;
    }
};