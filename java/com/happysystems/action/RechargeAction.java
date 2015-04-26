package com.happysystems.action;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import com.happysystems.form.*;
import com.happysystems.dao.*;
import java.util.HashMap;

public class RechargeAction extends Action {
	public static final String RC_PATH = "/recharge";
	public static final String LRC_PATH = "/lastrc";
	public static final String DIS_PATH = "/dispute";
	public static final String RCKEY = System.getenv("RCKEY") == null ? "chappymobiles534"
			: System.getenv("RCKEY");

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		RechargeForm frm = (RechargeForm) form;
		String path = mapping.getPath();
		String type = frm.getType();
		frm.setMessage("");
		HashMap<String, String> params = new HashMap<String, String>();
		

		params.put("key", RCKEY);
		if (path.equals(LRC_PATH)) {
			processLastRC(params, frm);
		} else if (path.equals(RC_PATH)) {
			processRecharge(type, params, frm);
		} else if (path.equals(DIS_PATH)) {
			processDispute(params, frm);
		}
		frm.setType("");
		return mapping.findForward("success");
	}

	private void processRecharge(String type, HashMap<String, String> params,
			RechargeForm frm) {
		if (type.equals("prepaid") || type.equals("dth") || type.equals("data")) {
			params.put("service", frm.getService());
			params.put("operator", frm.getOperator());
			params.put("amount", frm.getAmount());
			frm.setResponse(RechargeSubmit.submit(type, params));
			frm.setMessage(frm.getResponse());
			RechargeDAO dao = RechargeDAO.getInstance();
			long number = Long.parseLong(frm.getService());
			double amount = Double.parseDouble(frm.getAmount());
			dao.saveRecharge(number, amount, frm.getOperator(),
					frm.getResponse());
		} else if (type.equals("")) {
			frm.setMessage(RechargeSubmit.submit(type, params));
		}
	}

	private void processLastRC(HashMap<String, String> params, RechargeForm frm) {
		frm.setMessage(RechargeSubmit.submit("lastrc", params));
	}

	private void processDispute(HashMap<String, String> params, RechargeForm frm) {
		params.put("transactionid", frm.getOrderID());
		frm.setMessage(RechargeSubmit.submit("dispute", params));
	}
}
