package base;

import com.cracker.algorithm.base.struct.stack.BaseStack;
import com.cracker.algorithm.base.struct.stack.FixedCapacityStack;
import com.cracker.algorithm.imports.StdOut;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StackTest {
    
    @Test
    public void stackTest() {
    
        BaseStack<String> ops = new BaseStack<>();
        BaseStack<Double> vals = new BaseStack<>();
        String str = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.println(str.trim());
        //str.replace(" ","").chars().mapToObj(each -> String.valueOf((char)each)).forEach(System.out::print);
        str.replace(" ","").chars().mapToObj(each -> String.valueOf((char)each)).forEach(each -> operation(ops, vals, each));
        System.out.println(vals.pop());
    }
    
    private void operation(final BaseStack<String> ops, final BaseStack<Double> vals, final String each) {
        switch (each) {
            case "(":
            case "+":
            case "-":
            case "*":
            case "/":
                ops.push(each);
                break;
            case ")":{
                String op = ops.pop();
                double v = vals.pop();
                switch (op) {
                    case "+" :
                        v = v + vals.pop();
                        break;
                    case "-" :
                        v = v - vals.pop();
                        break;
                    case "*" :
                        v = v * vals.pop();
                        break;
                    case "/" : 
                        v = v / vals.pop();
                        break;
                    default :
                        throw new RuntimeException("未知字符: " + each);
                }
                vals.push(v);
                if (Objects.equals(ops.peek(), "(")) {
                    ops.pop();
                }
                break;
            }
            default:
                vals.push(Double.parseDouble(each));
        }
    }
    
    @Test
    public void stackTest2() {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        String[] strings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that","-", "-", "-","is"};
        List<String> asList = Arrays.asList(strings);
        
        asList.forEach(each -> {
            if (!each.equals("-")) {
                stack.push(each);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        });
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
