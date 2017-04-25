package cat.ipoma;

import java.util.Stack;

/**
 * Created by santi on 25/04/2017.
 */
public class PilaEnll implements Pila {

    private Stack<Object> pila = new Stack<Object>();
    public static final int CAP=1000;

    public PilaEnll(){

    }

    @Override
    public void empilar(Object o) throws Exception {
        pila.push(o);
    }

    @Override
    public Object desempilar() throws Exception {
        return pila.pop();
    }

    @Override
    public boolean pilaBuida() {
        return pila.isEmpty();
    }

    @Override
    public boolean pilaPlena() {
        return false;
    }

    @Override
    public Object consultaCap() throws Exception {
        return null;
    }

    @Override
    public void buidar() {
        pila.empty();
    }
}
