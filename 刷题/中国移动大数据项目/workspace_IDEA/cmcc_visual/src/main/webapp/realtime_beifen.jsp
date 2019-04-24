<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>demo</title>
    <!-- 引入 ECharts 文件 -->

</head>
<body>
<h1>每分钟实时充值统计</h1>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/echarts2.x/echarts-all.js"></script>
<script type="text/javascript">var timeTicket;var timeOutTicket</script>
<script type="text/javascript">

    var now = new Date();

    function pad2(n) { return n < 10 ? '0' + n : n }
    function generateTimeRequestNumber(date) {
        return date.getFullYear().toString() + pad2(date.getMonth() + 1) + pad2(date.getDate()) + pad2(date.getHours()) + pad2(date.getMinutes());//+ pad2(date.getSeconds());
    }
	// 初始化图标对象
    var myChart = echarts.init(document.getElementById('main'));
    myChart.setTheme("macarons");

    var option = {
        title : {
            text: '实时充值'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['充值笔数', '充值金额']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        dataZoom : {
            show : false,
            start : 0,
            end : 100
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : true,
                data : (function (){
                    var res = [];
                    var len = 10;
                    while (len--) {
                        res.unshift(generateTimeRequestNumber(now));
                        now = new Date(now - 60000);
                    }
                    return res;
                })()
            },
            {
                type : 'category',
                boundaryGap : true,
                data : (function (){
                    var res = [];
                    var len = 10;
                    while (len--) {
                        res.push(len + 1);
                    }
                    return res;
                })()
            }
        ],
        yAxis : [
            {
                type : 'value',
                scale: true,
                name : '笔数',
                boundaryGap: [0, 0]
            },
            {
                type : 'value',
                scale: true,
                name : '金额',
                boundaryGap: [0, 0]
            }
        ],
        series : [
            {
                name:'充值金额',
                type:'bar',
                xAxisIndex: 1,
                yAxisIndex: 1,
                data:(function (){
                    var res = [];
                    var len = 10;
                    while (len--) {
                        res.push(0);
                    }
                    return res;
                })()
            },
            {
                name:'充值笔数',
                type:'line',
                data:(function (){
                    var res = [];
                    var len = 10;
                    while (len--) {
                        res.push(0);
                    }
                    return res;
                })()
            }
        ]
    };

    clearInterval(timeTicket);

    timeTicket = setInterval(function () {
        var lastData = 0;
        var d = 0;

        var axisData = generateTimeRequestNumber(new Date());

        // Ajax 发送到后台，从数据库中获取数据
        $.get("minutesKpi.cmcc", { day: "20170412"},function(data){
            d = parseInt(data.money); // 充值金额
            lastData = data.counts; // 充值笔数

            // 动态数据接口 addData
            myChart.addData([
                [
                    0,        // 系列索引
                    d,        // 新增数据, [柱状态图数据]
                    false,     // 新增数据是否从队列头部插入
                    false     // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
                ],
                [
                    1,        // 系列索引
                    lastData, // 新增数据 [ 折线的数量]
                    false,    // 新增数据是否从队列头部插入
                    false,    // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
                    axisData  // 坐标轴标签, x轴的时间
                ]
            ]);
        });
    }, 60000); // setInterval 每隔60秒执行一次realTimeData()

    myChart.setOption(option);
</script>
</body>
</html>
