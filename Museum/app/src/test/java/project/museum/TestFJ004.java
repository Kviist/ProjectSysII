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
        User user = new User("Alla123", "pEl1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Switch views to Start", user);
    }

    //Done
    @Test
    public void FJ004_JU2(){
        User user = new User("Alla123", "pEl1pEl1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Switch views to Start", user);
    }

    //Done
    @Test
    public void FJ004_JU3(){
        User user = new User("Alla123", "peel1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Password is missing uppercase", user);
    }

    //Done
    @Test
    public void FJ004_JU4(){
        User user = new User("Alla123", "pE1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Password is too short", user);
    }

    //Done
    @Test
    public void FJ004_JU5() {
        User user = new User("Alla123", "pE1pe1pe1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Password is too long", user);
    }
}
