package com.abc.repository;

import com.abc.model.AirportCodes;
import com.abc.model.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportCodesRepository extends CrudRepository<AirportCodes, String> {

}
