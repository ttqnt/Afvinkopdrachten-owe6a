package syntaxchecker;

import java.util.Stack;

/**
 * Applicatie controleert of alle haakjes juist gesloten zijn.
 * @author Karin
 */
public class SyntaxChecker {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "(check[haakjes{en (accolades)}])";
        System.out.println("De haakjes worden correct geopend en gesloten: " + syntaxCheck(s));
    }
    
    /** 
     * Methode controleert of de haakjes in de String parameter juist afgesloten zijn.
     * @param code String.
     * @return boolean.
     */    
    public static boolean syntaxCheck(String code){
        Stack<Character> stk = new Stack<>();
 
        for(int i = 0; i < code.length(); i++){            
            switch (code.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stk.push(code.charAt(i));
                    break;
                case ')':
                    if(!stk.isEmpty() && stk.peek() == '(') {
                        stk.pop();
                    }else {
                        return false;
                    }          break;
                case ']':
                    if(!stk.isEmpty() && stk.peek() == '[') {
                        stk.pop();
                    } else {
                        return false;
                    }     break;
                case '}':
                    if(!stk.isEmpty() && stk.peek() == '{') {
                        stk.pop();        
                    } else {
                        return false;
                    }     break;
                default:
                    break;
            }
        }
        return stk.isEmpty();
    }
}
    

