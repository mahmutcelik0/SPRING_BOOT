package com.mahmutcelik.demo.actualLogin;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController { //ActualLoginController in past

//    @RequestMapping("login")
//    public String loginPage(){
//        return "actualLoginPage";
//    }
    //ABOVE METHOD HANDLES BOTH POST AND GET METHODS
    //INITIALLY WE NEED TO USE GET METHOD TO SHOW LOGIN PAGE AND AFTER THAT
    //WE NEED TO USE POST METHOD TO SHOW IF ALL CORRECT THE WELCOME PAGE

        //BEFORE SPRING SECURITY
//    @GetMapping("login")
//    public String loginPage(){
//        return "actualLoginPage";
//    }
//
//    @Autowired
//    private AuthenticationService service;
//
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    @PostMapping("login")
//    public String afterLoginToWelcomePage(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap model){
//        if(service.isValid(name,password)){
//            model.put("name",name);
//            logger.debug(name);
//            return "welcomePage";
//        }
//        else{
//            model.put("error","INVALID AUTHENTICATION");
//            return "actualLoginPage";
//        }
//    }

    @GetMapping("/")
    public String getWelcomePage(ModelMap model){
        //model.put("name","MAHMUT"); //HARDCODED WAY -> WILL CHANGE

        model.put("name",getLoggedinUsername());
        return "welcomePage";

    }

    private String getLoggedinUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName(); //It returns username that has signed in
    }


}
