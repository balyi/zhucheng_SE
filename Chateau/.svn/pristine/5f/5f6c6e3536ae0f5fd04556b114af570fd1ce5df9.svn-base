package com.chateau.controller;

import com.chateau.pojo.Order;
import com.chateau.pojo.OrderReserveWine;
import com.chateau.pojo.User;
import com.chateau.service.OrderService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tedu on 2017/11/28.
 */
@Controller
@RequestMapping("/back")
public class DownloadController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/download")
    public void downstudents(HttpServletRequest request, HttpServletResponse response) throws IOException {  //我这是根据前端传来的起始时间来查询数据库里的数据，如果没有输入变量要求，保留前两个就行

        String[] headers = {"订单ID", "备注", "支付状态", "用户名", "送货地址", "下单日期", "金额"};//导出的Excel头部，这个要根据自己项目改一下

        List<Order> dataset = orderService.findAllOrders();//查询出来的数据，根据自己项目改一下

        //下面的完全不动就行了（Excel数据中不包含图片）

        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 18);
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //遍历集合数据，产生数据行
        Iterator<Order> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            Order t = (Order) it.next();
            //利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[]{});
                    Object value = getMethod.invoke(t, new Object[]{});
                    String textValue = null;


                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        textValue = sdf.format(date);
                    } else if (value instanceof User) {
                        User user = (User) value;
                        textValue = user.getUsername();
                    } else if (value instanceof Integer) {
                        int state = (Integer) value;
                        if (state == 1) {
                            textValue = "已支付";
                        } else if (state == 0) {
                            textValue = "未支付";
                        }
                    } else if (value instanceof String) {
                            textValue = (String) value;
                    } else if (value instanceof Double){
                        textValue = ((Double)value).toString();
                    }

                    HSSFRichTextString richString = new HSSFRichTextString(textValue);
                    HSSFFont font3 = workbook.createFont();
                    font3.setColor(HSSFColor.BLUE.index);//定义Excel数据颜色
                    richString.applyFont(font3);
                    cell.setCellValue(richString);

                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=OrderList.xls");//默认Excel名称
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
