package com.Duane.dojo.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.dojo.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
//	List<Dojo> findByDojoContainsAllIgnoreCase(String search);

}
