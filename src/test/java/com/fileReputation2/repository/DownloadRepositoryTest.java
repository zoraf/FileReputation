package com.fileReputation2.repository;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fileReputation2.model.Download;
import com.fileReputation2.model.FileInfo;
import com.fileReputation2.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DownloadRepositoryTest {

	
	@Value("${file_rating.NoOfUser}")
	int NoOfUser;

	@Value("${file_rating.NoOfFileType}")
	int NoOfFileType;
	
	@Autowired
	FileInfoRepository fileInfoRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DownloadRepository downloadRepository;

	@Test
	public void testCreateDownloadFile() {

		long NoOfFiles = 500;
		int MaxNoDownload = 25;
		Random random = new Random();
		for (long i = 1; i <= NoOfFiles; i++) {
			
			FileInfo fileInfo = fileInfoRepository.getOne(i);
			long noOfDownload = (long) Math.ceil(MaxNoDownload * random.nextDouble());
			
			for (long j = 1; j <= noOfDownload; j++) {
				
				User user = userRepository.getOne( (long) Math.ceil( NoOfUser * random.nextDouble()) );
				Download download = new Download(null, fileInfo, user);
				downloadRepository.save(download);
				
			}

		}
	}

}
