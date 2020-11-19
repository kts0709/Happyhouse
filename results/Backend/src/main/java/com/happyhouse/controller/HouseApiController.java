package com.happyhouse.controller;

import com.happyhouse.model.dto.HouseDeal;
import com.happyhouse.model.dto.School;
import com.happyhouse.model.dto.Search;
import com.happyhouse.model.service.HouseService;
import com.happyhouse.util.GeoCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/house")
public class HouseApiController {

	@Autowired
    private HouseService houseService;

    @GetMapping("/all")
    public List<HouseDeal> getAllList() {
        return houseService.findAll();
    }

    @GetMapping("/search/{key}/{word}/{types}")
    public List<HouseDeal> searchList(@PathVariable("key") String key, @PathVariable("word") String word, @PathVariable("types") List<Integer> types) {
        Search vo = new Search(key, word, types);
        return houseService.searchAll(vo);
    }

    @GetMapping("/details/{no}")
    public HouseDeal details(@PathVariable int no) {
        return houseService.search(no);
    }
    
    @ApiOperation(value = "dong에 해당하는 학군정보를 반환한다.", response = HouseDeal.class)
    @GetMapping("/school/{dong}")
    public List<School> findSchool(@PathVariable String dong) {
        System.out.println("findSchool dong="+dong);
        dong=dong.trim();
       return houseService.findSchool(dong);
    }

    @ApiOperation(value = "dong, area, type, no에 해당하는 유사거래정보를 반환한다.", response = HouseDeal.class)
    @GetMapping("/{type}/{dong}/{area}/{no}")
    public List<HouseDeal> similarHouse(@PathVariable String type, @PathVariable String dong, @PathVariable float area, @PathVariable int no) {
        System.out.println("similarHouse  dong="+dong+" type="+type+" area="+area+" no="+no);
        HouseDeal dto = new HouseDeal();
        dto.setType(type);
        dto.setDong(dong);
        dto.setArea(area);
        dto.setNo(no);
        return houseService.similarHouse(dto);
    }

	@GetMapping("/lnglat/{dong}/{apt}")
	public Double[] getLngLat(@PathVariable("dong") String dong, @PathVariable("apt") String apt) {
        String location = dong + apt;
        location = location.trim();
        return GeoCode.getValues(location);
    }
}
