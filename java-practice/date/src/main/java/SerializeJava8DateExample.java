import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;

public class SerializeJava8DateExample {
    private static StdSerializer<OffsetDateTime> offsetDateTimeSerializer(DateTimeFormatter formatter) {
        return new OffsetDateTimeSerializer(OffsetDateTimeSerializer.INSTANCE, false, formatter) {};
    }

    private static StdDeserializer<OffsetDateTime> offsetDateTimeDeserializer(DateTimeFormatter formatter) {
        return new InstantDeserializer<OffsetDateTime>(InstantDeserializer.OFFSET_DATE_TIME, formatter) {};
    }
    // main() method start
    public static void main(String args[]) throws ParseException, JsonProcessingException {

        // form LocalDateTime
        OffsetDateTime updatedDate = OffsetDateTime.now();
        // create an instance of Event by using data
        Event evt = new Event(updatedDate);

        // create an instance of ObjectMapper class
        ObjectMapper mapper = new ObjectMapper();

        // register JavaTimeModule and disable WRITE_DATES_AS_TIMESTAMPS
        // register JavaTimeModule and disable WRITE_DATES_AS_TIMESTAMPS
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        javaTimeModule.addSerializer(OffsetDateTime.class, offsetDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")));
        javaTimeModule.addDeserializer(OffsetDateTime.class, offsetDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")));

        mapper.registerModule(javaTimeModule);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        // serialize evt by using writeValueAsString() method
        String jsonString = mapper.writeValueAsString(evt);

        //print jsonString
        System.out.println(jsonString);


    }
}
