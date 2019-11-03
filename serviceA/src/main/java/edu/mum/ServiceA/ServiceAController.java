package edu.mum.ServiceA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class ServiceAController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${KEY1}")
    private String key1;

    @Value("${NEXT_SERVICE}")
    private String nextService;


    //Read from secrets of k8s
    @Value("${SERVICE_API_KEY}")
    private String apiKey;

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

    @RequestMapping("/env")
    public String readConfigMap() {

        return "read from k8s config map:" + key1 + " : " + nextService +
                "Fetched Secrets! : "+apiKey;
    }

    @RequestMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }
}
