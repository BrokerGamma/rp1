<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%--1.引入echarts.js
        2.创建div
        3.编写script 里面初始化charts对象    定义option   设置option
    --%>
    <script src="echarts.js"></script>
</head>
<body>
    <div id="mychart" style="width: 600px; height: 400px;"></div>
</body>

<script>
    //初始化echart对象
    var echart = echarts.init(document.getElementById("mychart"));

    //定义option
    //var option = ;

    //设置option
    echart.setOption({
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    })

</script>
</html>
