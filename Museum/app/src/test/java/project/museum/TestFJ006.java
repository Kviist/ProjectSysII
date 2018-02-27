package project.museum;

import org.junit.Before;
import org.junit.Test;
import project.museum.view.Login;

import static org.junit.Assert.assertEquals;

public class TestFJ006 {

    Login login;

    @Before
    public void setup(){
        login =  new Login();
    }

    @Test
    public void FJ006_JU1() {
        boolean sound = login.toggleSound();
        assertEquals(sound, false);
    }
    @Test
    public void FJ006_JU2(){
        login.toggleSound();
        boolean sound = login.toggleSound();
        assertEquals(sound, true);
    }
}
