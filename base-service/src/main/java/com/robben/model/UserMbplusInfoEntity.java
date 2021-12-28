package com.robben.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@TableName("user_mbplus_info")
public class UserMbplusInfoEntity {

    //默认不是自增,需要增加这个。也可以增加全局配置（mybatis-plus.global-config.db-config.id-type = AUTO）
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private boolean sex;
    private Integer age;
    private String workInfo;

    /**
     *  这个功能是MySQL5.7.8后增加的,在MySQL8.0中得到了大幅增强 https://blog.csdn.net/qq_38688267/article/details/107386138
     *  推荐使用MySQL 8.0.17版本
     *  更多的sql语法细节可参考 https://dev.mysql.com/doc/refman/8.0/en/json.html
     *  JSON 数据类型推荐使用在不经常更新的静态数据存储
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private DescInfoVo descInfo;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private List<DescInfoVo> descInfoArrary;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
