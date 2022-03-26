package com.yihengyi.question.domain.repository;

import com.yihengyi.question.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liucheng
 * @since 0.1 2022-03-26 11:11 AM
 **/

public interface QuestionRepository extends JpaRepository<Question, String> {
}