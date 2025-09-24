// Topics: Deque, Queue

class SpecialQueue {
    
    public Queue<Integer> q;
    public PriorityQueue<Integer> minH;
    public PriorityQueue<Integer> maxH;
    public Map<Integer,Integer> map;
    public SpecialQueue() {
        // Define Data Structures
         q = new LinkedList<>();
         maxH = new PriorityQueue<>((a,b)->{
            return (b-a);
        });
         minH = new PriorityQueue<>();
         map = new HashMap<>();
    }

    public void enqueue(int x) {
        // Insert element into the queue
        q.add(x);
        minH.add(x);
        maxH.add(x);
        map.put(x,map.getOrDefault(x,0)+1);
    }

    public void dequeue() {
        // Remove element from the queue
        if(q.isEmpty()) return ;
        int rem = q.poll();
        map.put(rem, map.get(rem) - 1);
        if (map.get(rem) == 0) map.remove(rem);

        while (!minH.isEmpty() && !map.containsKey(minH.peek())) minH.poll();
        while (!maxH.isEmpty() && !map.containsKey(maxH.peek())) maxH.poll();
    }

    public int getFront() {
        // Get front element
        if(q.isEmpty()) return 0;
        return q.peek();
    }

    public int getMin() {
        // Get minimum element
         if(q.isEmpty()) return 0;
        return minH.peek();
    }

    public int getMax() {
        // Get maximum element
         if(q.isEmpty()) return 0;
        return maxH.peek();
    }
}

// | Function   | Time Complexity | Space Complexity |
// | ---------- | --------------- | ---------------- |
// | `enqueue`  | O(log n)        | O(n)             |
// | `dequeue`  | O(log n) amort. | O(n)             |
// | `getFront` | O(1)            | O(n)             |
// | `getMin`   | O(1)            | O(n)             |
// | `getMax`   | O(1)            | O(n)             |
