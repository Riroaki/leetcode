# C++的技巧

- cin比较慢，这里的代码可以让他和scanf一样快：

```cpp
static const auto _____ = []()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	return nullptr;
}();

// 这样写也可以
static int io_speedup = []()
{
	ios::sync_with_stdio(false);    // cin与stdin禁止同步
	cin.tie(NULL);                  //cin与cout解除绑定
	return 0;
}();
```

- dummy head是通常链表实践常用的做法。
- unordered_map很好用，对应高级语言中的字典结构，是一个哈希表，他的查找速度很快。
  - ordered_map速度较慢。

```cpp
#include <unordered_map>
// ...
std::unordered_map<int, int> num_map;
int counter = num_map.count(a);
num_map[a] = b;
```

- algorithm库中有reverse，find，sort等工具，很好用。
- 最长公共子序列和和最大子序列求法差不多。
- stack< T >也很好用。有push，top，pop（返回值无意义）