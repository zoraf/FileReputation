package com.fileReputation2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileReputation2.model.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long>{

	List<FileInfo> findByFileType(String FileType);
}
