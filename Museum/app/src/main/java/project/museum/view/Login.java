package project.museum.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import project.museum.R;
import project.museum.User;
import project.museum.controller.LoginController;

public class Login extends AppCompatActivity {
    private String username, password;
    private Language language;
    private boolean sound;
    private User newUser;
    private LoginController controller;

    private enum Language {
        SV,
        EN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public boolean login(String username, String password) {
        return false;
    }

    public String register() {
        return null;
    }


}
