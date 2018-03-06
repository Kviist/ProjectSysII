package project.museum;

import org.junit.*;
import project.museum.view.Login;
import static org.junit.Assert.assertEquals;

public class TestFJ007 {

    private Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    //Done
    @Test
    public void FJ007_JU1(){
        boolean output = login.loginCheck("KallePuling", "kAl1kAl1");
        assertEquals(true ,output);
    }

    //Done
    @Test
    public void FJ007_JU2(){
        boolean output = login.loginCheck("KallePuing", "kAl1kAl1");
        assertEquals(false ,output);
    }

    //Done
    @Test
    public void FJ007_JU3(){
        boolean output = login.loginCheck("KallePuling", "kAl1kAl11");
        assertEquals(false ,output);
    }
}
