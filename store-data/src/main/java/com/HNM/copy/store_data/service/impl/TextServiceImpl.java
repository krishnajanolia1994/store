package com.HNM.copy.store_data.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HNM.copy.store_data.entity.Copy;
import com.HNM.copy.store_data.dto.Text;
import com.HNM.copy.store_data.entity.Translation;
import com.HNM.copy.store_data.repository.TransalationRepository;
import com.HNM.copy.store_data.service.TextService;

@Service
public class TextServiceImpl implements TextService{
	
	@Autowired
	private TransalationRepository transalationRepository;

	
	
	@Override
	public Text createText(Text text) {
		
		
		Translation translation = new Translation();
		List<Copy> copies = new ArrayList<Copy>();
		
		int j=0;
		
		
		String textSubstring = "";
		int order=1;
		for(int i=0; i<text.getText().length();) {
			if((i+4000)<=text.getText().length()) {
				j=i+4000;
			}else {
				j=text.getText().length();
			}
			
			textSubstring= text.getText().substring(i, j);
			Copy copy = new Copy();	
			copy.setTextOrder(order);
			order++;
			copy.setText(textSubstring);
			copy.setTranslation(translation);
			copies.add(copy);
			i=j;
		
		}
		translation.getCopies().addAll(copies);
		translation=transalationRepository.save(translation);

		
		String savedText="";
		
		savedText = appendSubstring(translation, savedText);
		
		System.out.println("size " +savedText.length());
		text.setText(savedText);
		text.setId(translation.getTranslationId());
		return text;
	}

	private String appendSubstring(Translation translation, String savedText) {
		
		List<Copy> copies = translation.getCopies().stream().
				sorted((a,b)-> a.getTextOrder()-b.getTextOrder()).collect(Collectors.toList());
		for(Copy copy: copies) {
			savedText+=copy.getText();
		}
		return savedText;
	}
	


	@Override
	public List<Text> getAllText() {
		
		
		List<Translation> translations = transalationRepository.findAll();
		List<Text> tests = new ArrayList<Text>();
		
		String savedText="";
		for(Translation translation : translations) {
			savedText="";
			savedText = appendSubstring(translation, savedText);
			Text text = new Text();
			text.setText(savedText);
			text.setId(translation.getTranslationId());
			tests.add(text);

		}
		
		
		return tests;
	}

	@Override
	public String deleteText(Long id) {
		Translation  translation = new Translation();
		translation.setTranslationId(id);
		transalationRepository.deleteById(id);
		String deleted="deleted the text";

		return deleted;
	}
	
	@Override
	public Text getText(Long id) {
		Text text = new Text();
		Translation translation =null;
		Optional<Translation> optionalTranslation = transalationRepository.findById(id);
		if(optionalTranslation.isPresent()) {
			translation= optionalTranslation.get();
			String savedText="";
			savedText=appendSubstring(translation, savedText);
			text.setId(translation.getTranslationId());
			text.setText(savedText);
		}
		return text;
	}

}
