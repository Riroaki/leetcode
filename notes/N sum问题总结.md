# N sum问题总结

### 1sum

等价于找值

#### 2sum

双指针，前后指针向中间靠拢

```cpp
// Find **unique** 2-pairs in a vector whose sum equals to target.
vector<vector<int>> TwoSum(vector<int>& nums, int target) {
    int left = 0, right = nums.size() - 1;
    vector<vector<int>> res;
    // Sort the nums in increasing order.
    sort(nums.begin(), nums.end());
    // Cut the branch.
    if(nums.size() < 2 || nums[left] + nums[left + 1] > target || nums[right] + nums[right - 1] < target)
        return {};
    while(left < right) {
        int tmp = nums[left] + nums[right];
        if(tmp > target)
            do {
                right--;
            } while(left < right && nums[right] == nums[right + 1]);
        else if(tmp < target)
            do {
                left++;
            } while(left < right && nums[left] == nums[left - 1]);
        else {
            vector<int> temp;
            temp.push_back(left);
            temp.push_back(right);
            res.push_back(temp);
            do {
                left++; // Or right--;
            } while(left < right && nums[left] == nums[left - 1]);
        }
    }
    return res;
}
```

### 3sum

固定第一个数之后双指针

```cpp
// Find **unique** 3-pairs whose sum equals to the target.
vector<vector<int>> ThreeSum(vector<int>& nums, int target) {
    int first = 0;
    vector<vector<int>> res;
    // Sort the nums.
    sort(nums.begin(), nums.end());
    // Cut the branch.
    if(nums.size() < 3 || nums[nums.size() - 1] + nums[nums.size() - 2] + nums[nums.size() - 3] < target)
        return {};
    while(first < nums.size() - 2) {
        int second = first + 1;
        int last = nums.size() - 1;
        // Cut the branch.
        if(nums[first] + nums[second] + nums[second + 1] > target)
            break;
        if(nums[first] + nums[last] + nums[last - 1] < target)
            goto PLUS;
        while(second < last) {
            if(nums[second] + nums[last] + nums[first] < target)
                do {
                    second++;
                } while(second < last && nums[second] == nums[second - 1]);
            else if(nums[second] + nums[last] + nums[first] > target)
                do {
                    last--;
                } while(second < last && nums[last] == nums[last + 1]);
            else {
                vector<int> temp;
                temp.push_back(first);
                temp.push_back(second);
                temp.push_back(last);
                res.push_back(temp);
                do {
                    second++; // Or last--;
                } while(second < last && nums[second] == nums[second - 1]);
            }
        }
PLUS:
        // Move the first pointer forward.
        do {
            first++;
        } while(first < nums.size() - 2 && nums[first] == nums[first - 1]);
    }
    return res;
}
```

### 4sum

升级版3sum

```cpp
// Find 4 numbers whose sum equals to target.
vector<int> FourSum(vector<int>& nums, int target) {
    int first = 0;
    // Sort the nums.
    sort(nums.begin(), nums.end());
    // Cut the branch.
    if(nums.size() < 4 || nums[nums.size() - 1] + nums[nums.size() - 2] + nums[nums.size() - 3] + nums[nums.size() - 4] < target)
        return {};
    while(first < nums.size() - 3) {
        int ptr1 = first + 1;
        while(ptr1 < nums.size() - 2) {
            int tempSum = nums[first] + nums[ptr1];
            int ptr2 = ptr1 + 1;
            int last = nums.size() - 1;
            // Cut the branch.
            if(tempSum + nums[ptr2] + nums[ptr2 + 1] > target)
                return res;
            if(tempSum + nums[last] + nums[last - 1] < target)
                continue;
            while(ptr2 < last) {
                if(tempSum + nums[ptr2] + nums[last] < target)
                    do {
                        ptr2++;
                    } while(ptr2 < last && nums[ptr2] == nums[ptr2 - 1]);
                else if(tempSum + nums[ptr2] + nums[last] > target)
                    do {
                        last--;
                    } while(ptr2 < last && nums[last] == nums[last + 1]);
                else {
                    vector<int> temp;
                    temp.push_back(first);
                    temp.push_back(ptr1);
                    temp.push_back(ptr2);
                    temp.push_back(last);
                    res.push_back(temp);
                    do {
                        ptr2++; // Or last--;
                    } while(ptr2 < last && nums[ptr2] == nums[ptr2 - 1]);
                }
            }
            do {
                ptr1++;
            } while(ptr1 < nums.size() - 3 && nums[ptr1] == nums[ptr1 - 1]);
        }
        do {
            first++;
        } while(first < nums.size() - 4 && nums[first] == nums[first - 1]);
    }
    return res;
}
```

### n-sum(n > 1)

递归调用下层函数

```cpp
int MinSum(vector<int> nums, int n, int start) {
    int sum = 0;
    for(int i = 0; i < n; i++)
        sum += nums[start + i];
    return sum;
}

int MaxSum(vector<int> nums, int n) {
    int sum = 0, s = nums.size() - 1;
    for(int i = 0; i < n; i++ )
        sum += nums[s - i];
    return sum;
}

vector<vector<int>> NSumRecursive(vector<int> nums, int target, int n, int start) {
    vector<vector<int>> res;
    // The simplest case.
    if(n == 2) {
        int left = start, right = nums.size() - 1;
        while(left < right) {
            if(nums[left] + nums[right] < target)
                do {
                    left++;
                } while(left < right && nums[left] == nums[left - 1]);
            else if(nums[left] + nums[right] > target)
                do {
                    right--;
                } while(left < right && nums[right] == nums[right + 1]);
            else {
                vector<int> temp;
                temp.push_back(left);
                temp.push_back(right);
                res.push_back(temp);
                do {
                    left++;
                } while(left < right && nums[left] == nums[left - 1]);
            }
        }
    } else {
        int first = start;
        while(first < nums.size() - n + 1) {
            // Cut the branches.
            if(MinSum(nums, n, first) > target)
                goto PLUS;
            if(MaxSum(nums, n) < target)
                return res;
            vector<vector<int>> pre_res = NSumRecursive(nums, target - nums[first], n - 1, first + 1);
            for(int i = 0; i < pre_res.size(); i++) {
                vector<int> temp = pre_res[i];
                temp.insert(0, first);
                res.push_back(temp);
            }
PLUS:
            do {
                first++;
            } while(first < nums.size() - n + 1 && nums[first] == nums[first - 1]);
        }
    }
    return res;
}

vector<vector<int>> NSum(vector<int> nums, int target, int n) {
    sort(nums.begin(), nums.end());
    // Cut the branch.
    if(n < 2 || nums.size() < n || MaxSum(nums, n) < target)
        return {};
    return NSumRecursive(nums, target, n, 0);
}
```

