package com.yihengyi.question.domain.application;

import com.yihengyi.question.domain.application.command.CreateQuestionCommand;
import com.yihengyi.question.domain.application.result.QuestionCreatedResult;
import com.yihengyi.question.domain.model.Question;
import com.yihengyi.question.domain.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author liucheng
 * @since 0.1 2022-03-27 8:22 PM
 **/
@Service
@Transactional
public class QuestionApplicationService {
    private final QuestionRepository questionRepository;

    public QuestionApplicationService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionCreatedResult createQuestion(CreateQuestionCommand command) {
        var question = new Question(command.questionerId(), command.title(), command.detail());
        var savedQuestion = questionRepository.save(question);
        return new QuestionCreatedResult(savedQuestion.getId());
    }
}
