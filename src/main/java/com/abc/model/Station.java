package com.abc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Station {

    @Id
    private long Id;
}
