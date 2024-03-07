package com.falling.pojo;

import java.time.LocalDateTime;

public class Comment {
    //id
    private Integer id;
    //帖子id
    private Integer postingId;
    //评论人id
    private Integer userId;
    //评论内容
    private String content;
    //发布时间
    private LocalDateTime publishDate;
    //状态码：1启用 2软删除
    private Integer status;
    //管理员id
    private Integer managerId;
}
