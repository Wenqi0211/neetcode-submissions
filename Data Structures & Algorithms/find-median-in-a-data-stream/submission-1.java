class MedianFinder {
    Queue<Integer> smallHeap = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> largeHeap = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (smallHeap.isEmpty() || num < smallHeap.peek()) {
            smallHeap.offer(num);
        } else {
            largeHeap.offer(num);
        }
        if (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.offer(smallHeap.poll());
        } else if (largeHeap.size() > smallHeap.size()) {
            smallHeap.offer(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        }
        return (smallHeap.peek() + largeHeap.peek()) / 2.0;
    }
}
