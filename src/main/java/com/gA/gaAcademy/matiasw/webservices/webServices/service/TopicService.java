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

	public Topic getTopicByID(int id) {
		Topic t = topicRepository.findById(id).get();
		return t;
	}

	public Topic updateTopic(int id, Topic updateTopic) {

		Topic toUpdateTopic = topicRepository.findById(id).get();
		if (updateTopic.getAuthor() > 0)
			toUpdateTopic.setAuthor(updateTopic.getAuthor());
		if (updateTopic.getTitle() != null)
			toUpdateTopic.setTitle(updateTopic.getTitle());
		if (updateTopic.getDescription() != null)
			toUpdateTopic.setDescription(updateTopic.getDescription());
		toUpdateTopic = topicRepository.save(toUpdateTopic);
		return toUpdateTopic;
	}

	public int deleteTopicFisc(int id) {

		topicRepository.deleteById(id);

		return id;
	}

	public int deleteLogicTopic(int id) {
			int toReturn = 0;
		Topic t = topicRepository.findById(id).get();
		if (!t.isDeleted())
		    {
			t.delete();
			toReturn = t.getId();
			topicRepository.save(t);
		    }
			return toReturn;
		}
		

	}

