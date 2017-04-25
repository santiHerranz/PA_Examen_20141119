package cat.ipoma;

/**
 * Created by santi on 25/04/2017.
 */
public class CuaEnll implements Cua {

    private class Node {
        private Object inf;
        private Node seg;

        Node(Object data){
            this.inf = data;
        }
    }

    // adreça al node final de la cua
    private Node fi;

    public CuaEnll(){
        super();
        if(!cuaBuida()) buidar();
        this.fi = null;
    }

    @Override
    public void encuar(Object value) throws Exception {
        Node node = new Node(value);

        // si la cua es buida
        if(fi == null){
            this.fi = node;
            this.fi.seg = node; //Referencia circular
        } else {
            node.seg = this.fi.seg;
            this.fi.seg = node;
            this.fi = node;
        }
    }

    @Override
    public Object desencuar() throws Exception {
        if(cuaBuida() == true) throw new Exception("La cua està buida");

        // treure el cap (el node següent al fi)
        Node cap = this.fi.seg;
        Object value = cap.inf;

        // el cap és el fi (nomès hi ha un element)
        if(this.fi.equals(cap))
            this.fi = null;
        else
            this.fi.seg = cap.seg;

        return value;
    }

    @Override
    public boolean cuaBuida() {
        return (this.fi == null);
    }

    @Override
    public boolean cuaPlena() {
        return false;
    }

    @Override
    public Object consultaCap() throws Exception {
        return null;
    }

    @Override
    public void buidar() {
        while(!cuaBuida()) {
            try {
                desencuar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Cua clone() {
        CuaEnll copia = new CuaEnll();

        if(!cuaBuida()) {
            Node cap = this.fi.seg;
            Node item = cap;
            try {
                copia.encuar(item.inf);
            } catch (Exception e) { }
            item = item.seg;
            while(!item.equals(cap)){
                try {
                    copia.encuar(item.inf);
                } catch (Exception e) { }
                item = item.seg;
            }
        }
        return copia;
    }

}
