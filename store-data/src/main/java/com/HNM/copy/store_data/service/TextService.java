package com.HNM.copy.store_data.service;

import java.util.List;

import com.HNM.copy.store_data.dto.Text;



public interface TextService {
	public Text createText(Text text);
	
	public List<Text> getAllText();

	public String deleteText(Long id);

	public Text getText(Long id);

	
}
