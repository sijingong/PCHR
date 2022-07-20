package com.bnt.pchr.controller;

import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.ContractTemplate;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IContractTemplateService;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequestMapping("contract/template")
@Controller
@Api(value = "控制器")
public class ContractTemplateController {

    @Autowired
    @Qualifier("resumeTemplateService")
    private IContractTemplateService resumeTemplateService;

    /**
     * 上传合同模板
     *
     * @param tempName  合同模板名称
     * @param tempFiles 合同模板文件数组
     * @param
     * @return
     */
    @PostMapping("upload")
    @ResponseBody
    public ResponseData uploadTemplateFile(@RequestParam("temp_name") String tempName, @RequestParam("temp_files") MultipartFile[] tempFiles) throws Exception {
        return resumeTemplateService.uploadTemplateFile(tempName, tempFiles);
    }

    /**
     * 创建合同模板
     *
     * @param template
     * @return
     */
    @PostMapping("create")
    @ResponseBody
    public ResponseData createTemplate(ContractTemplate template) {
        return resumeTemplateService.insert(template);
    }

    /**
     * 修改合同模板
     *
     * @param template
     * @return
     */
    @PostMapping("modify")
    @ResponseBody
    public ResponseData modifyTemplate(ContractTemplate template) {
        return resumeTemplateService.updateById(template);
    }

    /**
     * 获取合同模板URL
     *
     * @param tempId 合同模板ID
     * @return
     */
    @GetMapping("get_url")
    @ResponseBody
    public ResponseData getTemplateURL(int tempId) {
        return resumeTemplateService.getTemplateURL(tempId);
    }

    /**
     * 删除合同模板
     *
     * @param tempId 模板ID
     * @return
     */
    @GetMapping("remove")
    @ResponseBody
    public ResponseData removeTemplate(@RequestParam("temp_id") int tempId) {
        int rows = resumeTemplateService.deleteById(tempId);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 根据合同模板ID加载数据
     *
     * @param tempId 模板ID
     * @return
     */
    @GetMapping("load")
    @ResponseBody
    public ResponseData loadTemplateData(@RequestParam("temp_id") int tempId) {
        ContractTemplate template = resumeTemplateService.selectById(tempId);
        if (template != null) {
            return ResponseData.SUCCESS(template);
        } else {
            return ResponseData.FAIL(900410, "未查询到合同模板信息");
        }
    }

    /**
     * 根据关键字分页查询员工简历
     *
     * @param tempType  合同模板类型
     * @param tempState 合同模板状态
     * @param pageData  分页数据
     * @param model     数据模型
     * @return
     */
    @PostMapping("page_list")
    public String selectResumes(@RequestParam(required = false) Integer tempType, @RequestParam(required = false) Integer tempState, PageData<ContractTemplate> pageData, Model model) {
        pageData.addCriteria("tempType", tempType);
        pageData.addCriteria("tempState", tempState);
        pageData = resumeTemplateService.selectPage(pageData);
        model.addAttribute("pageData", pageData);
        return "/contract/template/template_list";
    }
}