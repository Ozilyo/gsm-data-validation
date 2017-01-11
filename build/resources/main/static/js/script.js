(function(window, google) {
	var longitude = document.getElementById('lng').value;
	var latitude = document.getElementById('lat').value;
	var siteName = document.getElementById('sitename').value;
	var lo = parseFloat(longitude);
	var la = parseFloat(latitude);

	var uluru = {
		lat : la,
		lng : lo
	};

	var options = {
		zoom : 16,
		scrollWheel : true,
		diableDefaultUI : true,
		// minZoom: 14,
		// maxZoom: 17,

		center : uluru,
		draggable : true,
		mapTypeId : 'satellite'

	}
	
	var contentString = '<div id="content">'+
    '<div id="siteNotice">'+
    '</div>'+
    '<h4>'+siteName+'</h4>'+
    '<p>Site Info: </p>' +
    '<p>Saftey Concerns: </p>' +
    '</div>'+
    '</div>';
	
	var infowindow = new google.maps.InfoWindow({
        content: contentString
      });
	var map = new google.maps.Map(document.getElementById('map'), options);
	var marker = new google.maps.Marker({
		position : uluru,
		map : map,
		animation: google.maps.Animation.DROP,
		title: siteName,
//		icon: 'https://drive.google.com/open?id=0B82sqhdpTGksN203dC1mV2pQRDg'
	});
	 marker.addListener('click', function() {
         infowindow.open(map, marker);
       });
	
	var ctaLayer = new google.maps.KmlLayer('https://drive.google.com/open?id=0B82sqhdpTGksS1V6ZmJOdndwQmM');
    ctaLayer.setMap(map);
}(window, google));
