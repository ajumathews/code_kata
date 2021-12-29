package org.grace.jasper.model.complex;

import java.util.List;

/**
 * Created by U6018134 on 6/21/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class TableHeaderSection {

    private List<TableHeader> tableHeaders;

    public TableHeaderSection(List<TableHeader> tableHeaders) {
        this.tableHeaders = tableHeaders;
    }

    public List<TableHeader> getTableHeaders() {
        return tableHeaders;
    }

    public void setTableHeaders(List<TableHeader> tableHeaders) {
        this.tableHeaders = tableHeaders;
    }
}

