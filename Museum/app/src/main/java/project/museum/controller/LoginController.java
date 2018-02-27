package project.museum.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.museum.User;

public class LoginController {

    public String registerCheck(User user){
        Pattern p;
        Matcher m;

        p = Pattern.compile("[a-zA-Z0-9]{5,12}");
        m = p.matcher(user.getUserName());
        if(!m.matches()){
            if(user.getUserName().length() < 5){
                return "Username is too short";
            }else if(user.getUserName().length() > 12){
                return "Username is too long";
            }
        }

        p = Pattern.compile("([a-zA-Z0-9!-*]*[A-Z]+[a-zA-Z0-9!-*]*){4,8}");
        m = p.matcher(user.getPassword());

        if(!m.matches()){
            if(user.getPassword().length() < 4){
                return "Password is too short";
            }else if(user.getPassword().length() > 8){
                return "Password is too long";
            }else {
                p = Pattern.compile("[A-Z]+");
                boolean bigChar = false;
                for (int i = 0; i < user.getPassword().length(); i++) {
                    m = p.matcher("" + user.getPassword().charAt(i));
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
        m = p.matcher(user.getEmail());

        if(!m.matches()){
            return "Switch view to Start";
        }

        return "Switch views to Start";
    }
}
