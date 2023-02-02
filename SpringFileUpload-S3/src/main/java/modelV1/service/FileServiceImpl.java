package modelV1.service;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.amazonaws.services.s3.model.PutObjectResult;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;


@Service
public class FileServiceImpl implements FileService {

	@Value("${bucketName}")
	private String bucketName;
	public final AmazonS3 s3;
	
	public FileServiceImpl(AmazonS3 s3) {
		this.s3=s3;
	}
	private File convertFile(MultipartFile file) throws IOException {
		File convertFile=new File(file.getOriginalFilename());
		FileOutputStream fout=new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return convertFile;
		
	}
	@Override
	public String saveFile(MultipartFile file) {
		String originalFilename=file.getOriginalFilename();
		
		try {
			File cfile = convertFile(file);
			PutObjectResult putresult=s3.putObject(bucketName,originalFilename,cfile);
			return putresult.getContentMd5();
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return originalFilename;
	}

	@Override
	public byte[] downloadFile(String filename){
		com.amazonaws.services.s3.model.S3Object object=s3.getObject(bucketName,filename);
		byte[] ans = null;
		S3ObjectInputStream is=object.getObjectContent();
	    try {
	    	ans= IOUtils.toByteArray(is);
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	    return ans;
	    
	}

	@Override
	public String deleteFile(String filename) {
		
		s3.deleteObject(bucketName,filename);
		return "file Deleted";
	}

	@Override
	public List<String> getAllFiles() {
		ListObjectsV2Result listobjectresult=s3.listObjectsV2(bucketName);
		 return listobjectresult.getObjectSummaries().stream().map(o->o.getKey()).collect(Collectors.toList());
	}

 
}
