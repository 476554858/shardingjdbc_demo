package com.zjx.shardingjdbc_demo.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("t_udict")
public class Udict {

    @TableId
    private Long dictid;

    private String ustatus;

    private String uvalue;
}
