package com.Duane.dojo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojo")
public class Dojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Dojo name cannot be blank")
	private String name;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninjas> ninja;


	public Dojo() {}


	public Dojo(@NotEmpty(message = "Dojo name cannot be blank") String name, Date createdAt, Date updatedAt,
			List<Ninjas> ninja) {
		super();
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.ninja = ninja;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}


	public List<Ninjas> getNinja() {
		return ninja;
	}


	public void setNinja(List<Ninjas> ninja) {
		this.ninja = ninja;
	}

	
	


	
	
};
