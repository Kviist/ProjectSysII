package project.museum;

import org.junit.*;
import project.museum.view.Login;
import static org.junit.Assert.assertEquals;

public class TestFJ001 {

    private Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    //Done
    @Test
    public void FJ001_JU1(){
        String output = login.changeLanguage();
        assertEquals("EN", output);
    }

    //Done
    @Test
    public void FJ001_JU2(){
        login.changeLanguage();
        String output = login.changeLanguage();
        assertEquals("SV", output);
    }
}
