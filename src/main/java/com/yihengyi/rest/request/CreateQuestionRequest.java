package com.yihengyi.rest.request;

public record CreateQuestionRequest(
        String questionerId,
        String title,
        String detail
) {
}
