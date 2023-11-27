import java.util.*;
public class CustomStack {
    
    static Scanner in = new Scanner(System.in);
    private static Stack<String> stack = new Stack<>();
    
    public static void main(String[] args) {
        stack.push("");
        while(in.hasNext()){
            int ch = in.nextInt();
            switch(ch){
                case 1:
                    insert(in.next());
                    break;
                case 2:
                    delete(in.nextInt());
                    break;
                case 3:
                    get(in.nextInt());
                    break;
                case 4:
                    undo();
                    break;
                default:
                    break;
                    
            }
        }
        
        
    }
    
    public static void insert(String st){
        stack.push(stack.peek() + st);
    }
    
    public static void delete(int n){
        stack.push(stack.peek().substring(0, stack.peek().length() - n));
    }
    
    public static void get(int m){
        System.out.println(stack.peek().charAt(m - 1));
    }
    
    public static void undo(){
        stack.pop();
    }
}
                                                                                                                            