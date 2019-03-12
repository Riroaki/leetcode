public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tmp = i + map.get(list2[i]);
                if (minSum > tmp) {
                    res.clear();
                    res.add(list2[i]);
                    minSum = tmp;
                } else if (minSum == tmp)
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
