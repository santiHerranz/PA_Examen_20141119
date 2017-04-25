package cat.ipoma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by santi on 26/04/2017.
 */
class MotTest {

    Mot m1;

    @BeforeEach
    void setUp() {

        Diccionari dic = new Diccionari();

        Mot m2 = Paraula(dic,"casa","","","casa","home");
        m1 = Paraula(dic,"cotxe","","","cotxe","car");
        Paraula(dic,"cuina","","","cuina","kitchen");
        Paraula(dic,"cistell","","","cistell","basket");
        Paraula(dic,"camara","","","camara","camera");
        Paraula(dic,"cortina","","","cortina","curtain");

    }

    private static Mot Paraula(Diccionari dic, String nom, String def, String def2, String trad1, String trad2) {
        Mot m1 = new Mot(nom, (new String[]{def, def2}) );
        try {
            m1.addTraduccio(trad1,Main.IDIOMA_1);
            m1.addTraduccio(trad2,Main.IDIOMA_2);
            dic.AfegirMot(m1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m1;
    }

    @Test
    void addTraduccio() {

        try {
            m1.addTraduccio("carro", Main.IDIOMA_2);

            Assertions.assertEquals("cotxe (cotxe,carro)", m1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void remTraduccio() {

        try {
            m1.remTraduccio("car",Main.IDIOMA_2);
            Assertions.assertEquals("cotxe (cotxe)", m1.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}