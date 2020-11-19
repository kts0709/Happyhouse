package com.happyhouse.model.dao;

import com.happyhouse.model.dto.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<HouseDeal> searchAll(Search vo) {
        List<HouseDeal> res = new ArrayList<>();
        if (vo.getKey().equals("dong")) {
            for (int i = 0; i < vo.getType().size(); i++) {
                res.addAll(sqlSession.selectList("house.selectDong", new SearchParam(vo.getWord(), vo.getType().get(i))));
            }
        } else {
            for (int i = 0; i < vo.getType().size(); i++) {
                res.addAll(sqlSession.selectList("house.selectApt", new SearchParam(vo.getWord(), vo.getType().get(i))));
            }
        }
        return res;
    }

    public List<School> findSchool(String dong) {
        String newDong = '(' + dong;
        return sqlSession.selectList("house.findSchool", newDong);
    }

    public List<HouseDeal> similarHouse(HouseDeal dto) {
        return sqlSession.selectList("house.similarHouse", dto);
    }

    public HouseDeal search(int no) {
        return sqlSession.selectOne("house.select", no);
    }

    public List<HouseDeal> findAll() {
        return sqlSession.selectList("house.all");
    }
}
