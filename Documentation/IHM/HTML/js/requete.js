$("#connec").click(function(){
			
			$.ajax("http://localhost:5000/idGet").done(function(data){
				//debugger;
				$("#name").text(data);
			});
		});


$("#creat").click(function(){

			str=JSON.stringify($('#name').val());
			
			console.log(str)
			$.ajax({
  				type: "POST",
				url: "http://localhost:5000/idPost",
  				data: str,
  				dataType: 'text'
			});
		});

$("#connec").click(function(){

			str=JSON.stringify($('#name').val());
			
			console.log(str)
			$.ajax({
  				type: "POST",
				url: "http://localhost:5000/idIsValide",
  				data: str,
  				dataType: 'text'
			});
		});