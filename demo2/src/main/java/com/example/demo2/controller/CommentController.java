package com.example.demo2.controller;

import com.example.demo2.CommentRepository;
import com.example.demo2.TopicRepository;
import com.example.demo2.dto.CommentDTO;
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
@RequestMapping("api/comment/v1")
public class CommentController {
    @Autowired
    EntityManager em;

    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, TopicRepository topicRepository) {
        this.commentRepository = commentRepository;
        this.topicRepository = topicRepository;
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
    public void createComment(@RequestBody CommentDTO commentDTO){
        //save comment relate with Topic
        Comment comment = new Comment();
        Topic topic = topicRepository.findById(commentDTO.getTopic_id()).get();
        comment.setTopic(topic);
        comment.setComment(commentDTO.getComment());
        commentRepository.save(comment);

    }
}
