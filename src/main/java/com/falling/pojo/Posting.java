package com.falling.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Posting {
    //id
    private Integer id;
    //发帖人id
    private Integer userId;
    //标题
    private String title;
    //内容
    private String content;
    //排序
    private Integer ordination;
    //发布时间
    private LocalDateTime publishDate;
    //修改时间
    private LocalDateTime modifyDate;
    //点赞数
    private Integer likeNum;
    //收藏数
    private Integer collectionNum;
    //状态码：1启用 2软删除
    private Integer status;
    //管理员id
    private Integer managerId;
}
