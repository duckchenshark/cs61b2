package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();        // 调用父类构造函数
        comparator = c; // 保存比较器
    }

    public T max() {
        return max(comparator); // 使用构造时的比较器
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = this.get(0);
        for (T item : this) { // 正确遍历继承自 ArrayDeque 的元素
            if (c.compare(item, maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }
}
