package com.yihengyi.question.domain.application.command;

public record CreateQuestionCommand(
        String questionerId,
        String title,
        String detail
) {
}
