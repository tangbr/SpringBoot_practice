package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate ;

	@Autowired
	DataSource dataSource;

	@Autowired
	UserMapper userMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;


	@Test
	void contextLoads() {

var a = jdbcTemplate.queryForObject("select count(*) from t_user",Long.class);
		log.info("记录总数： {}",a);
	//	jdbcTemplate.queryForList("select * from t_user",)

		log.info("数据源信息：   {}", dataSource.getClass());
	}
	@Test
	void testUserMapper(){
		User user = userMapper.selectById(1L);
		log.info("用户信息：  {}",user);
	}


//	@Test
//	void testRedis(){
//        ValueOperations<String, String> operations = RedisTemplate.opsForValue();
//
//		operations.set("hello","world");
//		String hello = operations.get("hello");
//		System.out.println(hello);
//
//		System.out.println(redisConnectionFactory.getClass());
//	}
}
