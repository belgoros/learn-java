package com.sca.basic;

import java.util.Date;

public class QueryBuilder {

    private Date startDate;
    private Date endDate;

    public QueryBuilder startDate(Date startDate) {
        this.startDate = startDate;

        return this;
    }

    public QueryBuilder endDate(Date endDate) {
        this.endDate = endDate;

        return this;
    }

    @Override
    public String toString() {
        return "QueryBuilder{" +
                "endDate=" + endDate +
                ", startDate=" + startDate +
                '}';
    }
}
