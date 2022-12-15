import java.io.IOException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Main {

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    }
}
