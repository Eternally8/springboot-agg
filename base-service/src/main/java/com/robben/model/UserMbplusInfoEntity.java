package com.robben.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.robben.model.jsonChage.DescInfoVoListTypeHandler;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "user_mbplus_info",autoResultMap = true)
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
     *  注意:@TableName中的autoResultMap == true,否则对象的属性无法查询获取
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private DescInfoVo descInfo;

    /**
     * 对于list对象需要重写typeHandler,如果不想重写.可以将List<T> 变成一个对象向下面descInfoListVo属性也可以
     */
    @TableField(typeHandler = DescInfoVoListTypeHandler.class)
    private List<DescInfoVo> descInfoList;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private DescInfoListVo descInfoListVo;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
