package com.HNM.copy.store_data.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "translation")
public class Translation {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "translation_Id")
	private Long translationId;
	
	
	@OneToMany(cascade =  CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "translation")
	private List<Copy> copies = new ArrayList<Copy>();

	

	public List<Copy> getCopies() {
		return copies;
	}

	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public Long getTranslationId() {
		return translationId;
	}

	public void setTranslationId(Long translationId) {
		this.translationId = translationId;
	}
	
	
	
	
}
