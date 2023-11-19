package Stack;

import java.util.Stack;

public class MinRemoveToMakeValidPArentheses {
        public static String minRemoveToMakeValid(String s) {
            Stack<Integer> myStack = new Stack<>();

            StringBuilder sb = new StringBuilder();
            for( int i = 0; i< s.length(); i++){
                if(s.charAt(i) == '('){
                    myStack.push(i);

                } else if( s.charAt(i) == ')'){
                    if(!myStack.isEmpty() ){
                        myStack.pop();
                    } else {
                        myStack.push(i);
                    }
                }
                sb.append(s.charAt(i));
            }

            while(!myStack.isEmpty()){
                int poppedVal = myStack.pop();
                sb.deleteCharAt(poppedVal);
            }
            return sb.toString();
        }

    public static void main(String[] args) {
        String input = "lee(t(c)o)de)";
        minRemoveToMakeValid(input);

    }
    }

