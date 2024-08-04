package com.HNM.copy.store_data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HNM.copy.store_data.dto.Text;
import com.HNM.copy.store_data.service.TextService;


@RestController
@RequestMapping("/text")
public class TextController {
	
	@Autowired
	private TextService textService;
	
	@PostMapping
	@RequestMapping("/create")
	ResponseEntity<Text> createTeEntity(@RequestBody Text text){
		
		return new ResponseEntity<Text>(textService.createText(text), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	@RequestMapping("/all/text")
	ResponseEntity<List<Text>> getAllText(){
		
		return new ResponseEntity<List<Text>>(textService.getAllText(), HttpStatus.OK);
		
	}
	
	@DeleteMapping
	@RequestMapping("/delete/{id}")
	ResponseEntity<String> deleteText(@PathVariable("id") Long id){
		
		return new ResponseEntity<String>(textService.deleteText(id), HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping
	@RequestMapping("/get/{id}")
	ResponseEntity<Text> getTextById(@PathVariable("id") Long id){
		
		return new ResponseEntity<Text>(textService.getText(id), HttpStatus.OK);
		
	}
	
}
