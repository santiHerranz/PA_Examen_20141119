package cat.ipoma;


public class AcbEnll implements Acb{

        private class NodeA{
            Mot inf; NodeA esq,dret;
            public NodeA(Mot m, NodeA e, NodeA d){inf=m;esq=e;dret=d;}


        /* TODO Exercici 6 Afegim a la classe NodeA*/
        public long qE(){
            long cont=1L;
            if (esq!=null) cont+=esq.qE();
            if (dret!=null) cont+=dret.qE();
            return cont;
        }
        public void inordre(){
            if (esq!=null) esq.inordre();
            System.out.println(inf);
            if (dret!=null) dret.inordre();
        }

        public String toString(){
            return data(1);
        }
        private String data(int level) {
            String s = "\n";
            for (int i=1; i<level;i++) s+="\t";
            s += inf.toString()+ "";
            if (esq!=null)
                s += "" + esq.data(level+1) +"";
            if (dret!=null)
                s += "" + dret.data(level+1) +"";
            s += "";
            return s +"";
        }

    } //fi classe privada

    private NodeA arrel;
    public AcbEnll(){arrel=null;}


    /* TODO Exercici 5 Afegim a la classe ACBEnll*/
    public Comparable donaElement(Comparable ele) throws Exception {
        boolean trobat = false;
        NodeA aux = arrel;
        //els mots a l’ACB estan ordenats alfabèticament, usem aquesta ordenació per la localització
        while (!trobat && aux!=null){
            if (aux.inf.MajorQue((Mot)ele)) aux=aux.esq;
            else if (aux.inf.MenorQue((Mot)ele))aux=aux.dret;
            else trobat=true;
        }
        if (!trobat)
            throw new Exception("No hi es");
        else
            return aux.inf;
    }

    /* TODO Exercici 6 Afegim a la classe AcbEnll*/
    public long quantsElements(){
        if (arrel==null) return 0L;
        else return arrel.qE();
    }
    public void inordre(){
        if (arrel!=null) arrel.inordre();
    }


    /* implementació de totes les operacions de la interfície*/

    @Override
    public void Inserir(Comparable e) throws Exception {
        this.arrel = inserirRecursiu(this.arrel, e);
    }

    private NodeA inserirRecursiu(NodeA a, Comparable e) throws Exception {
        if(a == null) {
            a = new NodeA((Mot)e,null,null);
        } else {
            if (a.inf.MajorQue(e))
                a.esq = inserirRecursiu(a.esq, e);
            if (a.inf.MenorQue(e)) {
                a.dret = inserirRecursiu(a.dret, e);
            }
        }
        return a;
    }

    @Override
    public void Esborrar(Comparable e) throws Exception {
        arrel = EsborrarRecursiu(arrel, e);
    }

    private NodeA EsborrarRecursiu(NodeA d, Comparable e) throws Exception {

        if (d==null) throw new Exception("l’element no hi és");
        else if (((Comparable)(d.inf)).MajorQue(e))
            d.esq=EsborrarRecursiu(d.esq,e);
        else if (((Comparable)d.inf).MenorQue(e))
            d.dret=EsborrarRecursiu(d.dret,e);
        else /*l'hem trobat*/
            if (d.esq!=null && d.dret!=null)
            { //sabem segur que d no es null
                d.inf= (Mot)BuscarMinim(d.dret);
                d.dret=EsborrarMinim(d.dret);
            }
            else if (d.esq==null && d.dret==null) d=null;
            else if (d.esq==null) d=d.dret;
            else d=d.esq;
        return d;
    }

    private static NodeA EsborrarMinim( NodeA d){
        if (d.esq==null) { d=d.dret; return d;}
        else {d.esq=EsborrarMinim(d.esq); return d;}
    }
    private static Comparable BuscarMinim(NodeA d){
        //la d no es nul.la
        while (d.esq!=null) d=d.esq;return (Comparable)d.inf;
    }

    @Override
    public boolean Membre(Comparable e) {
        return (MembreRecursiva(arrel, e));
    }

    private boolean MembreRecursiva(NodeA d, Comparable c) {
        if (d == null) return false;
        if (((Mot)c).getNom().equals(((Mot)d.inf))) return true;
        if (c.MenorQue(d.inf))
            return (MembreRecursiva(d.esq, c));
        else if (c.MajorQue(d.inf))
            return (MembreRecursiva(d.dret, c));
        return false;
    }

    @Override
    public Comparable Arrel() throws Exception {
        if (arrel == null) throw new Exception("Arbre buit");
        return this.arrel.inf;
    }

    @Override
    public Acb FillEsquerre() {
        if (arrel != null) {
            Acb v = new AcbEnll();
            ((AcbEnll) v).arrel.esq = arrel.esq;
            return v;
        } else return null;
    }
    @Override
    public Acb FillDret() {
        if (arrel != null) {
            Acb v = new AcbEnll();
            ((AcbEnll) v).arrel.dret = arrel.dret;
            return v;
        } else return null;
    }

    @Override
    public boolean ArbreBuit() {
        return this.arrel == null;
    }

    @Override
    public void Buidar() {
        arrel = null;
    }

    @Override
    public String toString(){
        return ((NodeA)arrel).toString();
    }

} //
// fi classe
