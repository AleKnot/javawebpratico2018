package br.com.pet.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;


public class PetsControllerFunctions {
	private PetsControllerFunctions() {}
	
	
	
	public static final void savePart(String path, Part part) {
		String name = part.getSubmittedFileName();
		File folder = new File(path);
		File file = new File(folder, name);
		try (InputStream input = part.getInputStream()) {
		    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static final ObjectMapper mapper = new ObjectMapper()
			   .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			   .registerModule(new ParameterNamesModule())
			   .registerModule(new Jdk8Module())
			   .registerModule(new JavaTimeModule());
	
	public static String toJSON(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			Logger.getAnonymousLogger().severe(e::getMessage);
			return "[]";
		}
	}
	
	
	public static final Predicate<? super Path> imageExtensionPredicate = p -> {
		List<String> extensions = Arrays.asList(".jpg",".gif","png");
		return extensions.stream().filter(e -> p.getFileName().toString().endsWith(e)).findFirst().isPresent();
	};
	
	
	
}
	
	
	
	
	
