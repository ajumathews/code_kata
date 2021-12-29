package feign;

import java.util.List;
import java.util.Map;

public interface DrugDbRetrieveService extends Service{

    @RequestLine("GET /cortellisdrugdbretrieveservice/salesforecast/chart/{foreCastType}/forecast/checkAvailability?drugId={drugId}")
    List<Map<String, String>> checkForecastChartAvailability(@Param("foreCastType") String foreCastType, @Param("drugId") String drugId);
}
