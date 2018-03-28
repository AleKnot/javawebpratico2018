package br.com.pet.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@Controller
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 10,  // 10 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15, // 15 MB
        location            = "C:\\Uploads\\"
)
public class PosterController{
	
// http://www.pablocantero.com/blog/2010/09/29/upload-com-spring-mvc/
	
	
	private static final long serialVersionUID = 1L;
	
	
	@GetMapping("api/servlets/movies/posters")
	public void getPosters() {
		
		System.out.println("Entrou no Posters");
	}
	
	
	@PostMapping("api/servlets/movies/posters")
	public String postPosters(@RequestPart("image") MultipartFile multipartFile) {
		
		
		String name = multipartFile.getOriginalFilename();
		String folder = "C:\\Uploads\\";
		
		System.out.println(name);
		System.out.println("Entrou no POST Posters");
		
		byte[] byteArr;
		try {
			byteArr = multipartFile.getBytes();
			InputStream inputStream = new ByteArrayInputStream(byteArr);
			
			//InputStream initialStream = FileUtils.openInputStream(new File(folder+name));
			
			File targetFile = new File(folder+name);
						
			FileUtils.copyInputStreamToFile(inputStream, targetFile);
			
			return "redirect:/picture.html";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/picture.html";
		
		
		
		
		
		
	}
	

}