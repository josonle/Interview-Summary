<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>CMS Report</title>
</head>

<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->

<%--<div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>--%>
<div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>

<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/echarts2.x/echarts-all.js"></script>
<%--<script src="js/echarts/echarts.min.js"></script>--%>
<script src="js/echarts2.x/theme/dark.js"></script>
<script type="text/javascript">

    // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('main'));
    myChart.setTheme(dark);

    var option = {
        title : {
            text: '全国充值业务成功量分布',
            x:'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            x:'left',
            data:['成功量']
        },
        dataRange: {
//            min: 0,
//            max: 2500,
//            x: 'left',
//            y: 'bottom',
//            text:['高','低'],           // 文本，默认为数值文本
//            calculable : true

            x: 'left',
            y: 'bottom',
            splitList: [
                {start: 10000, color: '#E1022A'}, // label:自定义label   color:自定义颜色
                {start: 5000, end: 9999, color: '#E19106'},
                {start: 1000, end: 4999, color:'#6CAF00'},
                {start: 1, end: 999, color:'#A3E10A'},
                {start: 0, end: 0, color: '#C5CDDB'}
            ]// ,
            // color: ['#FF7E50', '#E09107', '#A3E00B']
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            x: 'right',
            y: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        roamController: {
            show: true,
            x: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series : [
            {
                name: '成功量',
                type: 'map',
                mapType: 'china',
                roam: false,
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data: []
            }
        ]
    };


    // ajax getting data...............
    $.get("mapIndex.cmcc", { day: "20170412"},function(data){
        option.series[0].data = data;
        // 为echarts对象加载数据
        myChart.setOption(option);
    });


</script>
</body>
</html>
