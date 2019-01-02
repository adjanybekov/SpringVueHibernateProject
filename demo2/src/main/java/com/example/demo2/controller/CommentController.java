package com.example.demo2.controller;

import com.example.demo2.CommentRepository;
import com.example.demo2.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/comment/v1")
public class CommentController {
    @Autowired
    EntityManager em;

    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    static final String commentTableName = "comment";


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{topicId}"
    )
    public List<Comment> getCommentsByTopicId( @PathVariable("studentId") Long id){
        Query namedQuery = em.createNativeQuery("select * from " + commentTableName + " where topic_id = "+id );

        return namedQuery.getResultList();

    }

    @RequestMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    public void createTopic(@RequestBody Comment comment){
        //save comment relate with Topic
        commentRepository.save(comment);

    }
}
