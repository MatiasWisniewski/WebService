package com.gA.gaAcademy.matiasw.webservices.webServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.matiasw.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.matiasw.webservices.webServices.service.TopicService;



@RestController
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@PostMapping("/topic")
	public Topic createTopic(@RequestBody Topic inputTopic) {
		Topic t = topicService.createTopic(inputTopic);
		return t;
	}
		
	@GetMapping("/topic")
	public List<Topic> getTopic(){
		List<Topic> lt = topicService.getTopics();
		return lt;
			
	}
	
	
	}

