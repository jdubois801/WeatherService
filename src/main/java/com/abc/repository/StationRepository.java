package com.abc.repository;

import com.abc.model.Station;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends CrudRepository<Station, String> {
    List<Station> findByState(String state);
    List<Station> findByCity(String city);
}
