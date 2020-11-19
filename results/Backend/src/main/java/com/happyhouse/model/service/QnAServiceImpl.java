package com.happyhouse.model.service;

import java.util.List;

import com.happyhouse.model.dao.QnADaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.model.dao.QnADAO;
import com.happyhouse.model.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService{
	@Autowired
	private QnADAO dao;

	public QnAServiceImpl() {
		dao = new QnADaoImpl();
	}

	@Override
	public List<QnA> retrieveQnA() {
		return dao.selectQnA();
	}

	@Override
	public QnA detailQnA(int qnaNo) {
		// TODO Auto-generated method stub
		return dao.selectQnAByNo(qnaNo);
	}

	@Override
	public boolean writeQnA(QnA qna) {
		// TODO Auto-generated method stub
		return dao.insertQnA(qna)==1;
	}

	@Override
	public boolean updateQnA(QnA qna) {
		// TODO Auto-generated method stub
		return dao.updateQnA(qna)==1;
	}

	@Override
	public boolean deleteQnA(int qnaNo) {
		// TODO Auto-generated method stub
		return dao.deleteQnA(qnaNo)==1;
	}
	

}
