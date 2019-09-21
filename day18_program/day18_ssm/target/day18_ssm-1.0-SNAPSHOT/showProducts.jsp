<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
       1.引入jQuery.js   echarts.js文件
       2.编写一个div  设置id 宽高
       3.编写一个jQuery 页面加载
       4.发送ajax请求
   --%>
    <script src="js/jquery-1.11.0.js"></script>
    <script src="js/echarts.js"></script>

    <script>
        //1.初始化echart对象
        var echart ;
        //页面加载
        $(function(){
            echart = echarts.init(document.getElementById("mychart"));
            loadData();
            window.setInterval(loadData,3000);
        })

        function loadData(){
            //2.发送ajax请求
            $.post("productList.action",function(data){
                //3.设置option
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
                });
            })
        }




    </script>

</head>
<body>
    <div id="mychart" style="width: 600px; height: 400px;"></div>
</body>
</html>
