package com.retsapis.blogging_application.payloads;

import com.retsapis.blogging_application.entities.Category;
import com.retsapis.blogging_application.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;

    private String postTitle;

    private String postContent;

    private String postImageName;

    private Date addedDate;

    private Category category;

    private User user;

}
