package io.laila.bootcamp_java_sb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    public final static Logger logger = LoggerFactory.getLogger(BootcampJavaSbApplication.class);
    public void sendNotification(String message) {
        logger.info("[SERVICE] Sending Notification: " + message);
    }

    @PostConstruct
    public void infoAfterConstruction(){
        logger.info("[SERVICE] After Construction.");
    }

    @PreDestroy
    public void infoBeforeDestroy(){
        logger.info("[SERVICE] Before Destroy.");
    }
}
