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
        boolean output = login.loginCheck("Kalle Puling", "kAl1kAl1");
        assertEquals(true ,output);
    }

    //Done
    @Test
    public void FJ007_JU2(){
        boolean output = login.loginCheck("Kalle Puing", "kAl1kAl1");
        assertEquals(false ,output);
    }
}
