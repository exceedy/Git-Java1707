package com.situ.student.conteoller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class UploadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、创建磁盘文件项工厂：DisjFileItemFactory:一些和配置相关的设置（缓存大小）
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//单位是字节
		factory.setSizeThreshold(1024 * 1024);
		String tempPath = getServletContext().getRealPath("temp");
		factory.setRepository(new File(tempPath));
		
		
		//ServltFileUpload:文件上传的核心类
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		//设置上传文件名的编码方式
		servletFileUpload.setHeaderEncoding("utf-8");
		
		//判断这个表单是不是文件上传的表单
		if (servletFileUpload.isMultipartContent(req)) {
			List<FileItem> list = null;
			try {
				list = servletFileUpload.parseRequest(req);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			if (list != null) {
				for (FileItem fileItem : list) {
					//判断是不是普通的表单项
					if (fileItem.isFormField()) {
						String fildName = fileItem.getFieldName();
						String fildValue = fileItem.getString("utf-8");
						System.out.println(fildName + fildValue);
					} else {
						String fileName = fileItem.getName();
						String uploadPath = getServletContext().getRealPath("upload");
						InputStream inputStream = fileItem.getInputStream();
						System.out.println(uploadPath + "/" + fileName);
						 OutputStream outputStream = new FileOutputStream(uploadPath + "/" + fileName);
						IOUtils.copy(inputStream, outputStream);
						outputStream.close();
						inputStream.close();
						
					}
						
				}
			}
		}
	}
}
