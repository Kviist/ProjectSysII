package project.museum.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import project.museum.AboutFragment;
import project.museum.R;
import project.museum.RegisterFragment;
import project.museum.controller.LoginController;

import java.util.Locale;

/**
 * View-class for the login/register part of the system.
 */
public class Login extends AppCompatActivity {
    private String username, password;
    private Language language = Language.SV;
    private boolean sound = true;
    private LoginController controller = new LoginController();
    private RegisterFragment registerFragment;
    private AboutFragment aboutFragment;

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
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.changeLanguage:
                changeLanguage(menuItem);
                return true;
            case R.id.toggleSound:
                toggleSound(menuItem);
                return true;
            case R.id.about:
                about();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerFragment = new RegisterFragment();
        aboutFragment = new AboutFragment();
    }

    /**
     * Method that is called when the user clicks on the login-button.
     * @param view
     */
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

    /**
     * Method that is called when the user clicks on the guest-button.
     * @param view
     */
    public void guestClick(View view) {
        Intent intent = new Intent(this, Start.class);
        intent.putExtra("username", "Guest");
        startActivity(intent);
    }

    /**
     * Method that is called when the user clicks on the register-button. Sends the user to register-view
     * @param view
     */
    public void registerClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(android.R.id.content, registerFragment, "register")
                .addToBackStack("register").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    /**
     * Sends a request to register a new user in the database.
     * @param view
     */
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

    /**
     * Checks if the username and password exists in the database and is correct.
     * @param username the username
     * @param password the password for the user
     * @return true if login was correct, else false
     */
    public boolean loginCheck(String username, String password) {
        return controller.loginCheck(username, password);
    }

    /**
     *
     * @param username the desired username
     * @param password1 the desired password
     * @param password2 needs to match password1
     * @param email the email for the user
     * @return String with potential error or success
     */
    public String registerCheck(String username, String password1, String password2, String email) {

        if(!(password1.equals(password2))) {
            return "Password doesnt match";
        }

        return controller.registerCheck(username, password1, email);
    }

    /**
     * Toggles the sound on or off
     * @param menuItem
     * @return true if sound was toggled on, false if toggled off
     */
    public boolean toggleSound(MenuItem menuItem) {
        Drawable myDrawable;
        if(sound) {
            myDrawable = getResources().getDrawable(R.drawable.volume_mute); // The ID of your drawable.
            Toast.makeText(this, "Sound Off", Toast.LENGTH_SHORT).show();
        } else {
            myDrawable = getResources().getDrawable(R.drawable.volume_high); // The ID of your drawable.
            Toast.makeText(this, "Sound On", Toast.LENGTH_SHORT).show();
        }
        sound = !sound;
        menuItem.setIcon(myDrawable);
        return sound;
    }

    /**
     * Changes the language between Swedish and English
     * @param menuItem
     * @return the language selected
     */
    public String changeLanguage(MenuItem menuItem) {
        Drawable myDrawable;
        switch(language) {
            case SV:
                language = Language.EN;
                myDrawable = getResources().getDrawable(R.drawable.if_flag_sweden2x_748117);
                Toast.makeText(this, "English", Toast.LENGTH_SHORT).show();
                break;
            case EN:
                language = Language.SV;
                myDrawable = getResources().getDrawable(R.drawable.if_flag_united_kingdom_748024);
                Toast.makeText(this, "Svenska", Toast.LENGTH_SHORT).show();
                break;
            default:
                language = Language.EN;
                myDrawable = getResources().getDrawable(R.drawable.if_flag_sweden2x_748117);
                Toast.makeText(this, "default", Toast.LENGTH_SHORT).show();
        }
        Locale locale = new Locale(language.toString());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        menuItem.setIcon(myDrawable);
        setContentView(R.layout.activity_login);
        return language.toString();
    }

    /**
     * Sends the user to about-view
     */
    public void about() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(android.R.id.content, aboutFragment, "about")
                .addToBackStack("about").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }
}
