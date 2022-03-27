package com.yihengyi.question.domain.repository;

import com.yihengyi.question.core.JpaRepositoryTest;
import com.yihengyi.question.domain.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;


@JpaRepositoryTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void repository_should_successfully_save_question() {
        var question = new Question("UID_00001", "A test title", "A test detail");
        var savedQuestion = questionRepository.save(question);
        assertThat(savedQuestion.getId(), is(notNullValue()));
        assertThat(savedQuestion.getQuestionerId(), equalTo(question.getQuestionerId()));
        assertThat(savedQuestion.getTitle(), equalTo(question.getTitle()));
        assertEquals(savedQuestion.getDetail(), question.getDetail());
    }

}
