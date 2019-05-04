package cn.tedu.web.back;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.entity.SaleInfo;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;

public class DownLoadSILServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1、调用业务层对象方法
		//1.1创建业务层对象
		OrderService os = BasicFactory.getFactory().
				getInstance(OrderService.class);
		//1.2调用方法
		List<SaleInfo> list = os.findSaleInfos();
		//2、创建StringBuffer对象
		StringBuffer buf = new StringBuffer
				("商品id,商品名称,销售数量\n");
		//3遍历list集合
		for(SaleInfo si:list){
			buf.append(si.getProd_id()).append(",")
			.append(si.getProd_name()).append(",")
			.append(si.getSale_num()).append("\n");
		}
		String fname = "sale_list"+getTimeStamp()+".csv";
		//4、告知浏览器以附件下载的方式识别文件
		response.setHeader("Content-Disposition",
				"attachment;filename="+fname);
		//处理文件内容的乱码问题
		response.setContentType("text/html;charset=gbk");
		//5将内容响应浏览器
		response.getWriter().write(buf.toString());
	}
	private String getTimeStamp(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
