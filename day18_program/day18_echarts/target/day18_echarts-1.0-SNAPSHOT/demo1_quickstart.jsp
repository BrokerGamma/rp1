<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%--
        echarts的入门案例:
        需求: 使用柱状图展示数据.

        实现步骤:
        1.引入echarst.js文件
        2.在body中创建一个div 给出id  给出 高度和宽度 (目的是让报表信息在该div中展示)
        3.编写script 片段,在里面编写js代码
            3.1 创建echarts 对象 ,初始化
            3.2 定义option
            3.3 设置option展示
        4.部署web项目访问看看效果
    --%>
    <script src="echarts.js"></script>

</head>
<body>
    <%-- 2.在body中创建一个div 给出id  给出 高度和宽度 (目的是让报表信息在该div中展示)--%>
    <div id="mycharts" style="height: 400px; width: 600px" />
</body>
    <script>
        /*3.编写script 片段,在里面编写js代码
            3.1 创建echarts 对象 ,初始化
            3.2 定义option
            3.3 设置option展示*/

        // 3.1 创建echarts 对象 ,初始化
        var echart = echarts.init(document.getElementById("mycharts"));
        //3.2 定义option
        var option = {
            xAxis: {
                type: 'category',
                data: ['星期一', '星期二', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [120, 200, 150, 80, 70, 110, 130],
                type: 'bar'
            }]
        };
        // 3.3 设置option展示
        echart.setOption(option);

    </script>

</html>
