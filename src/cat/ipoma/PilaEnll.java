package cat.ipoma;

import java.util.Stack;

/**
 * Created by santi on 25/04/2017.
 */
public class PilaEnll implements Pila {

    private int maxSize; // size of stack array
    private Object[] stackArray;
    private int top; // top of stack

    public PilaEnll(int max) // constructor
    {
        maxSize = max;
        stackArray = new Object[maxSize];
        top = -1;
    }

    @Override
    public void empilar(Object o) throws Exception {
        stackArray[++top] = o; // increment top, insert item
    }

    @Override
    public Object desempilar() throws Exception { // take item from top of stack
        return stackArray[top--]; // access item, decrement top
    }

    @Override
    public boolean pilaBuida() { // true if stack is empty
        return (top == -1);
    }

    @Override
    public boolean pilaPlena() { // true if stack is full

        return (top == maxSize-1);
    }

    @Override
    public Object consultaCap() throws Exception {// peek at top of stack
        return stackArray[top];
    }


    @Override
    public void buidar() {
        while(!pilaBuida())
            try {
                desempilar();
            } catch (Exception e) { }

    }


    @Override
    public Pila clone() {
        PilaEnll copia = new PilaEnll(maxSize);

        try {
            for ( Object item: stackArray) {
                if ( item != null )
                    copia.empilar(item);
            }
        } catch (Exception e) {}

        return copia;
    }
}
