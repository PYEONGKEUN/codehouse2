package com.itbuddy.codehouse.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UploadService implements IUploadService{

	private static final String SAVE_PATH = "/upload";
	private static final String PREFIX_URL = "/upload/";
	
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		try {
			// 파일 정보
			String originFilename = multipartFile.getOriginalFilename();
			String extName
				= originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();
			
			// 서버에서 저장 할 파일 이름
			String saveFileName = genSaveFileName(extName);
			
			System.out.println("originFilename : " + originFilename);
			System.out.println("extensionName : " + extName);
			System.out.println("size : " + size);
			System.out.println("saveFileName : " + saveFileName);
			
			writeFile(multipartFile, saveFileName);
			url = PREFIX_URL + saveFileName;
		}
		catch (Exception e) {
			e.printStackTrace();
			// 원래라면 RuntimeException 을 상속받은 예외가 처리되어야 하지만
			// 편의상 RuntimeException을 던진다.
			// throw new FileUploadException();	
			throw new RuntimeException(e);
		}
		return url;
	}
	
	
	// 현재 시간을 기준으로 파일 이름 생성
	
	@Override
	public String genSaveFileName(String extName) {
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;
		
		return fileName;
	}
	
	
	// 파일을 실제로 write 하는 메서드
	@Override
	public boolean writeFile(MultipartFile multipartFile, String saveFileName){
		boolean result = false;

		try {
			byte[] data = multipartFile.getBytes();
			FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			fos.write(data);
			fos.close();
		}catch (Exception e) {
			// TODO: handle exception
		}

		
		return result;
	}
	
	
	@Override
	public void profileUpload(String email, MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		try {
			
		
		PrintWriter out = response.getWriter();
		// 업로드할 폴더 경로
		String realFolder = request.getSession().getServletContext().getRealPath("profileUpload");
		UUID uuid = UUID.randomUUID();

		// 업로드할 파일 이름
		String org_filename = file.getOriginalFilename();
		String str_filename = uuid.toString() + org_filename;

		System.out.println("원본 파일명 : " + org_filename);
		System.out.println("저장할 파일명 : " + str_filename);

		String filepath = realFolder + "\\" + email + "\\" + str_filename;
		System.out.println("파일경로 : " + filepath);

		File f = new File(filepath);
		if (!f.exists()) {
			f.mkdirs();
		}
		file.transferTo(f);
		out.println("profileUpload/"+email+"/"+str_filename);
		out.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
			
		}
	}

	
}
