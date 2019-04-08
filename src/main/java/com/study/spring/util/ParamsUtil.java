package com.study.spring.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

public class ParamsUtil {

    private ParamsUtil(){}

    public static int[] handServletPager(Map<String, Object> parameter) {
        int[] pager = new int[] { PageNumberUtil.currentPage, PageNumberUtil.pageSize };
        if (parameter.get("page") != null) {
            pager[0] = Integer.parseInt(parameter.get("page").toString());
        }
        if (parameter.get("rows") != null) {
            pager[1] = Integer.parseInt(parameter.get("rows").toString());
        }
        return pager;
    }

    public static Map<String, Object> handleServletParameter(HttpServletRequest request) {
        Map<String, String[]> parameter = request.getParameterMap();
        Map<String, Object> rParams = new HashMap<String, Object>(0);
        for (Entry<String, String[]> m : parameter.entrySet()) {
            String key = m.getKey();
            String[] obj =  parameter.get(key);
            rParams.put(key, (obj.length > 1) ? obj : obj[0]);
        }
        return rParams;
    }

    public static Map<String, Object> parameterConvert(final Map<String, String[]> parameter) {
        Map<String, Object> rParams = new HashMap<String, Object>(0);
        for (Map.Entry<String, String[]> m : parameter.entrySet()) {
            String key = m.getKey();
            Object[] obj = (Object[]) parameter.get(key);
            rParams.put(key, (obj.length > 1) ? obj : obj[0]);
        }
        return rParams;
    }

    public static String getParamter(Map<String, Object> params, String key) {
        String[] str = (String[]) params.get(key);
        return ((str != null) && (str.length > 0)) ? str[0] : null;
    }

    public static String getParamter(Map<String, Object> params, String key, String defaultValue) {
        String value = getParamter(params, key);
        return (null == value) ? defaultValue : value;
    }

    public static Integer getParamterInt(Map<String, Object> params, String key) {
        if (params.get(key) != null) {
            return Integer.parseInt(params.get(key).toString());
        } else {
            return 0;
        }
    }

    public static Integer getParamterInt(Map<String, Object> params, String key, int defaultValue) {
        Integer value = getParamterInt(params, key);
        return isNullOrEmpty(value) ? Integer.valueOf(defaultValue) : value;
    }

    public static Double getParamterDouble(Map<String, Object> params, String key) {
        String value = getParamter(params, key);
        return isNullOrEmpty(value) ? null : new Double(value);
    }

    public static Double getParamterDouble(Map<String, Object> params, String key, double defaultValue) {
        Double value = getParamterDouble(params, key);
        return isNullOrEmpty(value) ? new Double(defaultValue) : value;
    }

    public static Long getParamterLong(Map<String, Object> params, String key) {
        String value = getParamter(params, key);
        return isNullOrEmpty(value) ? null :  Long.valueOf(value);
    }

    public static Long getParamterLong(Map<String, Object> params, String key, long defaultValue) {
        Long value = getParamterLong(params, key);
        return isNullOrEmpty(value) ? Long.valueOf(defaultValue) : value;
    }

    /**
     * 
     * 得到Short参数
     * 
     * @param params
     * @param key
     * @return
     */
    public static Short getParamterShort(Map<String, Object> params, String key) {
        String value = getParamter(params, key);
        return isNullOrEmpty(value) ? null : Short.valueOf(value);    
    }

    public static Short getParamterShort(Map<String, Object> params, String key, short defaultValue) {
        Short value = getParamterShort(params, key);
        return isNullOrEmpty(value) ? Short.valueOf(defaultValue) : value;
    }

    public static Date getParamterDate(Map<String, Object> params, String key, int formatter) {
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        int year;
        int month;
        int day;
        int hour;
        int min;
        int sec;
        if (params.get(key) != null) {
            String keyValue = params.get(key).toString().trim();
            if (keyValue.indexOf("-") > -1) {
                String[] dateArr;
                String[] timeArr;
                switch (formatter) {
                    case 0:
                        dateArr = keyValue.split("-");
                        year = Integer.parseInt(dateArr[0]);
                        month = Integer.parseInt(dateArr[1]) - 1;
                        day = Integer.parseInt(dateArr[2]);
                        calendar.set(year, month, day);
                        break;
                    case 1:
                        String[] temp = keyValue.split(" ");
                        dateArr = temp[0].split("-");
                        timeArr = temp[1].split(":");
                        year = Integer.parseInt(dateArr[0]);
                        month = Integer.parseInt(dateArr[1]) - 1;
                        day = Integer.parseInt(dateArr[2]);
                        hour = Integer.parseInt(timeArr[0]);
                        min = Integer.parseInt(timeArr[1]);
                        sec = Integer.parseInt(timeArr[2]);
                        calendar.set(year, month, day, hour, min, sec);
                        break;
                    default:
                        break;

                }
            }
        }
        date = calendar.getTime();
        return date;
    }

    @SuppressWarnings("rawtypes")
    public static String convertParams(Map<String, Object> map) {
        Map.Entry entry;
        StringBuilder sbr = new StringBuilder();
        sbr.append("[");
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
            entry = (Map.Entry) iterator.next();
            sbr.append("\"" + entry.getKey().toString() + "\"").append(":")
                    .append(null == entry.getValue() ? "\"\"" : ("\"" + entry.getValue().toString() + "\""))
                    .append(iterator.hasNext() ? "," : "");
        }
        sbr.append("]");
        return sbr.toString();

    }

    public static boolean isNullOrEmpty(Object o) {
        return o == null || String.valueOf(o).trim().length() == 0;
    }

}
