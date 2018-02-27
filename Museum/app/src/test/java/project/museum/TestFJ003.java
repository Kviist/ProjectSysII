package project.museum;

import org.junit.Before;
import org.junit.Test;
import project.museum.view.Login;

import static org.junit.Assert.assertEquals;

public class TestFJ003 {


    Login login;

    @Before
    public void setup(){
        login = new Login();
    }

    //Done
    @Test
    public void TestFJ003U1(){
        User user = new User("Greger33", "password", "greger.nilsson1@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Switch view to Start", output);
    }

    //Done
    @Test
    public void TestFJ003U2(){
        User user = new User("Greger33", "password","greger.nilssongmail.swedenland");
        String output = login.registerCheck(user);
        assertEquals("Invalid email",output);
    }


}
