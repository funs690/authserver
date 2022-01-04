package com.zjuici.authserver.infrastructure.persistent.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author fuzeqiang
 * @version 1.0
 * @date 2021/2/26 14:48
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PageCondition {

    /**
     * 页号
     */
    private Integer pageNo;

    /**
     * 分页大小
     */
    private Integer pageSize;


    /**
     * 排序方式， asc or desc
     */
    private String order;


    /**
     * 排序字段
     */
    private String sort;

}
