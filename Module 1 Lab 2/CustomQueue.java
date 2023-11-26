import java.util.Scanner;
import java.util.Stack;

public class CustomQueue { // Change this class name to "Main" when you on litcoder
    private Stack<Integer> inputStack = new Stack<>();
    private Stack<Integer> outputStack = new Stack<>();

    public void enqueue(int x) {
        inputStack.push(x);
    }

    public void dequeue() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        if (!outputStack.isEmpty()) {
            outputStack.pop();
        }
    }

    public int front() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        
        return outputStack.isEmpty() ? -1 : outputStack.peek();
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] queries = input.split(",");
    
        for (String query : queries) {
            String[] parts = query.trim().split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int value = Integer.parseInt(parts[1]);
                queue.enqueue(value);
            } 
            else if (type == 2) {
                queue.dequeue();
            } 
            else{
                int n = queue.front();
                System.out.println(n);
            }
        }
        sc.close();
    }
    
}
