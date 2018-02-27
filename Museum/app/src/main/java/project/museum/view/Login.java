package project.museum.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import project.museum.R;
import project.museum.RegisterFragment;
import project.museum.User;
import project.museum.controller.LoginController;

public class Login extends AppCompatActivity {
    private String username, password;
    private Language language = Language.SV;
    private boolean sound;
    private User newUser;
    private LoginController controller;
    private RegisterFragment fragment;

    private enum Language {
        SV,
        EN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragment = new RegisterFragment();
        controller = new LoginController();
    }

    public void loginClick(View view) {
        EditText text = (EditText)findViewById(R.id.editTextName);
        username = text.getText().toString();
        text = (EditText)findViewById(R.id.editTextPassword);
        password = text.getText().toString();
    }

    public void registerClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(android.R.id.content, fragment, "register")
                .addToBackStack("register").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

    }

    public boolean loginCheck(String username, String password) {
        return false;
    }

    public String registerCheck(User user) {

        return null;
    }

    public boolean toggleSound() {
        sound = !sound;
        return sound;
    }

    public String changeLanguage() {
        switch(language) {
            case SV:
                language = Language.EN;
                break;
            case EN:
                language = Language.SV;
                break;
        }
        return language.toString();
    }
}
