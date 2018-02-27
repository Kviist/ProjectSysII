package project.museum;

import org.junit.*;
import project.museum.view.Login;
import static org.junit.Assert.assertEquals;

public class TestFJ004 {

    private Login login;

    @Before
    public void setup() {
        login = new Login();
    }

    //Done
    @Test
    public void FJ004_JU1(){
        String output = login.registerCheck("Alla123", "pEl1","pEl1", "pellekanot@gmail.com");
        assertEquals("Switch views to Start", output);
    }

    //Done
    @Test
    public void FJ004_JU2(){
        String output = login.registerCheck("Alla123", "pEl1pEl1","pEl1pEl1", "pellekanot@gmail.com");
        assertEquals("Switch views to Start", output);
    }

    //Done
    @Test
    public void FJ004_JU3(){
        String output = login.registerCheck("Alla123", "peel1","peel1", "pellekanot@gmail.com");
        assertEquals("Password is missing uppercase", output);
    }

    //Done
    @Test
    public void FJ004_JU4(){
        String output = login.registerCheck("Alla123", "pE1", "pE1", "pellekanot@gmail.com");
        assertEquals("Password is too short", output);
    }

    //Done
    @Test
    public void FJ004_JU5() {
        String output = login.registerCheck("Alla123", "pE1pe1pe1", "pE1pe1pe1", "pellekanot@gmail.com");
        assertEquals("Password is too long", output);
    }
}
