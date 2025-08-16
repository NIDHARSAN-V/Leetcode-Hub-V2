
class MyStack {
    private Deque<Integer> dq;

    public MyStack() {
        dq = new LinkedList<>();
    }

    public void push(int x) {
        dq.addFirst(x);  
    }

    public int pop() {
        return dq.removeFirst();
    }

    public int top() {
        return dq.peekFirst(); 
    }

    public boolean empty() {
        return dq.isEmpty();
    }
}
