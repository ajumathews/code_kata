import java.io.IOException;
import java.text.ParseException;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import com.google.gson.JsonSerializer;
import org.openapitools.client.JSON;
import org.threeten.bp.OffsetDateTime;

public class SerializeJava8DateExample1 {
    public static void main(String args[]) throws ParseException, JsonProcessingException {

        // form LocalDateTime
        OffsetDateTime updatedDate = OffsetDateTime.now();
        // create an instance of Event by using data
        Event evt = new Event(updatedDate);

        // create an instance of ObjectMapper class

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ThreeTenModule());
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        byte[] jsonString = mapper.writeValueAsBytes(evt);
        //print jsonString
        System.out.println(new String(jsonString));

        JSON json = new JSON();
        System.out.println(json.serialize(evt));


    }
}
