<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--执行管理员登录的逻辑操作 --%>
<% 
	String adminiStrator = request.getParameter("administrator");
	String passWord = request.getParameter("passWord");
	String path=request.getContextPath();  
    String basePath=request.getScheme()+"://"+request.getServerName() +":"+request.getServerPort()+path+"/";  

    request.setCharacterEncoding("utf-8");  
    
    if("AnimA".equals(adminiStrator) && "123456".equals(passWord)){  
        session.setAttribute("loginUsername", adminiStrator);  
        session.setAttribute("loginUser",adminiStrator);  
        request.getRequestDispatcher("MyMain.jsp").forward(request,response);  
    }else{  
        response.sendRedirect("logfailure.jsp");
    }     
%>