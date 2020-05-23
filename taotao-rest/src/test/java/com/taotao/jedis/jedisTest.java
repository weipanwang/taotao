/**
 * 
 */
package com.taotao.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.rest.component.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @author 盼望
 * @date 2019年7月17日下午6:18:43
 */

public class jedisTest {
	//单机版测试
	@Test
	public void JedisTestSingle() throws Exception{
		
		Jedis jedis = new Jedis("192.168.44.134",6379);
		jedis.set("test", "hello jedis");
		String string = jedis.get("test");
		System.out.println(string);
		jedis.close();
		
	}
	//连接池
	@Test
	public void JedisTestPool() throws Exception{
		
		JedisPool jedisPool = new JedisPool("192.168.44.134", 6379);
		
		Jedis Jedis = jedisPool.getResource();
		
		Jedis.set("test", "1");
		
		String string = Jedis.get("test");
		System.out.println(string);
		Jedis.close();
		//系统关闭时关闭jedisPool
		jedisPool.close();
	}
	
	
	//连接集群
	@Test
	public void JedisTestCluster() throws Exception{
		
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.44.133", 6379));
		nodes.add(new HostAndPort("192.168.44.133", 6380));
		nodes.add(new HostAndPort("192.168.44.133", 6381));
		nodes.add(new HostAndPort("192.168.44.133", 6382));
		nodes.add(new HostAndPort("192.168.44.133", 6383));
		nodes.add(new HostAndPort("192.168.44.133", 6384));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		
		jedisCluster.set("name", "admin");
		String name = jedisCluster.get("name");
		System.out.println(name);
		

		try {
			jedisCluster.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testJedisClientSpring() throws Exception {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		//jedisClient操作redis
		jedisClient.set("cliet1", "1000");
		String string = jedisClient.get("cliet1");
		System.out.println(string);
	}
}
