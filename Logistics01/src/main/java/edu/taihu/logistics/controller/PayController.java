package edu.taihu.logistics.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.taihu.logistics.tool.PaymentUtil;
import edu.taihu.logistics.tool.PropPayUtils;
import edu.taihu.logistics.pojo.Contract;
import edu.taihu.logistics.service.ContractService;
import edu.taihu.logistics.service.OrderService;

@Controller
public class PayController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ContractService contractService;
	
	@RequestMapping("to_pay")
	public String to_pay(Model model,String orderId){
		model.addAttribute("orderId", orderId);
		Contract contract=contractService.findContractById(orderId);
		model.addAttribute("money", contract.getPrice());
		return "/home/pay";
	}
	@RequestMapping("/to_confirm")
	public String to_confirm(Model model,String orderId,HttpServletRequest request)throws ServletException, IOException {
				//1、准备参数
				String p0_Cmd ="Buy";//业务类型
				//商户编号
				String p1_MerId=PropPayUtils.
						getProperty("p1_MerId");
				//订单id
				String p2_Order =orderId;
				//订单金额：
				//测试时使用
				String p3_Amt ="0.01";
				//正式使用
				/*Contract contract=contractService.findContractById(orderId);
				String p3_Amt= contract.getPrice()+"";*/
				String p4_Cur = "CNY";//交易币种
				String p5_Pid ="";//商品名称
				String p6_Pcat="";//商品种类
				String p7_Pdesc="";//商品描述
				//回调的url地址
				String p8_Url=PropPayUtils.
						getProperty("responseURL");
				String p9_SAF = "";//收货地址
				String pa_MP = "";//商户扩展信息
				//支付通道
				String pd_FrpId=request.getParameter("pd_FrpId");
				String pr_NeedResponse="1";
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order,
						p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, 
						p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse,
						PropPayUtils.getProperty("keyValue"));
				//2、将准备好的参数保存到request作用域中
				model.addAttribute("p0_Cmd", p0_Cmd);
				model.addAttribute("p1_MerId", p1_MerId);
				model.addAttribute("p2_Order", p2_Order);
				model.addAttribute("p3_Amt", p3_Amt);
				model.addAttribute("p4_Cur", p4_Cur);
				model.addAttribute("p5_Pid", p5_Pid);
				model.addAttribute("p6_Pcat", p6_Pcat);
				model.addAttribute("p7_Pdesc", p7_Pdesc);
				model.addAttribute("p8_Url", p8_Url);
				model.addAttribute("p9_SAF", p9_SAF);
				model.addAttribute("pa_MP", pa_MP);
				model.addAttribute("pd_FrpId", pd_FrpId);
				model.addAttribute("pr_NeedResponse", pr_NeedResponse);
				model.addAttribute("hmac", hmac);
		return "/home/confirm";
	}
	
	@RequestMapping("/callback")
	public String callback(Model model,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		//接收第三方支付平台传回的参数
				String p1_MerId = request.getParameter("p1_MerId");
				String r0_Cmd = request.getParameter("r0_Cmd");
				String r1_Code =request.getParameter("r1_Code");
				//易宝支付平台上的交易的流水号
				String r2_TrxId= request.getParameter("r2_TrxId");
				String r3_Amt= request.getParameter("r3_Amt");
				String r4_Cur = request.getParameter("r4_Cur");
				String r5_Pid = request.getParameter("r5_Pid");
				//订单id
				String r6_Order = request.getParameter("r6_Order");
				String r7_Uid = request.getParameter("r7_Uid");
				String r8_MP = request.getParameter("r8_MP");
				//交易结果返回类型：1表示重定向 2表示点对点通讯
				String r9_BType = request.getParameter("r9_BType");
				String rb_BankId= request.getParameter("rb_BankId");
				String ro_BankOrderId = request.getParameter("ro_BankOrderId");
				String rp_PayDate= request.getParameter("rp_PayDate");
				String rq_CardNo = request.getParameter("rq_CardNo");
				String ru_Trxtime = request.getParameter("ru_Trxtime");
				String hmac = request.getParameter("hmac");
				//验证数据是否被篡改
				boolean result=PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, 
						PropPayUtils.getProperty("keyValue"));
				if(!result){//表示数据被篡改了
					System.out.println("数据被篡改了...");
				}else{//未被篡改
					//判断重定向过来的还是点对点通讯过来的
					if("1".equals(r9_BType)){
						//以下两行代码正式部署时要记得删除掉
						//修改订单的支付状态
						orderService.changePayState(1,r6_Order);
						//重定向过来的
						model.addAttribute("msg", "支付成功");
						
					}else if("2".equals(r9_BType)&&"1".equals(r1_Code)){
						//点对点通知
						//创建业务层对象
						//修改订单的支付状态
						orderService.changePayState(1,r6_Order);
						//响应给第三方支付平台success
//						response.getWriter().write("success");
						model.addAttribute("msg", "支付成功");
					}
				}
		return "home/callback";
	}
}
