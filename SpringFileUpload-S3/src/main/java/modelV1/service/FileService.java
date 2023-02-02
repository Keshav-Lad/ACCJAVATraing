package modelV1.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public String saveFile(MultipartFile file);
	
	public byte[] downloadFile(String filename);
	
	public String deleteFile(String filename);
	
	public List<String> getAllFiles();
}
