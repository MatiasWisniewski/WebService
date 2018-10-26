package com.gA.gaAcademy.matiasw.webservices.webServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<Topic> getTopic() {
		List<Topic> lt = topicService.getTopics();
		return lt;

	}

	@GetMapping("/topic/{id}")
	public Topic getTopicById(@PathVariable int id) {
		Topic t = topicService.getTopicByID(id);
		return t;
	}

	@PutMapping("/topic/{id}")
	public Topic updateTopic(@PathVariable int id, @RequestBody Topic updateTopic) {
		Topic t = topicService.updateTopic(id, updateTopic);
		return t;
	}

	@DeleteMapping("/topic/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable int id) {

		int idTopicABorrar = topicService.deleteTopicFisc(id);

		String a = "el topic :" + idTopicABorrar + " fue borrado exitosamente";
		return new ResponseEntity<String>(a, HttpStatus.OK);
	}
	
	@DeleteMapping("/topic/l/{id}")
	public ResponseEntity<?> deleteLogicTopic(@PathVariable int id){
		int fueBorrado =topicService.deleteLogicTopic(id);
		if(fueBorrado > 0) {
			String msg = "el topic ID: " + fueBorrado + " fue borrado exitosamente";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("no se pudo borrar", HttpStatus.OK);
		
	}
	

}
