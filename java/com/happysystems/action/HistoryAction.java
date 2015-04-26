package com.happysystems.action;

import org.apache.struts.action.*;
import org.json.JSONObject;

import javax.servlet.http.*;

import com.google.gson.Gson;
import com.happysystems.form.*;
import com.happysystems.model.Recharge;
import com.happysystems.dao.*;

import java.util.HashMap;
import java.util.List;

import com.happysystems.dao.RechargeDAO;

public class HistoryAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {		
		int st = 0;
		int end = 0;
		String search = ""; 
		try {
			st = Integer.parseInt(req.getParameter(History.DISP_START));
			end = Integer.parseInt(req.getParameter(History.DISP_LEN));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		search = req.getParameter(History.SEARCH_KEY);

		if (end == 0)
			end = 10; // minimum 10 results
		RechargeDAO dao = RechargeDAO.getInstance();
		List<Recharge> recharges = null;
		History h = null;
		if(search != null && search.trim().length() > 0)	{
			int [] filteredLength = new int[]{0};
			recharges = dao.getHistory(search, st, end, filteredLength);
			h = new History(recharges, 0, dao.getTotal(), filteredLength[0]);
		}
		else	{	
			recharges = dao.getHistory(st, end);		
			h = new History(recharges, 0, dao.getTotal(), dao.getTotal());
		}
		String json = new Gson().toJson(h);
		resp.addHeader("Content-Type", "application/json");
		resp.getOutputStream().write(json.toString().getBytes("UTF-8"));
		resp.getOutputStream().flush();
		return null;		
	}

	public static class History	{
		public static final String DISP_START = "iDisplayStart";
		public static final String DISP_LEN = "iDisplayLength";
		public static final String SEARCH_KEY = "sSearch";
		public History(List<Recharge> aaData, int sEcho, long iTotalRecords,
				long iTotalDisplayRecords) {			
			this.aaData = aaData;
			this.sEcho = sEcho;
			this.iTotalRecords = iTotalRecords;
			this.iTotalDisplayRecords = iTotalDisplayRecords;
		}
		
		private long iTotalRecords;
		private long iTotalDisplayRecords;
		private int sEcho;
		private List<Recharge> aaData;
		
		public List<Recharge> getAaData() {
			return aaData;
		}
		public void setAaData(List<Recharge> aaData) {
			this.aaData = aaData;
		}
		public int getsEcho() {
			return sEcho;
		}
		public void setsEcho(int sEcho) {
			this.sEcho = sEcho;
		}
		public long getiTotalRecords() {
			return iTotalRecords;
		}
		public void setiTotalRecords(long iTotalRecords) {
			this.iTotalRecords = iTotalRecords;
		}
		public long getiTotalDisplayRecords() {
			return iTotalDisplayRecords;
		}
		public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
			this.iTotalDisplayRecords = iTotalDisplayRecords;
		}
		
	}
}
