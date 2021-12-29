/**
 * @projectName ddd-template
 * @title: package-info
 * @date 2021/12/29 11:47
 * @author fuzeqiang
 *
 * DDD : domain 领域层
 * 主要负责表达业务概念,业务状态信息和业务规则；是整个系统的核心层,几乎全部的业务逻辑会在该层实现。
 * 1. 实体（Entities）: 具有唯一标识的对象
 * 2. 值对象（Value Objects）： 无需标识的对象
 * 3. 领域对象（Domain Service）: 一些行为无法归类道实体对象或值对象的一些操作
 * 4. 聚合/聚合根（Aggregates, Aggregates Roots）
 * 5. 工厂（Factories）: 创建复杂对象，收藏创建细节
 * 6. 仓储（Repository）： 提供查找和持久化对象的方法
 *
 */
package com.zjuici.ddd.domain;