import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable{

    private Data data;

    public Sender(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        String packets[] = generateNumbersArr();

        for (String packet : packets) {
            data.send(packet);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public String[] generateNumbersArr(){
        String[] numbers = {"1","2","3","4","5","6","7","8","9","10"};

        List<String> numbersList = Arrays.asList(numbers);
        Collections.shuffle(numbersList);

        String[] num = numbersList.toArray(new String[numbersList.size()]);

        return num;

    }
}
