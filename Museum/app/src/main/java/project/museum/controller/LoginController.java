package project.museum.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that handles the logic and communication for a login
 */
public class LoginController {
    private String name = "KallePuling", pass = "kAl1kAl1";

    /**
     * Controlls if the user and password matches user in database
     * @param username - username login
     * @param password - password for the user
     * @return - true if user exists otherwise false
     */
    public boolean loginCheck(String username, String password) {
        return (username.equals(name) && password.equals(pass));
    }

    /**
     * method for checking if the wished upon registration is valid
     * @param username - wished upon username
     * @param password - wished upon password
     * @param email - users email
     * @return - String with poteltial error or sucess
     */
    public String registerCheck(String username, String password, String email){
        Pattern p;
        Matcher m;

        p = Pattern.compile("[a-zA-Z0-9]{5,12}");
        m = p.matcher(username);
        if(!m.matches()){
            if(username.length() < 5){
                return "Username is too short";
            }else if(username.length() > 12){
                return "Username is too long";
            }
        }

        p = Pattern.compile("([a-zA-Z0-9!-*]*[A-Z]+[a-zA-Z0-9!-*]*){4,8}");
        m = p.matcher(password);

        if(!m.matches()){
            if(password.length() < 4){
                return "Password is too short";
            }else if(password.length() > 8){
                return "Password is too long";
            }else {
                p = Pattern.compile("[A-Z]+");
                boolean bigChar = false;
                for (int i = 0; i < password.length(); i++) {
                    m = p.matcher("" + password.charAt(i));
                    if (m.matches()) {
                        bigChar = true;
                        break;
                    }
                }

                if (!bigChar) {
                    return "Password is missing uppercase";
                }
            }
        }

        p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        m = p.matcher(email);

        if(!m.matches()){
            return "Invalid email";
        }

        return "Switch views to Start";
    }
}
