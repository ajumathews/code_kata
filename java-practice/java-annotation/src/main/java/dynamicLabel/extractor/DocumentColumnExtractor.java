package dynamicLabel.extractor;

import dynamicLabel.annotation.DocumentColumn;
import dynamicLabel.annotation.DynamicLabel;
import dynamicLabel.annotation.DynamicLabelWithQuery;
import dynamicLabel.dao.DynamicLabelDao;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DocumentColumnExtractor {

    String jdbcTemplate;

    public Map<String, String> extractDomainLabels(Class clazz) {
        Map<String, String> labels = new HashMap<>();
        for (Field field : clazz.getFields()) {
            extractDomainLabelAnnotation(labels, field, field.getAnnotation(DocumentColumn.class));
        }
        return labels;
    }


    public void extractDomainLabelAnnotation(Map<String, String> labels, Field field, DocumentColumn annotation) {
        if (annotation != null) {
            labels.put(field.getName(), annotation.label());
        }
    }



    public Map<String, ? extends DynamicLabelDao> extractDynamicLabels(Class clazz) {
        Map<String, DynamicLabelDao> dynamicLabels = new HashMap<>();
        for (Field field : clazz.getFields()) {
            extractDynamicLabelAnnotation(dynamicLabels, field, field.getAnnotation(DynamicLabel.class));
        }
        return dynamicLabels;
    }

    private void extractDynamicLabelAnnotation(Map<String, DynamicLabelDao> dynamicLabels, Field field, DynamicLabel annotation) {
        if (annotation != null) {
            dynamicLabels.put(field.getName(), extractDynamicLabelData(annotation));
        }
    }

    private DynamicLabelDao extractDynamicLabelData( DynamicLabel annotation) {
        try {
            return annotation.dataSource().getConstructor(String.class,String.class).newInstance("",jdbcTemplate);
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }



    public Map<String, ? extends DynamicLabelDao> extractDynamicLabelsWithQuery(Class clazz) {
        Map<String, DynamicLabelDao> dynamicLabels = new HashMap<>();
        for (Field field : clazz.getFields()) {
            extractDynamicLabelWithQueryAnnotation(dynamicLabels, field, field.getAnnotation(DynamicLabelWithQuery.class));
        }
        return dynamicLabels;
    }

    private void extractDynamicLabelWithQueryAnnotation(Map<String, DynamicLabelDao> dynamicLabels, Field field, DynamicLabelWithQuery annotation) {
        if (annotation != null) {
            dynamicLabels.put(field.getName(), extractDynamicLabelWithQueryData(annotation));
        }
    }

    private DynamicLabelDao extractDynamicLabelWithQueryData( DynamicLabelWithQuery annotation) {
        try {
            return annotation.dataSource().getConstructor(String.class,String.class).newInstance(annotation.query(),jdbcTemplate);
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }

}
