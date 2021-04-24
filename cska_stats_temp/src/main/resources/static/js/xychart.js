// Use themes
// Create chart instance
// var chart = am4core.createFromConfig({
//   "width": "100%",
//   "height": "300"
// },"chartdiv", am4charts.XYChart);
Xname = statsName;
var container = am4core.create("container2", am4core.Container);
container.width = am4core.percent(100);
container.height = am4core.percent(100);

// var container2 = document.getElementById("myCanv");
// var container = container2.createElement(am4core.Container);
container.layout = "vertical";


var chart = container.createChild(am4charts.XYChart);
chart.width = am4core.percent(100);
chart.dateFormatter.dateFormat = "yyyy-MM-dd";
chart.height = am4core.percent(100);

//Declare an array for stats axises
var statsAxis = [];

//Declare an array for dates axises
var datesAxis = [];

for (var i = 0; i < 3; i++)
{
	statsAxis[i] = chart.yAxes.push(new am4charts.ValueAxis());
	datesAxis[i] = chart.xAxes.push(new am4charts.DateAxis());
}

//converting input string to date listOfLists
var datesListConverted = datesList.split("*");
for (var i = 0; i < datesListConverted.length; i++) {
	datesListConverted[i] = datesListConverted[i].split(", ");
	for (var j = 0; j < datesListConverted[i].length; j++) {
		datesListConverted[i][j] = new Date(datesListConverted[i][j]);
	}
	console.log(datesListConverted[i]);
}

//converting input string to a float listOfLists
countList = countList.toString(2);
countList = countList.split("*");
for (var i = 0; i < countList.length; i++) {
	countList[i] = countList[i].split(", ");
	for (var j = 0; j < countList[i].length; j++) {
		countList[i][j] = parseFloat(countList[i][j]);
	}
	console.log(countList[i]);
}


//converting input string to a float listOfLists
statsList = statsList.toString();
statsList = statsList.split("*");
for (var i = 0; i < statsList.length; i++) {
	statsList[i] = statsList[i].split(", ");
	for (var j = 0; j < statsList[i].length; j++) {
		statsList[i][j] = parseFloat(statsList[i][j]);
	}
	console.log(statsList[i]);
}




// Create series
var series = [];
chart.colors.list = [
  am4core.color("#845EC2"),
  am4core.color("#D65DB1"),
  am4core.color("#FF6F91"),
  am4core.color("#FF9671"),
  am4core.color("#FFC75F"),
  am4core.color("#F9F871")
];
if (showAverage.localeCompare("true") == 0) {
	var seriesAverage = [];
} 
var playersCommitedList = playersCommited.split(",");
for (var i=0; i < playersCommitedList.length; i++){
	var sum = 0;
	series[i] = chart.series.push(new am4charts.LineSeries());
	series[i].name = playersCommitedList[i];
	series[i].tooltipText = "{name}\n{dateX}: {valueY}";
	series[i].dataFields.dateX = "dates";
	series[i].dataFields.valueY = "stats";
	series[i].strokeWidth = 3;
	series[i].tensionX = 0.8;
	datesAxis[i].title.text = "Dates";
	datesAxis[i].renderer.minGridDistance = 50;
statsAxis[i].title.text = Xname;
statsAxis[i].calculateTotals = true;
statsAxis[i].renderer.minGridDistance = 20;
statsAxis[i].renderer.labels.template.fontSize = 10;
datesAxis[i].renderer.labels.template.fontSize = 10;

//assigning the series to the axises and positioning them
	series[i].xAxis = datesAxis[i];
	series[i].yAxis = statsAxis[0];
	datesAxis[i].renderer.grid.template.location = 0;
	statsAxis[i].renderer.grid.template.location = 0;
	//syncing axises


	series[i].bullets.push(new am4charts.CircleBullet());
	if (showAverage.localeCompare("true") == 0) {
		seriesAverage[i] = chart.series.push(new am4charts.LineSeries());
		seriesAverage[i].name = playersCommitedList[i] + " СРЕДНИЕ ЗНАЧЕНИЯ";
		seriesAverage[i].dataFields.dateX = "dates";
		seriesAverage[i].dataFields.valueY = "stats";
		seriesAverage[i].tooltipText = "{name}\n{dateX}: {valueY}";
		seriesAverage[i].xAxis = datesAxis[i];
		seriesAverage[i].yAxis = statsAxis[0];
		seriesAverage[i].strokeWidth = 3;
		seriesAverage[i].tensionX = 0.8;
		// if (i > 0) 
		// {
		// 	seriesAverage[i].syncWithAxis = statsAxis[i-1];
		// }

}   
	if (i > 0) 
	{
		// datesAxis[i].syncWithAxis = datesAxis[i-1];
		// statsAxis[i].syncWithAxis = statsAxis[i-1];
		datesAxis[i].title.disabled = true;
		statsAxis[i].title.disabled = true;
	}
		for(var k = 0; k < statsList[i].length; k++)
		{
				series[i].data.push({"dates": datesListConverted[i][k],
								"stats": statsList[i][k]});	
				sum = sum + statsList[i][k];
				if (showAverage.localeCompare("true") == 0) {
					seriesAverage[i].data.push({"dates": datesListConverted[i][k],
								"stats": sum / countList[i][k]});
				} 

		}
	// chart.series.push(series[i]);
}


/* Add legend */
chart.legend = new am4charts.Legend();

/* Create a cursor */
chart.cursor = new am4charts.XYCursor();