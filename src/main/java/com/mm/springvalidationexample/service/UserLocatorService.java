package com.mm.springvalidationexample.service;

import com.mm.springvalidationexample.configuration.ExecutionTimeLog;
import com.mm.springvalidationexample.models.GhUser;
import com.mm.springvalidationexample.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

@Service
public class UserLocatorService {

    @Value("${userlocator.url}")
    private String locatorUrl;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserLocatorService.class);

    @ExecutionTimeLog
    @Async("threadPoolExecutor")
    public CompletableFuture<GhUser> getUserInfo(String userLoginId) throws InterruptedException {

        String currentTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        logger.info(String.format("Request Received at:%s", currentTime));
        String _locatorUrl = String.format(locatorUrl, userLoginId);
        ResponseEntity<GhUser> response = restTemplate.getForEntity(_locatorUrl, GhUser.class);
        Thread.sleep(1000L);

        return CompletableFuture.completedFuture(response.getBody());
    }
}
