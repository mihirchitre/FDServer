/**
 * 
 */
package com.mvc.diary.service;

import com.mvc.diary.models.DiaryEntry;
import com.mvc.diary.models.Person;

import org.springframework.stereotype.Service;

import com.mvc.diary.utils.Connection;

/**
 * @author mchi0002
 *
 */
@Service("diaryentryservice")
public class DiaryEntryServiceImp implements DiaryEntryService {

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.DiaryEntryService#findById(java.lang.String)
	 */
	@Override
	public DiaryEntry findById(String id) {
		// TODO Auto-generated method stub
		
		Connection col = new Connection();
		DiaryEntry diaryentry = (DiaryEntry) col.search("diaryentry", id, Boolean.FALSE);
		diaryentry.printValues();
		return diaryentry;
	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.DiaryEntryService#findByEmail(java.lang.String)
	 */
	@Override
	public DiaryEntry findByEmail(String email) {
		// TODO Auto-generated method stub
		Connection col = new Connection();
		DiaryEntry diaryentry = (DiaryEntry) col.search("diaryentry", email, Boolean.FALSE);
		diaryentry.printValues();
		return diaryentry;
	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.DiaryEntryService#insertDiaryEntry(com.mvc.diary.models.DiaryEntry)
	 */
	@Override
	public void insertDiaryEntry(DiaryEntry diaryentry) {
		// TODO Auto-generated method stub
		diaryentry.printValues();
		Connection col = new Connection();
		col.insert("diaryentry", diaryentry);

	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.DiaryEntryService#deleteDiaryEntry(java.lang.String)
	 */
	@Override
	public void deleteDiaryEntry(String id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.DiaryEntryService#updateDiaryEntry(com.mvc.diary.models.DiaryEntry)
	 */
	@Override
	public void updateDiaryEntry(DiaryEntry diaryentry) {
		// TODO Auto-generated method stub

	}

}
