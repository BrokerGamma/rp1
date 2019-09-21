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

    //设置option
    echart.setOption({
        title : {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:234, name:'联盟广告'},
                    {value:135, name:'视频广告'},
                    {value:1548, name:'搜索引擎'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    })

</script>
</html>
