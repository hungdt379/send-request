package com.example.send_request;

import com.example.send_request.service.SendRequestService;
import com.example.send_request.worker.ExecuteWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SendRequestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SendRequestApplication.class, args);
    }

	private static final Logger logger = LoggerFactory.getLogger(SendRequestApplication.class);

	@Autowired
	SendRequestService sendRequestService;

    @Override
    public void run(String... args) {
		logger.info("[START]::SEND REQUEST");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10000000; i++) {
            executor.execute(new ExecuteWorker());
        }
		logger.info("[END  ]::SEND REQUEST");
    }
}
