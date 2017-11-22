package com.example.demo3;

import com.example.demo3.model.Info;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo3ApplicationTests {

	@Test
	public void contextLoads() {
	}
	//读取到列表
	@Test
	public void testReadList() throws Exception {
		List<Info> list = new ArrayList<Info>();

		HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:info.xls1")));

		HSSFSheet sheet = book.getSheetAt(0);

		for(int i=1; i<sheet.getLastRowNum()+1; i++) {
			HSSFRow row = sheet.getRow(i);
			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			String name = row.getCell(0).getStringCellValue(); //名称
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
			String tel = row.getCell(1).getStringCellValue(); //url
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
	}
}
