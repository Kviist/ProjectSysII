package project.museum;

import org.junit.Before;
import org.junit.*;
import project.museum.view.LoginActivity;
import static org.junit.Assert.assertEquals;

public class TestFJ001 {


    private Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    @Test
    public void FJ001_JU1(){
        String output = login.changeLanguage();
        assertEquals("Svenska", output);
    }

    @Test
    public void FJ001_JU2(){
        login.changeLanguage();
        String output = login.changeLanguge();
        assertEquals("Engelska", output);
    }
}
