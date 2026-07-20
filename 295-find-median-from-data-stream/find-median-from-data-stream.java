class MedianFinder {
    private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {}
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        return left.size() > right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */