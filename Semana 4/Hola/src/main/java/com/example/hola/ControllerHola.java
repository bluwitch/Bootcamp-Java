
package com.example.hola;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerHola {

    @GetMapping("/hola/")
    public String mostrarHola() {
        return "hola"; 
    }
}


