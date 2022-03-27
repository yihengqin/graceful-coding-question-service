package com.yihengyi.rest;

import com.yihengyi.question.domain.application.QuestionApplicationService;
import com.yihengyi.question.domain.application.command.CreateQuestionCommand;
import com.yihengyi.rest.request.CreateQuestionRequest;
import com.yihengyi.rest.response.QuestionCreatedResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liucheng
 * @since 0.1 2022-03-27 8:40 PM
 **/
@RestController
@RequestMapping("/questions")
public class QuestionCommonRestController {

    private final QuestionApplicationService questionApplicationService;

    public QuestionCommonRestController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @PostMapping("/create-question")
    public QuestionCreatedResponse createQuestion(@RequestBody CreateQuestionRequest request) {
        var command = new CreateQuestionCommand(request.questionerId(), request.title(), request.detail());
        var result = questionApplicationService.createQuestion(command);
        return new QuestionCreatedResponse(result.questionId());
    }
}
