package cat.ipoma;

/**
 * Created by santi on 26/04/2017.
 */
public class CuaDobleEnll<E> implements CuaDoble<E> {

    private class Node<E> {
        private Node<E> seg, ant;
        private E inf;
        public Node(E e) {
            this(e, null, null);
        }
        public Node(E e, Node<E> x, Node<E> y) {
            this.inf = e;
            this.seg = x;
            this.ant = y;
        }
    }
    private Node<E> esq, dret;

    public E eliminaElement(int pos, boolean esquerra) throws Exception {
        /* TODO
        si pos==1 esborrar el primer, si pos==2 esborrar el segon .... si pos==n el que
        ocupa la posició enèsima. El segon paràmetre indica si la localització
        d’aquesta posició s’ha de fer iniciant‐se des de l’esquerra (true al paràmetre) o
        des de la dreta (false al paràmetre) la doblecua esdevé amb un element menys, en cas
        de no existir l’element es llança una exception
        */
        if (this.esq==null || pos<=0) throw new Exception("No existeix l’element. La doble ");
        Node<E> aux; //tindrà la referència a l’element a esborrar
        int cont=1;
        if (esquerra == true){
             aux=esq;
            while(cont<pos && aux!=null){
                aux=aux.seg;
                cont++;
            }
        }
        else{
            aux=dret;
            while(cont<pos && aux!=null){
                aux=aux.ant;
                cont++;
            }
        }
        if (cont<pos)
            throw new Exception("No existeix");

        //aux apuntarà al que volem esborrar
        Node<E> auxA= aux.ant, auxS=aux.seg;
        if (auxA==null && auxS==null){
            //quedarà buida
            esq=dret=null;
        }
        else{
            if (esq==aux){
                esq=esq.seg;
                esq.ant=null;
            }
            else {
                if (aux==dret){
                    dret=dret.ant;
                    dret.seg=null;
                }
                else{ //cas general
                    auxA.seg=auxS;
                    auxS.ant=auxA;
                }
            }
        }
        return aux.inf;
    }

    public boolean equals(Object o) {
        /* TODO
        Són iguals si tenen el mateix número d’elements i aquests estan ubicats
        idènticament dins de la seqüència enllaçada o amb efecte mirall. Denoteu que no es
        disposa de cap atribut que indiqui la cardinalitat d’aquesta, tampoc es disposa del
        mètode compareTo. Es valorarà la eficiència de la implementació. No podeu afegir
        atributs. Amb un únic tractament s’ha de fer el demanat
        */

        if (! (o instanceof CuaDobleEnll))
            return false;

        CuaDoble<E> c=(CuaDoble<E>)o;
        boolean trobat=false;
        Node<E> aux1=esq;
        Node<E> aux2=((CuaDobleEnll)c).esq;
        while ( aux1!=null && aux2!= null && ! trobat) {
            trobat =! (aux1.inf.equals(aux2.inf));
            aux1=aux1.seg;
            aux2=aux2.seg;
        }

        if (aux1==null && aux2!=null || aux1!=null && aux2==null)
            return false;

        // tenen diferent cardinalitat
        if (trobat){
                aux1=esq;
                aux2=((CuaDobleEnll)c).dret;
                while ( aux1!=null && aux2!= null && ! trobat)
                    trobat=aux1.inf.equals(aux2.inf);
                aux1=aux1.seg; aux2=aux2.ant;
            }
        return !trobat && aux1==null && aux2==null;
    }




    @Override
    public void encuarDreta(E x) {
        new Node<E>(x, esq, dret);
    }

    @Override
    public void encuarEsquerra(E x) {

    }

    @Override
    public E desencuarDreta() throws Exception {
        return null;
    }

    @Override
    public E desencuarEsquerra() throws Exception {
        return null;
    }

    @Override
    public E consultarDreta() {
        return null;
    }

    @Override
    public E consultarEsquerra() {
        return null;
    }

    @Override
    public boolean esBuida() {
        return false;
    }

    @Override
    public void buidar() {

    }
}
