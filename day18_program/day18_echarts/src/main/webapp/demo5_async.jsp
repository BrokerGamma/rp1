<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%--
        需求: 使用jQuery异步加载data.json中的数据,展示到柱状图报表中

        实现步骤:
        1.引入jquery的类库, echarts.js类库
        2.body中创建div 设置宽高
        3.编写一个jQuery的页面加载,请求data.json数据,
        在回调函数中,将数据设置到echarts setOption 中的属性
    --%>
    <script src="jquery-1.11.0.js"></script>
    <script src="echarts.js"></script>


</head>
<body>
    <div id="mychart" style="width: 600px; height: 400px;"></div>
</body>
    <script>
        var echart = echarts.init(document.getElementById("mychart"));

        //发送ajax请求,在回调函数中对option进行设置
        $.get("/data.json?id="+Math.random(),function(data){

            echart.setOption({
                xAxis: {
                    type: 'category',
                    data: data.xData
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: data.seriesData,
                    type: 'bar'
                }]
            })
        })



    </script>
</html>
