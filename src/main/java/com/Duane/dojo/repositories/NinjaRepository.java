package com.Duane.dojo.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.Duane.dojo.models.Ninjas;

@Repository
public interface NinjaRepository  extends CrudRepository<Ninjas, Long> {

}
