package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public interface CuaDoble<E> {
    public void encuarDreta(E x);
    public void encuarEsquerra(E x);

    public E desencuarDreta() throws Exception;
    public E desencuarEsquerra() throws Exception;

    public E consultarDreta();
    public E consultarEsquerra();

    public boolean esBuida();

    public void buidar();
}
