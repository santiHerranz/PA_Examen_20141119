package cat.ipoma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by santi on 26/04/2017.
 */
class CuaDobleEnllTest {

    CuaDobleEnll<String> cua1;
    CuaDobleEnll<String> cua2;

    @BeforeEach
    void setUp() {
        cua1 = new CuaDobleEnll<String>();
        cua2 = new CuaDobleEnll<String>();

        cua1.encuarDreta("1");
        cua1.encuarDreta("2");
        cua1.encuarDreta("3");

        cua2.encuarDreta("3");
        cua2.encuarDreta("2");
        cua2.encuarDreta("1");
    }

    @Test
    void equals() {

        boolean result = cua1.equals(cua2);

        Assertions.assertEquals(true, result);
    }

}