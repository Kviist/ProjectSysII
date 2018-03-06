package project.museum.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import project.museum.R;
import project.museum.RegisterFragment;
import project.museum.controller.LoginController;

import java.util.Locale;

public class Login extends AppCompatActivity {
    private String username, password;
    private Language language = Language.SV;
    private boolean sound = true;
    private LoginController controller = new LoginController();
    private RegisterFragment fragment;

    private enum Language {
        SV,
        EN
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragment = new RegisterFragment();
    }

    public void loginClick(View view) {
        EditText text = (EditText)findViewById(R.id.editTextName);
        username = text.getText().toString();
        text = (EditText)findViewById(R.id.editTextPassword);
        password = text.getText().toString();
        if (loginCheck(username, password)) {
            Intent intent = new Intent(this, Start.class);
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Username or password incorrect.", Toast.LENGTH_LONG).show();
            System.out.println("Username or password incorrect.");
        }
    }

    public void guestClick(View view) {
        Intent intent = new Intent(this, Start.class);
        intent.putExtra("username", "Guest");
        startActivity(intent);
    }

    public void registerClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(android.R.id.content, fragment, "register")
                .addToBackStack("register").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    public void registerSend(View view) {
        EditText text = (EditText)findViewById(R.id.editTextRegName);
        String u = text.getText().toString();
        text = (EditText)findViewById(R.id.editTextRegPass1);
        String p1 = text.getText().toString();
        text = (EditText)findViewById(R.id.editTextRegPass2);
        String p2 = text.getText().toString();
        text = (EditText)findViewById(R.id.editTextRegEmail);
        String e = text.getText().toString();

        String reg = registerCheck(u, p1, p2, e);
        if (reg.equals("Switch views to Start")) {
            Intent intent = new Intent(this, Start.class);
            intent.putExtra("username", u);
            startActivity(intent);
        } else {
            Toast.makeText(this, reg, Toast.LENGTH_LONG).show();
            System.out.println(reg);
        }
    }

    public boolean loginCheck(String username, String password) {
        return controller.loginCheck(username, password);
    }

    public String registerCheck(String username, String password1, String password2, String email) {

        if(!(password1.equals(password2))) {
            return "Password doesnt match";
        }

        return controller.registerCheck(username, password1, email);
    }

    public boolean toggleSound() {
        sound = !sound;
        return sound;
    }

    public String changeLanguage() {
        Locale locale;
        switch(language) {
            case SV:
                language = Language.EN;
                locale = new Locale("en_US");
                break;
            case EN:
                language = Language.SV;
                locale = new Locale("sv_SV");
                break;
            default:
                locale = new Locale("en_US");
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        return language.toString();
    }
}
