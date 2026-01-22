package test;

import impl.Film;
import impl.Filmarkiv2;
import impl.Sjanger;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Filmarkiv2Test {

    private Filmarkiv2 arkiv = new Filmarkiv2();
    private Film film1, film2, film3, film4, film5, film6;

    @Before
    public void setUp() {
        film1 = new Film(1,"HVl-studios", "Avatar", 2020, "E403", Sjanger.ADVENTURE);
        arkiv.leggTilFilm(film1);
        film2 = new Film(2,"Warner", "Iron man", 2021, "E402", Sjanger.ACTION);
        arkiv.leggTilFilm(film2);
        film3 = new Film(3,"AresHjem", "Pirates of the Caribbean", 2019, "E403", Sjanger.ADVENTURE);
        arkiv.leggTilFilm(film3);
        film4 = new Film(4,"Aretho", "Mr.Bean", 2002, "E405", Sjanger.HORROR);
        arkiv.leggTilFilm(film4);
        film5 = new Film(5,"HVl-studios", "Avatar 2", 2001, "E408", Sjanger.DRAMA);
        arkiv.leggTilFilm(film5);
        film6 = new Film(6,"Warner", "Ringens Herre", 1999, "E409", Sjanger.FANTASY);
        arkiv.leggTilFilm(film6);
    }

    @Test
    public void testFinnFilm() {
        assertEquals(film3, arkiv.finnFilm(3));
    }

    @Test
    public void testLeggTilFilm() {
        assertEquals(6, arkiv.antall());
        Film nyFilm = new Film(7, "Stan-Lee", "Hulk", 2010, "Marvel Studios", Sjanger.ACTION);
        arkiv.leggTilFilm(nyFilm);
        assertEquals(7, arkiv.antall());
    }

    @Test
    public void testSlettFilm() {
        assertEquals(6, arkiv.antall());
        arkiv.slettFilm(3);
        assertNull(arkiv.finnFilm(3));
        assertEquals(5, arkiv.antall());
    }

    @Test
    public void testSoekTittel() {
        Film[] test1 = arkiv.soekTittel("avatar");

        int treff = 0;
        for (Film i : test1) {
            if (i != null){
                treff++;
            }
        }
        assertEquals(2,treff);
    }

    @Test
    public void testSoekProdusent() {
        Film[] test1 = arkiv.soekProdusent("are");

        int treff = 0;
        for (Film i : test1) {
            if (i != null){
                treff++;
            }
        }
        assertEquals(2,treff);
    }

    @Test
    public void testAntallSjanger() {
        assertEquals(2, arkiv.antall(Sjanger.ADVENTURE));
        assertEquals(1, arkiv.antall(Sjanger.HORROR));
        Film nyFilm = new Film(7, "Stan-Lee", "Hulk", 2010, "Marvel Studios", Sjanger.ADVENTURE);
        arkiv.leggTilFilm(nyFilm);
        assertEquals(3, arkiv.antall(Sjanger.ADVENTURE));
    }

    @Test
    public void testAntall() {
        assertEquals(6,arkiv.antall());
        Film nyFilm = new Film(7, "Stan-Lee", "Hulk", 2010, "Marvel Studios", Sjanger.ADVENTURE);
        arkiv.leggTilFilm(nyFilm);
        assertEquals(7, arkiv.antall());
    }
}
