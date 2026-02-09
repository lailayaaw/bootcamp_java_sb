package io.laila.bootcamp_java_sb;

import org.springframework.stereotype.Component;

@Component
public class ApplicationComponent {
    public String getFormatCurrentTimeStamp() {
        return "[COMPONENT] Current Timestamp: " + java.time.LocalDateTime.now();
    }
}
