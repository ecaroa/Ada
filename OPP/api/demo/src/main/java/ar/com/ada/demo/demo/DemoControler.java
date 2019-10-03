package ar.com.ada.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoControler
 */
@RestController // 
public class DemoControler {
    
    @GetMapping(value="/demo")
    public String getDemoTexto()
    {
        return "Desde springboot";
    }
}