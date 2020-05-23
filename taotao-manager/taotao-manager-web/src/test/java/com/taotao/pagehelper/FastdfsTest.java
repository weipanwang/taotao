/**
 * 
 */
package com.taotao.pagehelper;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

/**
 * @author 盼望
 * @date 2019年5月8日下午4:27:51
 */
public class FastdfsTest {
	@Test
	public void testUpload()throws Exception{
//		1、把FastDFS提供的jar包添加到工程中
//		2、初始化全局配置。加载一个配置文件。
		ClientGlobal.init("C:\\Users\\Asa\\eclipse-workspace\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
//		3、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
//		4、创建一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
//		5、声明一个StorageServer对象，null。
		StorageServer storageServer = null;
//		6、获得StorageClient对象。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//		7、直接调用StorageClient对象方法上传文件即可。
		String str = "D:\\heyandan.jpg";
		String location = str.replace("\\", "/");
		String[] strings = storageClient.upload_file(location, "jpg", null);
		for (String string : strings) {
				System.out.println(string);
		}
	 }     

}