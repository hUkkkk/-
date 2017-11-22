package com.example.demo3.controller;




import com.example.demo3.model.Info;
import com.example.demo3.util.FileUtil;
import com.sun.deploy.net.HttpResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class upload {
    @RequestMapping(value="/testupload", method = RequestMethod.POST)
    public  String upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        //上传文件
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
        String filePath = request.getSession().getServletContext().getRealPath("upload/");
        System.out.println("filePath-->" + filePath);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

        //读取文件
            List<Info> list = new ArrayList<Info>();
            List<String> heard = new ArrayList<>();
        HSSFWorkbook book = null;
        try {
            book = new HSSFWorkbook(new FileInputStream(filePath+"\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HSSFSheet sheet = book.getSheetAt(0);

            for(int i=1; i<sheet.getLastRowNum()+1; i++) {
                HSSFRow row = sheet.getRow(i);
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                String name = row.getCell(0).getStringCellValue(); //名称
                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                String tel = row.getCell(1).getStringCellValue(); //电话
                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                String address = row.getCell(2).getStringCellValue();
                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                String goods = row.getCell(3).getStringCellValue();
                Integer count = (int) row.getCell(4).getNumericCellValue();

                list.add(new Info(name, tel, address, goods, count));
            }

            System.out.println("共有 " + list.size() + " 条数据：");
            for(Info wd : list) {
                System.out.println(wd);
            }
            request.setAttribute("list",list);

        return "index";
    }
}
