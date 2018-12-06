package com.example.demo2;

import com.example.demo2.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository  extends CrudRepository<Topic,Integer> {
}
