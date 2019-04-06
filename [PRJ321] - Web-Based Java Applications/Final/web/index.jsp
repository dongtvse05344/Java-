<html>
<body>
    <a href="../../../../../../C:/Users/xhunt/AppData/Roaming/NetBeans/8.2/apache-tomcat-8.0.27.0_base/work/Catalina/localhost/Final/org/apache/jsp/index_jsp.java"></a>
<%! int x = 0; %>
<%!
  public void jspInit() {
  System.out.println(x++);
}
%>
<%= x++ %>
<% System.out.println("=" + x); %>
<% jspInit(); %>
</body>
</html>