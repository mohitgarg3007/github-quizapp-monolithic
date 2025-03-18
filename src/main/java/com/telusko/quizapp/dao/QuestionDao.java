package com.telusko.quizapp.dao;


import com.telusko.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    @Query("SELECT q FROM Question q WHERE LOWER(q.category) = LOWER(:category)")
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    //@Query(value = "SELECT * FROM question q WHERE q.category = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numQ);
}
