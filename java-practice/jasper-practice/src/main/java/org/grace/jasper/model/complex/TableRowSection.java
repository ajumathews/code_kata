package org.grace.jasper.model.complex;

import java.util.List;

/**
 * Created by U6018134 on 6/20/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class TableRowSection {

    private List<TableRow> tableRows;

    public TableRowSection(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }

    public List<TableRow> getTableRows() {
        return tableRows;
    }

    public void setTableRows(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }
}

