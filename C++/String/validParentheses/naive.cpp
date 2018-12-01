#include <iostream>
#include <unordered_map>
#include <stack>
#include <string>
using namespace std;

// 100% after adding this...
static const auto _____ = []()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	return nullptr;
}();

// 71%...
class Solution {
public:
    bool isValid(string s) {
        if(s.length() % 2)
            return false;
        std::stack<char> st;
        std::unordered_map<char, char> m;
        m['('] = ')';
        m['['] = ']';
        m['{'] = '}';
        m[')'] = '0';
        m[']'] = '1';
        m['}'] = '2';
        for(int i=0;i<s.length();i++) {
            if(!st.empty()) {
                char tmp = m[st.top()];
                if(tmp != s[i])
                    st.push(s[i]);
                else
                    st.pop();
            } else
                st.push(s[i]);
        }
        return st.empty();
    }
};

int main() {
    string line;
    while (true) {
        cin >> line;
        // line = "()[]{}";
        // line = line.substr(0, line.length() - 1);
        bool ret = Solution().isValid(line);
        cout << ret << endl;
    }
    return 0;
}