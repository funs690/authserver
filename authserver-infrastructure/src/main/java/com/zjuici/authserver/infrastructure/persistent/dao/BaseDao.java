package com.zjuici.authserver.infrastructure.persistent.dao;

import com.zjuici.authserver.infrastructure.persistent.condition.PageCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fuzeqiang
 * @version 1.0
 * @date 2021/3/3 16:48
 */
public interface BaseDao<T>{

    /**
     * 根据查询条件获取列表信息
     * @param condition
     * @return
     */
    List<T> getListByCondition(@Param("condition") PageCondition condition);


    /**
     * 批量插入
     * @param list
     */
    void batchInsert(@Param("list") List<T> list);


    /**
     * 批量更新
     * @param list
     */
    void batchUpdate(@Param("list") List<T> list);


    /**
     * 批量删除
     * @param list
     */
    void batchDelete(@Param("list") List<String> list);

    /**
     * 查询数据量信息
     * @param condition
     * @return
     */
    int count(@Param("condition") PageCondition condition);

}
