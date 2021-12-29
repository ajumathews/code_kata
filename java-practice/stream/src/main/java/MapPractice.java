import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapPractice {

    public static void main(String[] args) {
        List<FilterGroupConfig> filterGroupConfigs = new ArrayList<>();
        filterGroupConfigs.add(getFilterGroupConfig("date", "dealStartDate"));
        filterGroupConfigs.add(getFilterGroupConfig("default", "indications"));
        filterGroupConfigs.add(getFilterGroupConfig("phase", "dealPhaseStart"));

        SearchFilterConfig config = extractNew("dealPhaseStart", FilterType.FLAT, filterGroupConfigs);
        System.out.println(config.getSearchFilterKey());

    }


    private static SearchFilterConfig extract(String filterKey, FilterType filterType, List<FilterGroupConfig> filterGroupConfigs) {

        return filterGroupConfigs.stream()
                .map(group -> group.getFilterConfigs().stream()
                        .filter(filter -> filterKey.equals(filter.getFilterKey()))
                        .map(filter -> filter.getSearchFilterConfigs().stream()
                                .filter(sFilter -> sFilter.getFilterType().equals(filterType))
                                .findAny()
                                .orElse(null)
                        ).findAny()
                        .orElse(null))
                .findAny()
                .orElse(null);

    }

    private static SearchFilterConfig extractNew(String filterKey, FilterType filterType, List<FilterGroupConfig> filterGroupConfigs) {

          return filterGroupConfigs.stream()
                    .flatMap(filterGroupConfig -> filterGroupConfig.getFilterConfigs().stream()).
                    filter(filter -> filterKey.equals(filter.getFilterKey()))
                    .map(filter -> filter.getSearchFilterConfigs().stream()
                            .filter(sFilter -> sFilter.getFilterType().equals(filterType))
                            .findAny()
                            .orElse(null)
                    ).findAny()
                    .orElse(null);

    }

    private static FilterGroupConfig getFilterGroupConfig(String groupName , String filterName){
        SearchFilterConfig searchFilterConfig = new SearchFilterConfig();
        searchFilterConfig.setFilterType(FilterType.FLAT);
        searchFilterConfig.setSearchFilterKey(filterName);

        FilterConfig filterConfig = new FilterConfig();
        List<SearchFilterConfig> searchFilterConfigs = new ArrayList<>();
        searchFilterConfigs.add(searchFilterConfig);
        filterConfig.setSearchFilterConfigs(searchFilterConfigs);
        filterConfig.setFilterKey(filterName);

        FilterGroupConfig g1 = new FilterGroupConfig();
        List<FilterConfig> filterConfigs = new ArrayList<>();
        filterConfigs.add(filterConfig);
        g1.setFilterConfigs(filterConfigs);
        g1.setFilterGroupKey(groupName);
        g1.setMessageKey(groupName);

        return g1;
    }
}


 class FilterGroupConfig {
    private String filterGroupKey;
    private String messageKey;
    private List<FilterConfig> filterConfigs;

    public String getFilterGroupKey() {
        return filterGroupKey;
    }

    public void setFilterGroupKey(String filterGroupKey) {
        this.filterGroupKey = filterGroupKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public List<FilterConfig> getFilterConfigs() {
        return filterConfigs;
    }

    public void setFilterConfigs(List<FilterConfig> filterConfigs) {
        this.filterConfigs = filterConfigs;
    }
}



 class FilterConfig {

    /**
     * This is a unique filter key used for UI and API
     */
    private String filterKey;
    private String messageKey;
    private boolean searchable;
    private boolean filterable;
    private List<SearchFilterConfig> searchFilterConfigs;

    public String getFilterKey() {
        return filterKey;
    }

    public void setFilterKey(String filterKey) {
        this.filterKey = filterKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }


    public boolean isFilterable() {
        return filterable;
    }

    public void setFilterable(boolean filterable) {
        this.filterable = filterable;
    }

    public List<SearchFilterConfig> getSearchFilterConfigs() {
        return searchFilterConfigs;
    }

    public void setSearchFilterConfigs(List<SearchFilterConfig> searchFilterConfigs) {
        this.searchFilterConfigs = searchFilterConfigs;
    }
}

class SearchFilterConfig {

    /**
     * There is no type to be sent in search request.
     * This type to be used internal to API to switch the filter
     * type.
     */
    private FilterType filterType;
    /**
     * This is filter key used in the search request
     */
    private String searchFilterKey;


    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getSearchFilterKey() {
        return searchFilterKey;
    }

    public void setSearchFilterKey(String searchFilterKey) {
        this.searchFilterKey = searchFilterKey;
    }
}

enum FilterType {
    FLAT("flat"),
    DATE("date"),
    LIST("list"),
    HIERARCHICAL("hierarchical"),
    BOOLEAN("boolean");

    FilterType() {}

    FilterType(String apiTypeValue) {
        this.apiTypeValue = apiTypeValue;
    }
    private String apiTypeValue;

    public static FilterType getByApiValue(String apiTypeValue) {
        if("flat".equalsIgnoreCase(apiTypeValue)) {
            return FLAT;
        }
        if("date".equalsIgnoreCase(apiTypeValue)) {
            return DATE;
        }
        if("list".equalsIgnoreCase(apiTypeValue)) {
            return LIST;
        }
        if("hierarchical".equalsIgnoreCase(apiTypeValue)) {
            return HIERARCHICAL;
        }
        if("boolean".equalsIgnoreCase(apiTypeValue)) {
            return BOOLEAN;
        }
        return null;
    }
}
