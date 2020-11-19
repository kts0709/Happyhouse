package com.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.HappyHouseException;
import com.happyhouse.model.dao.HouseRepository;
import com.happyhouse.model.dto.HouseDeal;
import com.happyhouse.model.dto.School;
import com.happyhouse.model.dto.Search;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public List<HouseDeal> findAll() {
        return houseRepository.findAll();
    }

    public List<School> findSchool(String dong) {
        return houseRepository.findSchool(dong);
    }
    
    public List<HouseDeal> similarHouse(HouseDeal dto) {
        return houseRepository.similarHouse(dto);
    }

    public List<HouseDeal> searchAll(Search vo) {
        try {
            int cnt = vo.getType().size();
            if (cnt == 0) {
                throw new HappyHouseException("주택타입은 반드시 한개이상을 선택해야 합니다.");
            }
            List<HouseDeal> res = houseRepository.searchAll(vo);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            throw new HappyHouseException("주택 정보 조회중 오류 발생");
        }
    }

    public HouseDeal search(int no) {
        try {
            HouseDeal deal = houseRepository.search(no);
            if (deal == null) {
                throw new HappyHouseException(String.format("거래번호 %d번에 해당하는 주택거래 정보가 존재하지 않습니다.", no));
            }
            deal.setImg(java.net.URLEncoder.encode(deal.getAptName(), "euc-kr") + ".jpg");
            return deal;
        } catch (Exception e) {
            throw new HappyHouseException("주택 정보 조회중 오류 발생");
        }
    }
}
