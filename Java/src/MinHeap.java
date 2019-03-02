import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> nums;
    private int size;

    public MinHeap() {
        size = 0;
        nums = new ArrayList<>();
    }

    public MinHeap(int[] input) {
        size = input.length;
        nums = new ArrayList<>(size);
        heapify(input);
    }

    public int poll() {
        if (isEmpty())
            throw new NullPointerException();
        int res = nums.get(0), key = nums.get(size - 1);
        nums.remove(size - 1);
        if (--size > 0)
            siftDown(key, 0);
        return res;
    }

    public void offer(int key) {
        nums.add(key);
        size++;
        siftUp();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return nums.isEmpty();
    }

    public void print() {
        System.out.println(nums);
    }

    private void siftDown(int key, int index) {
        int half = size >> 1;
        while (index < half) {
            int child = (index << 1) + 1, right = (index << 1) + 2;
            if (size > right && nums.get(child) > nums.get(right))
                child = right;
            if (key < nums.get(child))
                break;
            nums.set(index, nums.get(child));
            index = child;
        }
        nums.set(index, key);
    }

    private void siftUp() {
        int key = nums.get(size - 1), index = size - 1, parent = (index - 1) >> 1;
        while (parent >= 0) {
            if (nums.get(parent) < key)
                break;
            nums.set(index, nums.get(parent));
            index = parent;
            parent = (index - 1) >> 1;
        }
        nums.set(index, key);
    }

    private void heapify(int[] input) {
        nums = new ArrayList<>();
        for (int num : input)
            nums.add(num);
        for (int i = (size >> 1) - 1; i >= 0; i--)
            siftDown(nums.get(i), i);
    }
}

class TestMinHeap {
    public static void main(String[] args) {
        MinHeap heap1 = new MinHeap();
        heap1.print();
        heap1.offer(5);
        heap1.offer(4);
        heap1.offer(3);
        heap1.offer(2);
        heap1.offer(1);

        heap1.print();
        System.out.println(heap1.poll());
        heap1.print();
        System.out.println(heap1.poll());
        System.out.println(heap1.poll());
        heap1.print();

        MinHeap heap2 = new MinHeap(new int[]{1, 5, 4, 7, 3, 8, 9, 2, 0});
        heap2.print();
        while (!heap2.isEmpty()) {
            System.out.print(heap2.poll() + " ");
        }
    }
}
