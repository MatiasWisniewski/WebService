package com.gA.gaAcademy.matiasw.webservices.webServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.matiasw.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.matiasw.webservices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public Topic createTopic(Topic inputTopic) {

		topicRepository.save(inputTopic);

		Topic t = topicRepository.save(inputTopic);
		return t;
	}

	public List<Topic> getTopics() {
		List<Topic> list = topicRepository.findAll();
		return list;

	}
	
}
