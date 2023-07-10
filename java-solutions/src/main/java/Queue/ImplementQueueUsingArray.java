package Queue;

public class ImplementQueueUsingArray {
    /**
     * Queue implementation using an array.
     */
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        /**
         * Constructs an empty queue with the specified capacity.
         *
         * @param capacity the maximum capacity of the queue
         */
        public ImplementQueueUsingArray(int capacity) {
            this.capacity = capacity;
            queue = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        /**
         * Adds an element to the rear of the queue.
         *
         * @param element the element to be added
         * @throws IllegalStateException if the queue is full
         */
        public void enqueue(int element) {
            if (isFull()) {
                throw new IllegalStateException("Queue is full. Cannot enqueue element.");
            }
            rear = (rear + 1) % capacity;
            queue[rear] = element;
            size++;
        }

        /**
         * Removes and returns the element from the front of the queue.
         *
         * @return the element removed from the front of the queue
         * @throws IllegalStateException if the queue is empty
         */
        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty. Cannot dequeue element.");
            }
            int element = queue[front];
            front = (front + 1) % capacity;
            size--;
            return element;
        }

        /**
         * Returns the element at the front of the queue without removing it.
         *
         * @return the element at the front of the queue
         * @throws IllegalStateException if the queue is empty
         */
        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty. Cannot peek element.");
            }
            return queue[front];
        }

        /**
         * Checks if the queue is empty.
         *
         * @return true if the queue is empty, false otherwise
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks if the queue is full.
         *
         * @return true if the queue is full, false otherwise
         */
        public boolean isFull() {
            return size == capacity;
        }

        /**
         * Returns the number of elements in the queue.
         *
         * @return the number of elements in the queue
         */
        public int size() {
            return size;
        }

    public static void main(String[] args) {
        ImplementQueueUsingArray queueUsingArray = new ImplementQueueUsingArray(5);
        queueUsingArray.enqueue(14);
        queueUsingArray.enqueue(5);
        queueUsingArray.enqueue(6);
        queueUsingArray.enqueue(7);
        System.out.println(queueUsingArray.size());

        System.out.println(queueUsingArray.dequeue());
        queueUsingArray.enqueue(13);
        System.out.println(queueUsingArray.peek());

        System.out.println(queueUsingArray.size());


    }
    }


