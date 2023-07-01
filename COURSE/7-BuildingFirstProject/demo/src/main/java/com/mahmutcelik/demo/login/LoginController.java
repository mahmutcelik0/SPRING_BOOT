package com.mahmutcelik.demo.login;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;

@Controller
@RequestMapping("api/v1")
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(){
        return "loginPage";
    }

    @GetMapping("/loginParameter")
    public String getLogin(@RequestParam("name") String value){
        System.out.println("VALUE: "+ value); //SOUT USING IS NOT RECOMMENDED IN PRODUCTION CODE
        return "loginPage";
    }
    /*
    * http://localhost:8080/api/v1/loginParameter?name=MAHMUT
    * IT WILL PRINT OUT -> VALUE: MAHMUT
    * */

    @GetMapping("/loginParameterModelMap")
    public String getLoginModelMap(@RequestParam("name") String value, ModelMap model){
        model.put("name",value); // It recorded as key value -> key is name , value is value (from requestparam)
        return "loginPage";
    }

    private Logger logger = LoggerFactory.getLogger(getClass());
    //LOGGER IMPLEMENTATIONS MUST BE FROM SLF4J PACKAGE
    @GetMapping("/loginLoggerEx")
    public String getLoginLogger(@RequestParam("name") String value){
        logger.debug("REQUEST PARAM IS {}" ,value); // We can use curly braces insted of +

        logger.warn("LOGGING IN WARN LEVEL");
        logger.error("LOGGING IN ERROR LEVEL");


        return "loginPage";
    }


}
