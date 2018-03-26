package br.com.pet.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@MultipartConfig
public class PosterController {
	
// http://www.pablocantero.com/blog/2010/09/29/upload-com-spring-mvc/
	
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request) {
	  MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	  MultipartFile multipartFile = multipartRequest.getFile("file");
	  return "redirect:upload-success";
	}

}
