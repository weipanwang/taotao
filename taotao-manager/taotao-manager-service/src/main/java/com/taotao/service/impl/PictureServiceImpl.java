/**
 * 
 */
package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.com.pojo.PictureResult;
import com.taotao.service.PictureService;
import com.taotao.utils.FastDFSClient;

/**
 * @author 盼望
 * @date 2019年5月9日下午2:48:24
 */
@Service
public class PictureServiceImpl  implements PictureService{

	/* (non-Javadoc)
	 * @see com.taotao.service.PictureService#uploadPic(org.springframework.web.multipart.MultipartFile)
	 */
	@Value("${IMAGE_SERVER_BASE_URL}")
	private String IMAGE_SERVER_BASE_URL;
	
	@Override
	public PictureResult uploadPic(MultipartFile PicFile) {
		PictureResult result = new PictureResult();
		//判断图片是否为空
		if (PicFile.isEmpty()) {
			result.setError(1);
			result.setMessage("图片为空");
			return result;
		}
		//上传到图片服务器
		try {
			//取图片扩展名
			String originalFilename = PicFile.getOriginalFilename();
			//取扩展名不要“.”
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			//FastDFSClient client = new FastDFSClient("C:\\Users\\Asa\\eclipse-workspace\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
			FastDFSClient client = new FastDFSClient("classpath:properties/client.conf");
			String url = client.uploadFile(PicFile.getBytes(), extName);
			//拼接url
			url = IMAGE_SERVER_BASE_URL+url;
			//把url响应给客户端
			result.setError(0);
			result.setUrl(url);
		} catch (Exception e) {
			e.printStackTrace();
			result.setError(1);
			result.setMessage("图片上传失败了");
		}
		return result;
	}

}
