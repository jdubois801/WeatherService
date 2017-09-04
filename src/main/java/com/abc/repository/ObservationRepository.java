package com.abc.repository;

import com.abc.model.Observation;
import com.abc.model.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends CrudRepository<Observation, String> {

}
