package cat.ipoma;

/**
 * Created by santi on 25/04/2017.
 */
public class Mot implements Comparable{

    private class Node{
        String nom;Node seg;
        public Node(String nom){this(nom,null);}
        public Node(String nom, Node seg){
            this.nom=nom;this.seg=seg;
        }
    }
    private String nom;
    private Cua definicions; //emmagatzema objectes String
    private Node traduccions[ ]; //2 seqüències enllaçades lineals sense capçalera i no ordenades

    public Mot(String nom, String []definicions){
        /* TODO: Exercici 1*/

        this.nom=nom;
        this.definicions=new CuaEnll();
        for (int i=0; i<definicions.length; i++){
            try{this.definicions.encuar(definicions[i]);}catch(Exception e){}}
        traduccions=new Node[2];
        traduccions[0]=null;
        traduccions[1]=null;
    }
    public String getNom(){return nom;}

    public void addTraduccio(String mot, int quin) throws Exception{

        /* TODO: Exercici 2*/
        boolean trobat=false;
        Node aux=traduccions[quin];
        while (!trobat && aux!=null){
            if (aux.nom.equals(mot))trobat=true;
            else aux=aux.seg;
        }
        if (trobat) throw new Exception("Repetit");
        this.traduccions[quin]=new Node(mot, this.traduccions[quin]);
    }



    public void remTraduccio(String mot, int quin) throws Exception{
        /* TODO: Exercici 3*/
        if (this.traduccions[quin]==null) throw new Exception("No existeix");
        if(this.traduccions[quin].nom.equals(mot))
            this.traduccions[quin]=this.traduccions[quin].seg;
        else{
            boolean trobat=false; Node aux=this.traduccions[quin];
            while (!trobat && aux.seg!=null){
                if (aux.seg.nom.equals(mot)){
                    trobat=true;
                    aux.seg=aux.seg.seg;
                }
                else aux=aux.seg;
            }
            if (!trobat) throw new Exception("No existeix");
        }
    }
    public Cua getDefinicions(){return definicions;}

    public boolean MajorQue(Comparable c){
        return nom.compareTo(((Mot)c).nom)>0;
    }

    public boolean MenorQue(Comparable c){
        return nom.compareTo(((Mot)c).nom)<0;
    }


    @Override
    public String toString() {
        String s= "";
        s += nom ;
        s += " (";
        if (traduccions[0]!=null)
            s += traduccions[0].nom;
        if (traduccions[1]!=null)
            s += ","+ traduccions[1].nom;
        s += ")";
        return s;
    }
}
