package project.museum.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.museum.User;

public class LoginController {

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
