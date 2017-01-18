package com.interfaceco.validationtool.gsmparams.controller;

import java.nio.file.Files;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.interfaceco.validationtool.util.storage.StorageService;

@Controller
public class JobLauncherController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	private final StorageService storageService;
	
	private static final String JOB_PARAM = "job";

	@Autowired
	public JobLauncherController(StorageService storageService) {
		this.storageService = storageService;
	}

	@PostMapping("/file-upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpServletRequest request)
			throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException,
			JobParametersInvalidException {
		storageService.store(file);
		String fileName = file.getOriginalFilename();
		redirectAttributes.addFlashAttribute("message", "Successfully uploaded " + fileName + "!");
		
		JobParametersBuilder builder = extractParameters(request);
		
		builder.addString("fileName", fileName);
		builder.addDate("Date", new Date());
		
		jobLauncher.run(job, builder.toJobParameters());
		return "redirect:/welcome";
	}

	private JobParametersBuilder extractParameters(HttpServletRequest request) {
		JobParametersBuilder builder = new JobParametersBuilder();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			if (!JOB_PARAM.equals(paramName)) {
				builder.addString(paramName, request.getParameter(paramName));
			}
		}
		return builder;
	}

}
