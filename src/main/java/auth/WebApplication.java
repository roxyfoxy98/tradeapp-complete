package auth;
import PublisherSubscriberPattern.Event;
import PublisherSubscriberPattern.Message;
import ing.stockmarket.Investor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication (scanBasePackages = { "PublisherSubscriberPattern", "auth"})
public class WebApplication {

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);

        Investor subscriber1 = new Investor("John");
        //Investor subscriber2 = new Investor("Snow");
        //Investor subscriber3 = new Investor("John");
        //Investor subscriber4 = new Investor("Marian");
        //Investor subscriber5 = new Investor("John");
        //Investor subscriber6 = new Investor("Marian");
    //aa, ai mysql work de fapt nu, am doar mysql :))))) Pune si mysql work bench plz :D
        Message message1 = new Message("Test");
        Message message = new Message("Transaction");

        Event.stockMarketReference.subscribe("AbonarealuiJohn", subscriber1);
        //Event.stockMarketReference.subscribe("Transaction", subscriber2);
        //Event.stockMarketReference.subscribe("Transaction", subscriber3);
        //Event.stockMarketReference.subscribe("Transaction", subscriber4);
        //Event.stockMarketReference.subscribe("Test", subscriber5);
        //Event.stockMarketReference.subscribe("Test", subscriber6);
        //Event.stockMarketReference.subscribe("Transaction", subscriber6);

        Event.stockMarketReference.publish("AbonarealuiJohn", message);
        //Event.stockMarketReference.publish("Test", message1);

    }
}
