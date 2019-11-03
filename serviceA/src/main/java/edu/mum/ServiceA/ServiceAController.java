package edu.mum.ServiceA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class ServiceAController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${KEY1:#{null}}")
    private String key1;

    @Value("${NEXT_SERVICE:#{null}}")
    private String nextService;


    //Read from secrets of k8s
    @Value("${SERVICE_API_KEY:#{null}}")
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

        return "Read from k8s config map:" + key1 + " : " + nextService +
                "<====> Fetched Secrets! : "+apiKey;
    }

    @RequestMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }

    @RequestMapping("/next_instances")
    public List<ServiceInstance> nextServiceEndPoints() {
        return this.discoveryClient.getInstances(nextService);
    }
    @RequestMapping("/next")
    public String callNext() {

        StringBuffer buf=new StringBuffer();
        buf.append(this.greeting());
        buf.append("Calling >>>>>");

        final String uri = String.format("http://%s/", nextService);

        String result="UNABLE TO CALL";

        try{
            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
           e.printStackTrace();
        }
        finally {
            buf.append(result);
            return buf.toString();
        }


    }
}
