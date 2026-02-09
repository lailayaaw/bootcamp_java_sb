package io.laila.bootcamp_java_sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class BootcampJavaSbApplication implements CommandLineRunner {

	private final ApplicationComponent applicationComponent;
	private final ApplicationService applicationService;
	private final ExternalLibrary externalLibrary;
	private final ApplicationConfiguration applicationConfiguration;
	public final static Logger logger = LoggerFactory.getLogger(BootcampJavaSbApplication.class);
	private final AsyncService asyncService;

	@Autowired
	private UserService userService;
//	@Value("${data.user-pass}")
//	private String password;

	public BootcampJavaSbApplication(ApplicationComponent applicationComponent, ApplicationService applicationService, ExternalLibrary externalLibrary, ApplicationConfiguration applicationConfiguration, AsyncService asyncService) {
		this.applicationComponent = applicationComponent;
		this.applicationService = applicationService;
		this.externalLibrary = externalLibrary;
		this.applicationConfiguration = applicationConfiguration;
		this.asyncService = asyncService;
	}

	public static void main(String[] args) {

		SpringApplication.run(BootcampJavaSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("============ START ============");
//		logger.info(this.applicationComponent.getFormatCurrentTimeStamp());
//		this.applicationService.sendNotification("Hello from BootcampJavaSbApplication!");
//		logger.info("Library Name: " + this.externalLibrary.getLibraryName());
		logger.info("User Name: " + applicationConfiguration.getUserName());
		logger.info("Password: " + applicationConfiguration.getUserPassword());
//		this.asyncService.doMyLongTaskA("Laila");
//		this.asyncService.doMyLongTaskB("Rizki");
//		this.asyncService.doMyLongTaskC("Ujang");

//		logger.info("User ID 1: " + this.userService.findUser(1));
		Integer userId1 = 1;
		Integer userId2 = 2;

		logger.info("Finding the user");
		CompletableFuture<String> result1 = this.asyncService.findUserAsync(userId1);
		CompletableFuture<String> result2 = this.asyncService.findUserAsync(userId2);

		logger.info("Waiting result");
		CompletableFuture.allOf(result1).join();
		CompletableFuture.allOf(result2).join();

		logger.info("Result for ID: " + userId1 + " is " + result1.get());
		logger.info("Result for ID: " + userId2 + " is " + result2.get());
		logger.info("============ END ============");
		System.exit(0);
	}
}
