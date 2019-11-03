package edu.mum.ServiceA;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ServiceAController {

    @RequestMapping("/")
    public String greeting() {

        try {
            String hostname= InetAddress.getLocalHost().getHostName();
            return "Hello from service A on :"+hostname   ;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Hello from service A on : unknwon host"   ;
    }
}
