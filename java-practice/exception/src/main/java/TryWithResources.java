import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TryWithResources {

    public void readFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("dsds")))
        {
            //code to read file

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}