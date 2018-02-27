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
        String output = login.registerCheck("Greger33", "password","password", "greger.nilsson1@gmail.com");
        assertEquals("Switch view to Start", output);
    }

    //Done
    @Test
    public void TestFJ003U2(){
        String output = login.registerCheck("Greger33", "password",  "password", "greger.nilssongmail.swedenland");
        assertEquals("Invalid email",output);
    }


}
