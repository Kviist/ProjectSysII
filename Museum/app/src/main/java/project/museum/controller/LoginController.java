package project.museum.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.museum.User;

public class LoginController {

    public String registerCheck(User user){
        Pattern p = Pattern.compile("[a-zA-Z0-9]{5,12}");
        Matcher m = p.matcher(user.getUserName());
        if(!m.matches()){
            if(user.getUserName().length() < 5){
                return "Username is too short";
            }else if(user.getUserName().length() > 12){
                return "Username is too long";
            }
        }
        return "Switch views to Start";
    }
}
