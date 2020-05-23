/**
 * 
 */
package com.taotao.util;

import org.junit.Test;

/**
 * @author 盼望
 * @date 2019年5月13日上午11:12:35
 */
public class TestSecond {
	@Test
	public void testSecond(){
		for(int i = 0;i<10;i++) {
			long currentTimeMillis = System.currentTimeMillis();
			//long currentTimeMillis = System.nanoTime();
			System.out.println(currentTimeMillis);
		}
		
	}
}
