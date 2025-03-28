package com.example.send_request;

import com.example.send_request.request.RegisterUserRequest;
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
	ExecuteWorker executeWorker;

    @Override
    public void run(String... args) {
		logger.info("[START]::SEND REQUEST");
        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(args[0]));
        for (int i = 1; i <= Integer.parseInt(args[1]); i++) {
            executor.execute(executeWorker);
        }
		logger.info("[END  ]::SEND REQUEST");
    }
}
