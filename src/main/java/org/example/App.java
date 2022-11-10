package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("{}{()()()");
        System.out.println(valid);

    }
}
