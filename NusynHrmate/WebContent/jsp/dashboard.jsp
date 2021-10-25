<%@ page language=
"java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<script>
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	exportEnabled: true,
	animationEnabled: true,
	title:{
		text: "Way Finder Statistics"
	},
	legend:{
		cursor: "pointer",
		itemclick: explodePie
	},
	data: [{
		type: "pie",
		showInLegend: false,
		toolTipContent: "{name}: <strong>{y}</strong>",
		indexLabel: "{name} - {y}",
		dataPoints: getData()
	}]
});
chart.render();


var selectionTypechart = new CanvasJS.Chart("selctiontypechartContainer", {
	exportEnabled: true,
	animationEnabled: true,
	title:{
		text: "Selection Type Statistics"
	},
	legend:{
		cursor: "pointer",
		itemclick: explodePie
	},
	data: [{
		type: "pie",
		showInLegend: false,
		toolTipContent: "{name}: <strong>{y}</strong>",
		indexLabel: "{name} - {y}",
		dataPoints: getSelectionData()
	}]
});

selectionTypechart.render();
}





function getData(){
	var data = new Array();
	//fetch data from server
	$.ajax({
		url: "getdata",
		contentType : "application/json",
		dataType : 'json',	
		async:false,
		success: function(result){
			for(var i=0;i<=result.length-1;i++){
				data.push({y:result[i].count,name:result[i].shopName});
			}		
   		 }
	});		
	return data;
}


function getSelectionData(){
	var data = new Array();
	//fetch data from server
	$.ajax({
		url: "getselectiondata",
		contentType : "application/json",
		dataType : 'json',	
		async:false,
		success: function(result){
			for(var i=0;i<=result.length-1;i++){
				data.push({y:result[i].count,name:result[i].shopName});
			}		
   		 }
	});		
	return data;
}


function explodePie (e) {
	if(typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
		e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
	} else {
		e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
	}
	e.chart.render();

}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; max-width: 920px; margin: 0px auto;"></div>
<div id="selctiontypechartContainer" style="height: 370px; max-width: 920px; margin: 0px auto;float right"></div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/canvasjs.min.js"></script>
</body>
</html>
