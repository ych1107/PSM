<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>对标管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>



</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>




	<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
	$(function () {

		var data = [];
		var count = [];
		$.ajax({
			type:"get",
			async:false,
			url:"${pageContext.request.contextPath}/dc/getAll",
			success:function (msg) {
				$(msg.map.list).each(function () {
					data.push(this.dacname);
					count.push(this.daturnover);
				})
			}
		})


		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));

		// 指定图表的配置项和数据
		var option = {
			title: {
				text: '营业额'
			},
			tooltip: {},
			legend: {
				data:['营业额']
			},
			xAxis: {
				data: data
			},
			yAxis: {
				axisLabel:{
					formatter:'{value}万元'
				}
			},
			series: [{
				name: '营业额',
				type: 'bar',
				data: count
			}]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	})
</script>

</body>
</html>