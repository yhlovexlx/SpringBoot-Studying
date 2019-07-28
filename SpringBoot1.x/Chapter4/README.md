## 第四章：SpringBoot整合jdbcTemplate实现数据库访问

### 本章目标
1. 使用jdbcTemplate完成对数据库的简单访问
2. 掌握jdbcTemplate的一些方法的使用（query、queryForObject、queryForList），查询简单对象，集合，Map等。
3. 封装一个基础的RowMapper实现类
4. 使用Junit完成简单的单元测试

### 注意事项
1. SpringBoot添加jdbc支持和数据库驱动
2. jdbcTemplate的queryForObject和queryForList这两个方法的使用，不要误解。
3. Junit单元测试方法注解在不同的SpringBoot版本下不同。

