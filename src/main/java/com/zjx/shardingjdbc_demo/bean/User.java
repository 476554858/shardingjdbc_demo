package com.zjx.shardingjdbc_demo.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    @TableId
    private Long userId;

    private String username;

    private String ustatus;
}
