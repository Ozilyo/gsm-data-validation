/**
 * 
 */


$(document).ready(function ()
{
	var latitude = $('#lat').val();
	var longitude = $('#lng').val();
	
	
});


function initMap() {
    var uluru = {lat: latitude, lng: longitude};
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 16,
      center: uluru
    });
    var marker = new google.maps.Marker({
      position: uluru,
      map: map
    });
  }