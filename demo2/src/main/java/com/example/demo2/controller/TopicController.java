package com.example.demo2.controller;

import com.example.demo2.TopicRepository;
import com.example.demo2.model.Comment;
import com.example.demo2.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/topics/v1")
public class TopicController {

    @Autowired
    EntityManager em;
    private final TopicRepository topicRepository;

    static final String topicTableName = "topic";
    static final String commentTableName = "comment";

    @Autowired
    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Topic> getTopics(){
        Query namedQuery = em.createNativeQuery("select * from " + topicTableName);

        return namedQuery.getResultList();

    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{topicId}"
    )
    public List<Comment> getCommentsByTopicId(@PathVariable("topicId") Long id){
        Query namedQuery = em.createNativeQuery("select * from " + commentTableName + " where topic_id = "+id );

        return namedQuery.getResultList();

    }

    @RequestMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    public void createTopic(@RequestBody Topic topic){
        topicRepository.save(topic);

    }

}
