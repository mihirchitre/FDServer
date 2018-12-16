package com.mvc.diary.service;

import com.mvc.diary.models.DiaryEntry;

public interface DiaryEntryService {

	DiaryEntry findById(String id);
	DiaryEntry findByEmail (String email);
	void insertDiaryEntry(DiaryEntry diaryentry);
	void deleteDiaryEntry (String id);
	void updateDiaryEntry (DiaryEntry diaryentry);
	
}
