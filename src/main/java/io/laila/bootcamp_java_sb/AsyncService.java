package io.laila.bootcamp_java_sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    private final static Logger logger = LoggerFactory.getLogger(AsyncService.class);
    private String userName;

    @Autowired
    private UserService userService;

    public CompletableFuture<String> findUserAsync(Integer userId) throws InterruptedException {
        String foundUserName = userService.findUser(userId);
        Thread.sleep(500);
        return CompletableFuture.completedFuture(foundUserName);
    }

    @Async
    public void doMyLongTaskA(String userName) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.info("Running My Long Task A " + i + " for user " + userName);
            Thread.sleep(500);
        }
    }

    @Async
    public void doMyLongTaskB(String userName) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.info("Running My Long Task B " + i + " for user " + userName);
            Thread.sleep(400);
        }
    }

    @Async
    public void doMyLongTaskC(String userName) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.info("Running My Long Task C " + i + " for user " + userName);
            Thread.sleep(500);
        }
    }
}
