import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Sender send = new Sender();

        for(String rslt : send.generateNumbersArr()){
            System.out.println(rslt);
        }*/

        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();

    }
}
