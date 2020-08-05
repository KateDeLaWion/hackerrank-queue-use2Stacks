import java.util.Scanner;
import java.util.Stack;

public class Solution {

//    https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues

    // my solution is an easily understandable format:
    //my code starts here
    public static class MyQueue<Integer> {
        Stack<Integer> stackNewestOnTop = new Stack<Integer>();
        Stack<Integer> stackOldestOnTop = new Stack<Integer>();

        public void enqueue(Integer value) {
            stackNewestOnTop.push(value);
        }

        public Integer peek() {
            reverse_Newest_into_Oldest();
            return stackOldestOnTop.peek();
        }

        public Integer dequeue() {
            reverse_Newest_into_Oldest();
            return stackOldestOnTop.pop();
        }

        public void reverse_Newest_into_Oldest (){
            // items in stackNewestOnTop only need to be loaded to stackOldestOnTop when                stackOldestOnTop is empty. Otherwise, the order in stackOldestOnTop will                 be wrong if newer items are being pushed on the top.
            if(stackOldestOnTop.isEmpty()){ // or  .empty()

                // this while loop continue to loop until entire stackNewestOnTop items
                // are reversely put into the stackOldestOnTop so
                // the oldest is on top.
                while(!stackNewestOnTop.isEmpty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }
    //my code ends here





    // Another solution:
    //my code starts here
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }
        public T peek() {
            prepOldestOnTop();
            return stackOldestOnTop.peek();
        }
        public T dequeue() {
            prepOldestOnTop();
            return stackOldestOnTop.pop();
        }

        private void prepOldestOnTop(){
            if(stackOldestOnTop.empty()){
                while(!stackNewestOnTop.empty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }
    //my code ends here


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}




