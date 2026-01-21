package test;

import impl.Film;
import impl.Filmarkiv;
import impl.Sjanger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FilmarkivTest {

    Film film1 = new Film(1,"HVl-studios", "Avatar", 2020, "E403", Sjanger.ADVENTURE);
    Film film2 = new Film(2,"Warner", "Iron man", 2021, "E402", Sjanger.ACTION);
    Film film3 = new Film(3,"AresHjem", "Pirates of the Caribbean", 2019, "E403", Sjanger.ADVENTURE);
    Film film4 = new Film(4,"Aretho", "Mr.Bean", 2002, "E405", Sjanger.HORROR);
    Film film5 = new Film(5,"HVl-studios", "Harry Potter", 2001, "E408", Sjanger.DRAMA);
    Film film6 = new Film(6,"Warner", "Ringens Herre", 1999, "E409", Sjanger.FANTASY);

    @Test
    public void testFinnFilm(){
        Film film1 = new Film(1,"HVl-studios", "Avatar", 2020, "E403", Sjanger.ADVENTURE);
        Filmarkiv arkiv = new Filmarkiv(2);

        arkiv.leggTilFilm(film1);
        assertEquals(film1, arkiv.finnFilm(1));
        assertNull(arkiv.finnFilm(3));
    }
    @Test
    public void testLeggTilFilm(){
        Film film1 = new Film(1,"HVl-studios", "Avatar", 2020, "E403", Sjanger.ADVENTURE);
        Film film2 = new Film(2,"Warner", "Iron man", 2021, "E402", Sjanger.ACTION);
        Film film3 = new Film(3,"AresHjem", "Pirates of the Caribbean", 2019, "E403", Sjanger.ADVENTURE);

        Filmarkiv arkiv = new Filmarkiv(2);
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        assertEquals(3, arkiv.antall());
    }
    @Test
    public void testSlettFilm(){
        Film film1 = new Film(1,"HVl-studios", "Avatar", 2020, "E403", Sjanger.ADVENTURE);
        Film film2 = new Film(2,"Warner", "Iron man", 2021, "E402", Sjanger.ACTION);
        Film film3 = new Film(3,"AresHjem", "Pirates of the Caribbean", 2019, "E403", Sjanger.ADVENTURE);

        Filmarkiv arkiv = new Filmarkiv(4);
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        arkiv.slettFilm(1);

        assertNull(arkiv.finnFilm(1));
        assertEquals(2, arkiv.antall());

    }
    @Test
    public void testSoekTittel(){

        Film film1 = new Film(1,"HVl-studios", "Avatar", 2020, "E403", Sjanger.ADVENTURE);

        Filmarkiv arkiv = new Filmarkiv(4);
        arkiv.leggTilFilm(film1);


        assertEquals(arkiv, arkiv.soekTittel("avatar"));
    }

}
