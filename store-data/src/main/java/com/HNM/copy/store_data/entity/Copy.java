package com.HNM.copy.store_data.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "copy")
public class Copy {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long copyId;
	
	@Column(name = "text",columnDefinition = "VARCHAR(4000)")
	private String text;
	
	@Column(name = "text_order")
	private Integer textOrder;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "translation_id",nullable = false)
	private Translation translation;
	
	

	public Translation getTranslation() {
		return translation;
	}

	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

	public Long getCopyId() {
		return copyId;
	}

	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}

	public Integer getTextOrder() {
		return textOrder;
	}

	public void setTextOrder(Integer textOrder) {
		this.textOrder = textOrder;
	}


	
	
	
	
	
	

}
