package com.study.spring.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;




/**
 * 
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author zufeichao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class PageNumberUtil {

    /**
     * 默认的分页大小
     */
    public static final int pageSize = 15;
    /**
     * 默认的分页大小
     */
    public static final int PAGE_SIZE_50 = 50;
    /**
     * 默认起止页大小
     */
    public static final int currentPage = 1;
    
    private PageNumberUtil(){}

    /**
     * 从HashMap里获取pageSize
     * 
     * @param HashMap
     * @return
     */
    public static int getPageSizeFromParams(Map<String, Object> params) {
        
        int pageSizeReturn = pageSize;
        if (params.get("rows") == null || String.valueOf(params.get("rows")).trim().length() == 0) {
            Object strPageSize = MapUtils.getString(params,"pageSize");
            if (null == strPageSize) {
                return pageSize;
            }
            
            try {
                pageSizeReturn = Integer.parseInt(String.valueOf(strPageSize));
            } catch (NumberFormatException e) {
                pageSizeReturn = pageSize;
            }
        } else {
            int rows = PageNumberUtil.pageSize;
            try {
                rows = Integer.parseInt(String.valueOf(params.get("rows")));
            } catch (NumberFormatException e) {
                pageSizeReturn = pageSize;
            }
            pageSizeReturn = rows;
        }
        
        return pageSizeReturn;
    }

    /**
     * 从request里获取pageSize
     * 
     * @param request
     * @return
     */
    public static int getPageSizeFromRequest(HttpServletRequest request) {

        Object strPageSize = request.getParameter("pageSize");
        if (null == strPageSize) {
            return pageSize;
        }
        int pageSizeReturn;
        try {
            pageSizeReturn = Integer.parseInt(String.valueOf(strPageSize));
        } catch (NumberFormatException e) {
            pageSizeReturn = pageSize;
        }
        return pageSizeReturn;
    }

    /**
     * 从HashMap里获取currentPage
     * 
     * @param HashMap
     * @return
     */
    public static int getCurrentPageFromParams(Map<String, Object> params) {

        Object strCurrentPage = MapUtils.getString(params,"page");
        if (null == strCurrentPage) {
            return currentPage;
        }
        int currentPageReturn;
        try {
            currentPageReturn = Integer.parseInt(String.valueOf(strCurrentPage));
        } catch (NumberFormatException e) {
            currentPageReturn = currentPage;
        }
        return currentPageReturn;
    }
    
    /**
     * 从HashMap里获取currentPage
     * 
     * @param HashMap
     * @return
     */
    public static int getPageFromParams(Map<String, Object> params) {

        Object strCurrentPage = MapUtils.getString(params,"page");
        if (null == strCurrentPage) {
            return currentPage;
        }
        int currentPageReturn;
        try {
            currentPageReturn = Integer.parseInt(String.valueOf(strCurrentPage));
        } catch (NumberFormatException e) {
            currentPageReturn = currentPage;
        }
        return currentPageReturn;
    }
    

    /**
     * 从request里获取currentPage
     * 
     * @param request
     * @return
     */
    public static int getCurrentPageFromRequest(HttpServletRequest request) {

        Object strCurrentPage = request.getParameter("currentPage");
        if (null == strCurrentPage) {
            return currentPage;
        }
        int currentPageReturn;
        try {
            currentPageReturn = Integer.parseInt(String.valueOf(strCurrentPage));
        } catch (NumberFormatException e) {
            currentPageReturn = currentPage;
        }
        return currentPageReturn;
    }

    /**
     * 从HashMap里获取pageSize
     * 
     * @param HashMap
     * @return
     */
    public static int getPageSizeFromParams(Map<String, Object> params, String pageSizeName) {

        Object strPageSize = MapUtils.getString(params,pageSizeName);
        if (null == strPageSize) {
            return pageSize;
        }
        int pageSizeReturn;
        try {
            pageSizeReturn = Integer.parseInt(String.valueOf(strPageSize));
        } catch (NumberFormatException e) {
            pageSizeReturn = pageSize;
        }
        return pageSizeReturn;
    }

    /**
     * 从request里获取pageSize
     * 
     * @param request
     * @return
     */
    public static int getPageSizeFromRequest(HttpServletRequest request, String pageSizeName) {

        Object strPageSize = request.getParameter(pageSizeName);
        if (null == strPageSize) {
            return pageSize;
        }
        int pageSizeReturn;
        try {
            pageSizeReturn = Integer.parseInt(String.valueOf(strPageSize));
        } catch (NumberFormatException e) {
            pageSizeReturn = pageSize;
        }
        return pageSizeReturn;
    }

    /**
     * 从HashMap里获取currentPage
     * 
     * @param HashMap
     * @return
     */
    public static int getCurrentPageFromParams(Map<String, Object> params, String currentPageName) {

        Object strCurrentPage = MapUtils.getString(params,currentPageName);
        if (null == strCurrentPage) {
            return currentPage;
        }
        int currentPageReturn;
        try {
            currentPageReturn = Integer.parseInt(String.valueOf(strCurrentPage));
        } catch (NumberFormatException e) {
            currentPageReturn = currentPage;
        }
        return currentPageReturn;
    }

    /**
     * 从request里获取currentPage
     * 
     * @param request
     * @return
     */
    public static int getCurrentPageFromRequest(HttpServletRequest request, String currentPageName) {

        Object strCurrentPage = request.getParameter(currentPageName);
        if (null == strCurrentPage) {
            return currentPage;
        }
        int currentPageReturn;
        try {
            currentPageReturn = Integer.parseInt(String.valueOf(strCurrentPage));
        } catch (NumberFormatException e) {
            currentPageReturn = currentPage;
        }
        return currentPageReturn;
    }

}
