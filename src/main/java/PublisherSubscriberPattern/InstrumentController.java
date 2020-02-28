package PublisherSubscriberPattern;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import ing.stockmarket.Instruments;
import ing.stockmarket.Investor;
import ing.stockmarket.WriteInstrumentsInCSVFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InstrumentController {
        @GetMapping("/instruments")
        public List<Instruments> greeting() throws Exception {


            //Main.ApplicationFront.returnApplicationFront().start(new Stage());
            Investor subscriber1 = new Investor("John");
          /*  Investor subscriber2 = new Investor("Snow");
            Investor subscriber3 = new Investor("John");
            Investor subscriber4 = new Investor("Marian");
            Investor subscriber5 = new Investor("John");
            Investor subscriber6 = new Investor("Marian");
*/
            //Message message1 = new Message("Test");
          //  Message message = new Message("Transaction");

           // Event.stockMarketReference.subscribe("Transaction", subscriber1);
            /*Event.stockMarketReference.subscribe("Transaction", subscriber2);
            Event.stockMarketReference.subscribe("Transaction", subscriber3);
            Event.stockMarketReference.subscribe("Transaction", subscriber4);
            Event.stockMarketReference.subscribe("Test", subscriber5);
            Event.stockMarketReference.subscribe("Test", subscriber6);
            Event.stockMarketReference.subscribe("Transaction", subscriber6);
*/
           // Event.stockMarketReference.publish("Transaction", message);
            //Event.stockMarketReference.publish("Test", message1);

            return WriteInstrumentsInCSVFile.frontlistinstr;

        }
    }

