<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html><html><head>  
  <meta http-equiv="Content-Language" content="zh-CN">   
   <meta http-equiv="content-type" content="text/html; charset=utf-8"/>  
     <meta id="viewport" name="viewport"
      content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;"/>  
      
        <meta content="telephone=no" name="format-detection"/>  
       <base href="<%=basePath%>"/>
         <title>抱歉，出错了</title>
         <link rel="stylesheet" type="text/css" href="styles/error.css"/> 
         </head>
         <body><div class="page_msg">   
          <div class="inner">      
            <span class="msg_icon_wrp">
            <i class="icon80_smile"></i></span>    
                <div class="msg_content">
                <h4>该链接无法访问，请稍后再试</h4>   
                     </div>   
                      </div></div></body></html>


