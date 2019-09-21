一.导入web项目:
1.复制项目到bigdata33目录下
2.项目中 file---> project from exsiting source ...导入  默认下一步
3.缺少JDK  , file---> structure --- > Project 添加jdk
4.缺少tomcat ----> 添加tomcat  ---- HttServlet 等类报红线
5.右键项目  open module setting  ----> moudule ----->depenencies  点击 +  导入tomcat jar包  (HttpServlet红线消失)
6.项目问题:不能部署,缺少AficatId
    open module setting  ----> Facets-----> 右下角有 Create  AficatId 点击
7.部署运行即可
8.数据中执行sql语句即可.  访问: http://localhost:8080/day18_project/show.html


二.debug 查看web项目的执行流程
    //访问首页 : http://localhost:8080/day18_project/show.html



三.debug 检查web中的错误,及调试错误

