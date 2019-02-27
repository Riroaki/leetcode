==：对-128～127的Integer，自动拆箱成int；对更大的Integer就比较Integer对象的存储地址

拆箱本质是自动调用了Integer.intValue()；装箱的本质是自动调用了Integer.valueOf()方法

所以对Integer的比较，需要使用intValue。

对List<Integer>的元素比较，一定要用equals！
对于一个List<Integer>和另外的int值比较，一般来说会自动拆箱
