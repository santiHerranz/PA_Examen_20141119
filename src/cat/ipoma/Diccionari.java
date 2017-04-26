package cat.ipoma;

/**
 * Created by santi on 24/04/2017.
 */
public class Diccionari {

    private Acb totsMots[];

    public Diccionari(){
        totsMots=new AcbEnll[26];
        for (int i=0; i<26; i++) totsMots[i]=new AcbEnll();
    }
    private static int donaPosicio(char car){
        /*  retorna l'índex de la posició en la
            taula totsMots que referencia a l’arbre que emmagatzema als mots que
            comencen pel caràcter car */
        return car-'a';
    }
    private static char donaCaracter(int pos){
        /*retorna el caràcter d’inici dels mots
            emmagatzemats en l’arbre Diccionari.Acb referenciat per la posició de la taula totsMots de
            índex pos */
        return (char)((int)'a'+pos);
    }
    public void AfegirMot(Mot mot) throws Exception {
        /* TODO Exercici 4*/
        totsMots[Diccionari.donaPosicio(mot.getNom().charAt(0))].Inserir(mot);
    }
    public void EsborrarMot(Mot mot) throws Exception{
        /* TODO Exercici 4*/
        totsMots[Diccionari.donaPosicio(mot.getNom().charAt(0))].Esborrar(mot);
    }
    public Pila cercarDefinicions(String paraula) throws Exception{
        /* TODO Exercici 5*/

        AcbEnll m=(AcbEnll)(totsMots[Diccionari.donaPosicio(paraula.charAt(0))]);
        Cua c =((Mot)(m.donaElement(new Mot(paraula,null)))).getDefinicions();
        Pila p=new PilaEnll(100);
        Cua aux=(Cua)(((CuaEnll)c).clone());
        //imprescindible ja que el mètode retorna una referència a l’original

        while (!aux.cuaBuida()){
            p.empilar(aux.desencuar());
        }
        return p;

    }
    public void maximMots(){
        /* TODO Exercici 6*/

        long quants=totsMots[0].quantsElements();
        int quin=0;
        for (int i=1; i<26; i++){
            long quantsAux= totsMots[i].quantsElements();
            if (quants<quantsAux){
                quants=quantsAux;
                quin=i;
            }
        }
        if (quants!=0)
            totsMots[quin].inordre();

    }

    @Override
    public String toString(){
        for (int i=0; i<26; i++) {
            String s = "";
            long quantsAux= totsMots[i].quantsElements();
            if (quantsAux>0) {
                s += ((AcbEnll)totsMots[i]).toString();
                System.out.println("***"+ (char)((int)'a'+i) +":"+ s);
            }
        }
        return "";
    }
}
