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
        User user = new User("Alla1", "pelle1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Switch views to Start", user);
    }

    //Done
    @Test
    public void FJ002_JU2(){
        User user = new User("Allan1239111", "pelle1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Switch views to Start", user);
    }

    //Done
    @Test
    public void FJ002_JU3(){
        User user = new User("All1", "pelle1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Username is too short", user);
    }

    //Done
    @Test
    public void FJ002_JU4(){
        User user = new User("Allan1239111a", "pelle1", "pellekanot@gmail.com");
        String output = login.registerCheck(user);
        assertEquals("Username is too long", user);
    }
}
