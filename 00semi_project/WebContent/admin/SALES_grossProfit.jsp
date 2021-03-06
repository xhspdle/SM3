<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<input type="hidden" value="SALES_grossProfit" id="here">
<!-- Load D3.js -->
<script src="https://d3js.org/d3.v4.min.js"></script>
<!-- Load billboard.js with style -->
<script src="<c:url value='/js/billboard.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/css/billboard.css'/>">

<div style="margin-top:10%;">
	<div class="row">
		<h1>매출총이익 추이</h1>
		<div class="center">
			<div id="CombinationChart"></div>
			<strong>매출총이익 차트</strong>
		</div>
	</div>
</div>

<script>
	var xhr=null;
	function chartReport(){
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open('get', 'saleReport.do?cmd=month', true);
		xhr.send();
	}
	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			var txt=xhr.responseText;
			var json1=JSON.parse(txt);
			var chart = bb.generate({
				  data: {
				    json: [
				    	json1[0],
				    	json1[1],
				    	json1[2],
				    	json1[3],
				    	json1[4],
				    	json1[5]
				    ],
				    keys: {
				    	x: "x1",
				    	xFormat: "%Y-%m",
				    	value: ["grossCost", "grossSale", "orderCnt", "inCnt"]
				    },
				    type: "bar",
				    types: {
					    orderCnt: "spline",
					    inCnt: "line",
					    grossCost: "bar",
					    grossSale: "bar"
				    },
				    groups: [
				      [
				        "grossCost",
				        "grossSale"
				      ]
				    ],
				    axes: {
				    	grossSale: "y",
				    	inCnt: "y2"
				    }
				  },
				  axis: {
					x: {
						type: "category"
					},
					y2: {
						show: true
					}
				  },
				  bindto: "#CombinationChart"
				});
		}
	}
	
	<%-- 
	var chart = bb.generate({
		  data: {
			x: "x",
			xFormat: "%Y-%m",
		    columns: [
		    ["x", "2018-03", "2018-04", "2018-05", "2018-06", "2018-07", "2018-08"],
			["매출원가", 30, 20, 50, 40, 60, 50],
			["매출액", 200, 130, 90, 240, 130, 220],
			["판매량", 300, 200, 160, 400, 250, 250],
			["입고량", 200, 130, 90, 240, 130, 220]
		    ],
		    type: "bar",
		    types: {
		      판매량: "spline",
		      입고량: "line",
		      매출원가: "bar",
		      매출액: "bar"
		    },
		    groups: [
		      [
		        "매출원가",
		        "매출액"
		      ]
		    ]
		  },
		  axis: {
			x: {
				type: "timeseries",
				localtime: false,
				tick: {
					format: "%Y-%m"
				}
			}	  
		  },
		  bindto: "#CombinationChart"
		});
	--%>
</script>