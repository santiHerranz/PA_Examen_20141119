package cat.ipoma;

public class Main {

    public final static int IDIOMA_1 = 0;
    public final static int IDIOMA_2 = 1;



    public static void main(String[] args) {
	 Diccionari dic = new Diccionari();

        Mot m2 = Paraula(dic,"casa","","","casa","home");
        Paraula(dic,"cotxe","","","cotxe","car");
        Paraula(dic,"cuina","","","cuina","kitchen");
        Paraula(dic,"cistell","","","cistell","basket");
        Mot m1 = Paraula(dic,"camara","","","camara","camera");
        Paraula(dic,"cortina","","","cortina","curtain");
        Paraula(dic,"central","","","central","central");

        System.out.print(dic.toString());

        try {

            dic.EsborrarMot(m1); // Eliminar cistell

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print(dic.toString());

    }


    private static Mot Paraula(Diccionari dic, String nom, String def, String def2, String trad1, String trad2) {
        Mot m1 = new Mot(nom, (new String[]{def, def2}) );
        try {
            m1.addTraduccio(trad1,IDIOMA_1);
            m1.addTraduccio(trad2,IDIOMA_2);
            dic.AfegirMot(m1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m1;
    }
}
