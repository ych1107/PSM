<%--
  Created by IntelliJ IDEA.
  User: 78027
  Date: 2019/12/5
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="static/js/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
    $(function () {
        var compname=[];
        var count=[];
        $.ajax({
            url: "${pageContext.request.contextPath}/dc/jsonList",
            success:function (msg) {
                $(msg.map.list).each(function (index, item) {
                    compname.push(item.dacname)
                    count.push(item.daturnover);
                })
                var myChart = echarts.init(document.getElementById('main'));
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '各公司营业额',
                        subtext: '营业额'
                    },
                    tooltip: {},
                    legend: {
                        data:['销量']
                    },
                    xAxis: {
                        data: compname
                    },
                    yAxis: {
                        axisLabel:{
                            formatter:'{value} 亿元'
                        }
                    },
                    series: [{
                        name: '营业额',
                        type: 'bar',
                        data: count
                    }]
                };
                myChart.setOption(option);
            }
        })
    })
</script>
<body>
<div id="main" style="width: 600px;height:400px;"></div>
</body>
</html>
