package com.retsapis.blogging_application.servies;

import com.retsapis.blogging_application.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
