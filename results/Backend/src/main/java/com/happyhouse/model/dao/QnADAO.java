package com.happyhouse.model.dao;

import java.util.List;

import com.happyhouse.model.dto.QnA;

public interface QnADAO {

	List<QnA> selectQnA();
	public QnA selectQnAByNo(int qnaNo);
	public int insertQnA(QnA qna);
	public int updateQnA(QnA qna);
	public int deleteQnA(int qnaNo);
}
