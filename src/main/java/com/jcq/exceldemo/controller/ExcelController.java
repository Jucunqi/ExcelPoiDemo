package com.jcq.exceldemo.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.jcq.exceldemo.pojo.User;
import com.jcq.exceldemo.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private UserService userService;

    @RequestMapping("exprotExcel")
    public String exprotExcel(HttpServletResponse response) {

        //查询出需要导出的数据
        List<User> allUser = userService.getAllUser();
        //创建workbook对象
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("信息表", "员工信息"), User.class, allUser);
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode("员工信息表.xls", "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("userInfoImport")
    public String userInfoImport(@RequestParam("file") MultipartFile file) throws Exception{
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        //设置参数
        ImportParams importParams = new ImportParams();
        //设置标题行
        importParams.setTitleRows(1);
        //设置表头
        importParams.setHeadRows(1);
        //从Excel表的第三行开始插入
//        importParams.setStartRows(2);
        //获取模板
        ExcelImportResult<User> data = ExcelImportUtil.importExcelMore(file.getInputStream(), User.class, importParams);
        //获取模板数据
        List<User> userList = data.getList();
        //非空判断，若为空直接返回
        if (userList==null||userList.size()==0) {
            return null;
        }
        //创建索引对象
        int index = 0;
        try {
            for (User user : userList) {
                System.out.println(user);
                index += userService.insUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (index==userList.size()) {
            System.out.println("----------Excel导入成功");
        }
        return "redirect:getAllUser";
    }

}
