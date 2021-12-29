package org.grace.jasper.model.complex;

import java.util.List;
import java.util.Set;

/**
 * Created by U6018134 on 6/20/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class HtmlTable {

    private String tableTitle;
    private List<TableHeader> tableHeaders;
    private List<TableRow> tableRows;
    private String tableFooter;

    public List<TableRow> getTableRows() {
        return tableRows;
    }

    public void setTableRows(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }

    public List<TableHeader> getTableHeaders() {
        return tableHeaders;
    }

    public void setTableHeaders(List<TableHeader> tableHeaders) {
        this.tableHeaders = tableHeaders;
    }

    public String getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public String getTableFooter() {
        return tableFooter;
    }

    public void setTableFooter(String tableFooter) {
        this.tableFooter = tableFooter;
    }
}
