package com.happysystems.action;

import org.apache.struts.util.LabelValueBean;
import java.util.ArrayList;

public class RechargeCodes	{
	public static final String [] prepaidCodes = new String [] {"AL", "BS", "VD", "MTM", "ID", "LM", "MS", "RL", "RG", "TD", "TI", "UN", "VF", "BSS", "TDS", "UNS", "VDS", "AT", "MTD", "MTDS"};
	public final String [] prepaidCodesDesc = new String [] {"Aircel", "BSNL", "Videocon", "MTNL Mumbai", "Idea", "Loop Mobile", "MTS", "Reliance CDMA", "Reliance GSM", "Docomo GSM", "Docomo CDMA", "Uninor", "Vodafone", "BSNL - Validity", "Docomo GSM - Special", "Uninor - Special", "Videocon - Special", "Airtel", "MTNL DELHI", "MTNL DELHI SPECIAL"};

	public static final String [] dthCodes = new String [] {"TS", "DT", "BT", "VT", "AD", "SD"};
	public static final String [] dthCodesDesc = new String [] {"Tata Sky", "Dish TV", "Reliance Digital TV", "Videocon d2h", "Airtel Digital TV", "Sun Direct"};

	public static final String [] dataCodes = new String [] {"RL3", "RL2", "RL1", "MS1", "MS2", "TI2", "TI1", "TW"};
	public static final String [] dataCodesDesc = new String [] {"Reliance NetConnect 3G", "Reliance NetConnect+", "Reliance NetConnet 1x", "MTS MBlaze", "MTS MBrowse", "Tata Photon+", "Tata Photon Whiz", "Tata Walky"};

	public static final String RCTYPE_PREPAID = "";
	public static final String RCTYPE_DTH = "";
	public static final String RCTYPE_DATA = "";

	public String[] getPrepaidCodes()	{
		return prepaidCodes;
	}

	public String[] getDthCodes()	{
		return dthCodes;
	}

	public String[] getDataCodes()	{
		return dataCodes;
	}

	public String[] getPrepaidCodesDesc()	{
		return prepaidCodesDesc;
	}

	public String[] getDthCodesDesc()	{
		return dthCodesDesc;
	}

	public String[] getDataCodesDesc()	{
		return dataCodesDesc;
	}

	public void setType(String type)	{
		this.type = type;
	}
	public String getType()	{
		return type;
	}
	private String type = null;

	public String [] getCodes()	{
		if(type == null)	return null;
		if(type.equals("prepaid"))	{
			return prepaidCodes;
		}
		else if(type.equals("dth"))	{
			return dthCodes;
		}
		else if(type.equals("data"))	{
			return dataCodes;
		}
		return null;
	}

	public ArrayList getCodesList()	{
		String [] codes = getCodes();
		String [] codesDesc = getCodesDesc();
		ArrayList<LabelValueBean> codesList = new ArrayList<LabelValueBean>();
		for(int i=0; i<codes.length; i++)	{
			codesList.add(new LabelValueBean(codesDesc[i], codes[i]));
		}
		return codesList;
	}


	public String [] getCodesDesc()	{
		if(type == null)	return null;
		if(type.equals("prepaid"))	{
			return prepaidCodesDesc;
		}
		else if(type.equals("dth"))	{
			return dthCodesDesc;
		}
		else if(type.equals("data"))	{
			return dataCodesDesc;
		}
		return null;
	}
}
