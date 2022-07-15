package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Memo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IMemoService;

@Slf4j
@RequestMapping("memo")
@Controller
@Api(value = "控制器")
public class MemoController  {

    @Autowired
    @Qualifier("memoService")
    private IMemoService memoService;

    @PostMapping("select_by_kw")
    @ResponseBody
    public ResponseData selectByKW(@RequestParam String kw,PageData pageData){
        pageData.addCriteria("kw",kw);
        pageData.setCriteriaMap(pageData.getCriteriaMap());
        System.out.println(pageData);
        return ResponseData.SUCCESS(memoService.selectPage(pageData).getRecords());
    }

    @PostMapping("create_memo")
    @ResponseBody
    public ResponseData createMemo(Memo memo){
        int rows = memoService.insert(memo);
        return ResponseData.SUCCESS(rows);
    }

    @GetMapping("delete_by_id")
    @ResponseBody
    public ResponseData deleteById(Integer memoId){
        int rows = memoService.deleteById(memoId);
        return ResponseData.SUCCESS(rows);
    }

    @GetMapping("modify_by_id")
    @ResponseBody
    public ResponseData updateById(Memo memo){
        return memoService.updateById(memo);
    }
}