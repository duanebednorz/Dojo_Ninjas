package com.Duane.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duane.dojo.models.Dojo;
import com.Duane.dojo.models.Ninjas;
import com.Duane.dojo.repositories.DojoRepository;
import com.Duane.dojo.repositories.NinjaRepository;

@Service
public class DojoNinjaService {

	private DojoRepository dojoRepo;
	private NinjaRepository ninjaRepo;

	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		super();
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}

	public Dojo create(Dojo toCreate) {
		return dojoRepo.save(toCreate);
	}

	public Ninjas create(Ninjas toCreate) {
		return ninjaRepo.save(toCreate);
	}

	public List<Dojo> getAllDojos() {
		return (List<Dojo>) dojoRepo.findAll();
	}

	public List<Ninjas> getAllNinjas() {
		return (List<Ninjas>) ninjaRepo.findAll();
	}


	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = this.dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public void deleteDojo(Long id) {
		this.dojoRepo.deleteById(id);
	}

	public void deleteNinja(Long id) {
		this.ninjaRepo.deleteById(id);
	}

//	public List<Dojo> searchBy(String dojo) {
//		return dojoRepo.findByDojoContainsAllIgnoreCase(dojo);
//	}

};
