package com.happyhouse.model.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happyhouse.model.dto.QnA;

@Repository
public class QnADaoImpl implements QnADAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<QnA> selectQnA() {
        // TODO Auto-generated method stub
        return sqlSession.selectList("com.happyhouse.model.dao.QnADAO.selectQnA");
    }

    @Override
    public QnA selectQnAByNo(int qnaNo) {
        // TODO Auto-generated method stub
        return sqlSession.selectOne("com.happyhouse.model.dao.QnADAO.selectQnAByNo",qnaNo);
    }

    @Override
    public int insertQnA(QnA qna) {
        // TODO Auto-generated method stub
        return sqlSession.insert("com.happyhouse.model.dao.QnADAO.insertQnA",qna);
    }

    @Override
    public int updateQnA(QnA qna) {
        // TODO Auto-generated method stub
        return sqlSession.update("com.happyhouse.model.dao.QnADAO.updateQnA",qna);
    }

    @Override
    public int deleteQnA(int qnaNo) {
        // TODO Auto-generated method stub
        return sqlSession.delete("com.happyhouse.model.dao.QnADAO.deleteQnA",qnaNo);
    }

}