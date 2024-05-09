package Stack;

public class Balanced {
    // Write a method isBalanced(String s) & checks whether the parentheses in s are well Balanced.
    // The method must use a stack

    public boolean isBalanced(String s){
        Stack st = new Stack();

        if(s == null){
            return true;
        }
        else{
            for (int i = 0; i < s.length(); i++) {
                if((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{')){
                    st.push(s.charAt(i));
                }
                else if(s.charAt(i) == ')'){
                    if((st.empty()) || (st.pop() != '(')){
                        return false;
                    }
                }
                else if(s.charAt(i) == ']'){
                    if ((st.empty()) || (st.pop() != '[')) {
                        return false;
                    }
                }
                else if(s.charAt(i) == '}'){
                    if ((st.empty()) || (st.pop() != '{')) {
                        return false;
                    }
                }
            }
            return (st.empty());
        }
    }
}
