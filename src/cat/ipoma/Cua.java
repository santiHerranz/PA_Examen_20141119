package cat.ipoma;

/**
 * Created by santi on 25/04/2017.
 */
public interface Cua {

    void encuar(Object o) throws Exception;
    Object desencuar() throws Exception;
    boolean cuaBuida();
    boolean cuaPlena();
    Object consultaCap() throws Exception;
    void buidar();

}
