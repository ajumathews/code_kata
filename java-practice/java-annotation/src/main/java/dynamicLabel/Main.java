package dynamicLabel;

import dynamicLabel.dao.DynamicLabelDao;
import dynamicLabel.document.DrugDocument;
import dynamicLabel.extractor.DocumentColumnExtractor;

import java.util.Map;

public class Main {


    public static void main(String[] args) {

        DocumentColumnExtractor documentColumnExtractor = new DocumentColumnExtractor();

        Map<String, String> labels = documentColumnExtractor.extractDomainLabels(DrugDocument.class);
        Map<String, ? extends DynamicLabelDao> dynamicLabels = documentColumnExtractor.extractDynamicLabels(DrugDocument.class);
        Map<String, ? extends DynamicLabelDao> dynamicLabelsWithQuery = documentColumnExtractor.extractDynamicLabelsWithQuery(DrugDocument.class);


        for (String key : dynamicLabelsWithQuery.keySet()) {
                System.out.println(key + ":" + dynamicLabelsWithQuery.get(key).getLabelValue());
        }


/*
        for (String key : labels.keySet()) {
            if (dynamicLabels.get(key) != null) {
                System.out.println(key + ":" + dynamicLabels.get(key).getLabelValue());
            } else {
                System.out.println(key + ":" + labels.get(key));
            }
        }
*/


    }


}
