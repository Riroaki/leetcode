==：对-128～127的Integer，自动拆箱成int；对更大的Integer就比较Integer对象的存储地址

拆箱本质是自动调用了Integer.intValue()；装箱的本质是自动调用了Integer.valueOf()方法

所以对Integer的比较，需要使用intValue。