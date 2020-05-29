package com.example.demo.component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
public class MyRequestWrapper extends HttpServletRequestWrapper{
    public MyRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    private HttpServletRequestWrapper rewriteUrl(HttpServletRequest hr) {
        return new HttpServletRequestWrapper(hr) {

            @Override
            public String getRequestURI() {
                // TODO Auto-generated method stub
                String rewriteUrl;
                String requestURI = hr.getRequestURI();
                System.out.println(requestURI+"---");
                return (rewriteUrl = getRewriteUrl(requestURI)) == null ? requestURI : rewriteUrl;
               /*"/MiGuMgr/rs/service/com_sitech_acctmgr_inter_IPresentIssSvc3_cfm";*/
            }

            private String getRewriteUrl(String requestURI) {
//                String rewriteUrl;
//                if ((rewriteUrl = redirectUrlMap.get(requestURI)) != null) {
//                    return rewriteUrl;
//                }
//                return null;
                return "";
            }

//            @Override
//            public StringBuffer getRequestURL() {
//                // TODO Auto-generated method stub
//                return new StringBuffer(getScheme() + "://" + getServerName() + ":" + getServerPort() + getRequestURI());
////                return new StringBuffer("http://127.0.0.1:8080/MiGuMgr/rs/service/com_sitech_acctmgr_inter_IPresentIssSvc3_cfm");
//            }
//
//            @Override
//            public String getServletPath() {
//                // TODO Auto-generated method stub
////                hr.getServletContext()
////                if(!StringUtils.isEmpty(getRewriteUrl(hr.getContextPath()+hr.getServletPath()))){
////                    return getRewriteUrl(hr.getContextPath()+hr.getServletPath()).substring(hr.getContextPath().length());
////                }
////                return hr.getServletPath();
//                return null;
//            }


        };
    }

}