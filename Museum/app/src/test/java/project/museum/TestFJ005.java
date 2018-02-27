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
        User user =  new User("Greger33", "password", "Hejkonbejkon@gmail.com");
        String output = login.registerCheck();
        assertEquals("Password doesnt match",output);
    }
    @Test
    public void TestFJ005_JU2(){
        User user =  new User("Greger33", "password", "Hejkonbejkon@gmail.com");
        String output = login.registerCheck();
        assertEquals("Switch views to start",output);
    }
}
