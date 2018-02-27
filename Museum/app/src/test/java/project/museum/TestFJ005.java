package project.museum;

import org.junit.Before;
import org.junit.Test;
import project.museum.view.Login;

import static org.junit.Assert.assertEquals;

public class TestFJ005 {

    Login login;

    @Before
    public void setup(){
        login = new Login();
    }
    @Test
    public void TestFJ005_JU1(){
        String output = login.registerCheck("Greger33", "password","passwordd", "Hejkonbejkon@gmail.com");
        assertEquals("Password doesnt match",output);
    }
    @Test
    public void TestFJ005_JU2(){
        String output = login.registerCheck("Greger33", "password", "password", "Hejkonbejkon@gmail.com");
        assertEquals("Switch views to start",output);
    }
}
