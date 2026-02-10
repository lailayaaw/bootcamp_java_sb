package io.laila.bootcamp_java_sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    // Banyak logger untuk testing multi file
    private static final Logger loggerA = LoggerFactory.getLogger("LOGGER_A");
    private static final Logger loggerB = LoggerFactory.getLogger("LOGGER_B");
    private static final Logger loggerC = LoggerFactory.getLogger("LOGGER_C");

    public void writeLogs(String threadName) {
        for (int i = 0; i < 6000; i++) {
            loggerA.info("[{}] Logger A message {}", threadName, i);
            loggerB.warn("[{}] Logger B message {}", threadName, i);
            loggerC.error("[{}] Logger C message {}", threadName, i);
        }
    }
}
