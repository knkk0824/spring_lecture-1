package com.spring.utils;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(UploadFileUtils.class);

	// uploaded file icon 생성

	// uploadFile 저장
	public static String uploadFile(String uploadPath, String originalName,
			byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString().replace("-", "") + "_" + originalName;
		String savedPath = calcPath(uploadPath);

		File target = new File(uploadPath + savedPath, savedName); // 파일저장

		String formatName = originalName.substring(originalName
				.lastIndexOf(".") + 1);

		String uploadFileName = null;

		// 업로드 파일의 이미지 여부 확인
		if (MediaUtils.getMediaType(formatName) != null) {
			// 썸네일 형태로 보여주기
			uploadFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else {
			// 텍스트 형태로 보여주기
			uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		}

		return uploadFileName;
	}

	// 아이콘 형태
	public static String makeIcon(String uploadPath, String path,
			String fileName) {
		return null;
	}

	// 썸네일 형태
	public static String makeThumbnail(String uploadPath, String path,
			String fileName) {
		return null;
	}

	// upload folder 지정.
	public static String calcPath(String uploadPath) {
		return null;
	}
}
