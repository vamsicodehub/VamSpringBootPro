package com.vamsi.sbs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamsi.sbs.model.ErrorResponse;
import com.vamsi.sbs.model.Topic;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "rest", tags = "Controller for Topic related API's")
@RestController
@RequestMapping("/rest")
public class TopicController {
	
	@ApiOperation(value = "Get All Topics" , response = Topic.class)
	@ApiResponses( value = {
			@ApiResponse(code = 200 , message = "SUCCESS" , response = String.class),
			@ApiResponse(code = 401 , message = "UNAUTHORIZED" , response = ErrorResponse.class),
			@ApiResponse(code = 403 , message = "FORBIDDEN" , response = ErrorResponse.class),
			@ApiResponse(code = 404 , message = "NOT FOUND")
		})
	@GetMapping(name = "/topics")
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		Topic topic = new Topic(1L,"Spring Boot","Spring Framework Explanation");
		topics.add(topic);
		
		topic = new Topic(2L,"Core Java","Core Java Explanation");
		topics.add(topic);
		return topics;
	}
	
	@ApiResponses( value = {
			@ApiResponse(code = 200 , message = "Success" , response = String.class),
			@ApiResponse(code = 401 , message = "Unauthorized" , response = ErrorResponse.class),
			@ApiResponse(code = 403 , message = "Forbidden" , response = ErrorResponse.class),
			@ApiResponse(code = 404 , message = "Not Found")
		})
	@ApiOperation(value = "Get Topic by passing Id" , response = Topic.class)
	@GetMapping(value = "/topic/{id}", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public Topic getTopic(@ApiParam(defaultValue = "1") @PathVariable String id)
	{
		List<Topic> topics = new ArrayList<>();
		Topic topic = new Topic(1L,"Spring Boot","Spring Framework Explanation");
		topics.add(topic);
		topic = new Topic(2L,"Core Java","Core Java Explanation");
		topics.add(topic);
		
		return topics.stream().filter(t -> t.getId().equals(Long.valueOf(id))).findFirst().get();
		
	}
	
	@PostMapping("/addTopic")
	public void addTopic(@RequestBody Topic topic)
	{
		
	}
	
	@PostMapping(value = "/attachTopic", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public Topic saveAndSend(HttpServletRequest httpServletRequest, Topic emailReq,
			@RequestParam("uploadedFile") MultipartFile uploadedFileRef
			) {
		System.out.println(uploadedFileRef.getName());
				return new Topic();
		
	}


}
