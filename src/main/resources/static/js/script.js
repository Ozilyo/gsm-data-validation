(function(window, google){
		var longitude = document.getElementById('lng').value;
    	var latitude =  document.getElementById('lat').value;
    	var lo = parseFloat(longitude);
    	var la = parseFloat(latitude);
      var uluru = {lat: la, lng: lo};
      
      var options = {
        zoom: 16,
        scrollWheel: true,
//        minZoom: 14,
//        maxZoom: 17,
        
        center: uluru,
        draggable: true,
//        mapTypeId: google.maps.MapTypeId.HYBRID,
        
      }
      
      var map = new google.maps.Map(document.getElementById('map'), options);
      var marker = new google.maps.Marker({
        position: uluru,
        map: map
      });
}(window, google));
