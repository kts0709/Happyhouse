package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.dto.QnA;

public interface QnAService {
	public List<QnA> retrieveQnA();
	public QnA detailQnA(int qnaNo);
	public boolean writeQnA(QnA qna);
	public boolean updateQnA(QnA qna);
	public boolean deleteQnA(int qnaNo);

}
