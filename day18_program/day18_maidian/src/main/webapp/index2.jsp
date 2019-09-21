<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>welcom to itheima</title>
    <script src="jquery-1.11.0.js"> </script>

    <script type="text/javascript">
        var _maq = _maq || [];
        _maq.push(['_setAccount', 'AllenWoon']);

        $(function(){
            $("a").click(function(){
                var clstag = $(this).attr("clstag");
                var _a_value = $(this).text();
                _maq.push(['_a_value',_a_value]);
                clstag = clstag.split('|');
                for (i in clstag){
                    _maq.push(['type'+i, clstag[i]]);
                }
                sendRequest();
            })
        });

        function sendRequest(){
            var ma = document.createElement('script');
            ma.type = 'text/javascript';
            ma.async = true;
            ma.src = 'http://localhost/ma.js';
            var s = document.getElementsByTagName('script')[0];
            s.parentNode.insertBefore(ma, s);
        }
    </script>

</head>
<body>
<h1 align="center">黑马程序员--云计算大数据</h1>
<a href="http://localhost/page1.html" target="_blank" clstag="click|index|page1">这是点击1</a><br/>

<a href="http://localhost/page2.html" target="_blank" clstag="click|index|page2">这是点击2</a>
</body>
</html>