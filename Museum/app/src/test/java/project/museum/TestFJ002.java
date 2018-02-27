package project.museum;

import org.junit.*;
import project.museum.view.Login;
import static org.junit.Assert.assertEquals;

public class TestFJ002 {

    private Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    //Done
    @Test
    public void FJ002_JU1(){
        String output = login.registerCheck("Alla1", "pelle1","pelle1", "pellekanot@gmail.com");
        assertEquals("Switch views to Start", output);
    }

    //Done
    @Test
    public void FJ002_JU2(){
        String output = login.registerCheck("Allan1239111", "pelle1", "pelle1", "pellekanot@gmail.com");
        assertEquals("Switch views to Start", output);
    }

    //Done
    @Test
    public void FJ002_JU3(){
        String output = login.registerCheck("All1", "pelle1","pelle1", "pellekanot@gmail.com");
        assertEquals("Username is too short", output);
    }

    //Done
    @Test
    public void FJ002_JU4(){
        String output = login.registerCheck("Allan1239111a", "pelle1","pelle1", "pellekanot@gmail.com");
        assertEquals("Username is too long", output);
    }
}
