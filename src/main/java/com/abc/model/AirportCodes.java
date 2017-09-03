package com.abc.model;

import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.couchbase.core.mapping.Document;

@Document(expiry = 0)
public class AirportCodes {
    @Field
    AirportCode[] codes;

    public AirportCode[] getCodes() {
        return codes;
    }

    public void setCodes(AirportCode[] codes) {
        this.codes = codes;
    }
}
