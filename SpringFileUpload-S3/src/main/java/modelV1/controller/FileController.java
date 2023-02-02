package modelV1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import static java.net.HttpURLConnection.HTTP_OK;
import modelV1.service.FileServiceImpl;

@RestController
public class FileController {
	
	@Autowired
	private FileServiceImpl fsi;
	
	@PostMapping("/upload")
	public String save(@RequestParam("file") MultipartFile file) {
		
		return fsi.saveFile(file);	
	}
	
//	@GetMapping("/getFile/{filename}")
//	public byte[] download(@PathVariable("filename") String filename) {
//		
//		return fsi.downloadFile(filename);
//		
//	}
	
	@GetMapping("download/{filename}") public ResponseEntity<byte[]> download(@PathVariable("filename") String filename){ 
		HttpHeaders headers=new HttpHeaders(); 
		headers.add("Content-type", MediaType.ALL_VALUE); 
		headers.add("Content-Disposition", "attachment; filename="+filename); 
		byte[] bytes = fsi.downloadFile(filename);
		return ResponseEntity.status(HTTP_OK).headers(headers).body(bytes); }


	
	@DeleteMapping("/delete/{filename}")
	public String deletefile(@PathVariable("filename") String filename) {
		return fsi.deleteFile(filename);
	}
	
	@GetMapping("/getAllfiles")
	public List<String>getAllfiles(){
		return fsi.getAllFiles();
	}
	
	

}
