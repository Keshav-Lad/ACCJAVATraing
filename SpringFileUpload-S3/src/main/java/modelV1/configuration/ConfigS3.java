package modelV1.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.finspacedata.model.AwsCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class ConfigS3 {
	
	@Value("${accesKey}")
	private String accessKey;
	@Value("${secretKey}")
	private String secretKey;
	@Value("${region}")
	private String region;
	
	@Bean
	public AmazonS3 S3() {
		AWSCredentials awsc=new BasicAWSCredentials(accessKey,secretKey);
		return AmazonS3ClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsc)).build();
	
	}
}
