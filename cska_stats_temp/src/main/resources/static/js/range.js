function getVals(){
  // Get slider values
  var parent = this.parentNode;
  var slides = parent.getElementsByTagName("input");
    var slide1 = parseFloat( slides[0].value );
    var slide2 = parseFloat( slides[1].value );
  // Neither slider will clip the other, so make sure we determine which is larger
  if( slide1 > slide2 ){ var tmp = slide2; slide2 = slide1; slide1 = tmp; }
  
  var displayElement = parent.getElementsByClassName("rangeValues")[0];
  var month1 = "";
  var month2 = "";
  switch(slide1) {
  case 5: month1 = "January";
  break;
  case 6: month1 = "February";
  break;
    case 7: month1 = "March";
  break;
    case 8: month1 = "April";
  break;
    case 9: month1 = "May";
  break;
    case 1: month1 = "September";
  break;
    case 2: month1 = "October";
  break;
    case 3: month1 = "November";
  break;
    case 4: month1 = "December";
  break;
}
  switch(slide2) {
  case 5: month2 = "January";
  break;
  case 6: month2 = "February";
  break;
    case 7: month2 = "March";
  break;
    case 8: month2 = "April";
  break;
    case 9: month2 = "May";
  break;
    case 1: month2 = "September";
  break;
    case 2: month2 = "October";
  break;
    case 3: month2 = "November";
  break;
    case 4: month2 = "December";
  break;
}
      displayElement.innerHTML = month1 + " - " + month2;
}

window.onload = function(){
  // Initialize Sliders
  var sliderSections = document.getElementsByClassName("range-slider");
      for( var x = 0; x < sliderSections.length; x++ ){
        var sliders = sliderSections[x].getElementsByTagName("input");
        for( var y = 0; y < sliders.length; y++ ){
          if( sliders[y].type ==="range" ){
            sliders[y].oninput = getVals;
            // Manually trigger event first time to display values
            sliders[y].oninput();
          }
        }
      }
}