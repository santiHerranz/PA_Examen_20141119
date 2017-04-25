package cat.ipoma;

public interface Acb {
    void Inserir (Comparable e) throws Exception;
    void Esborrar (Comparable e) throws Exception;
    boolean Membre (Comparable e);
    Comparable Arrel () throws Exception;
    Acb FillEsquerre ();
    Acb FillDret ();
    boolean ArbreBuit ();
    void Buidar();

    long quantsElements();
    void inordre();

} //fi interfície
