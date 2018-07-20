package com.sca.basic;

import java.util.Date;

/**
 * Created by Serguei on 27/01/2017.
 */
public class QueryBuilder {

    private Date startDate;
    private Date endDate;

    public QueryBuilder startDate(Date date) {
        this.startDate = startDate;

        return this;
    }

    public QueryBuilder endDate(Date date) {
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
