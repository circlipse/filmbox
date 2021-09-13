<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	<img alt="영화 포스터" src="${mvImg }">
	<input type="text" id="movieCd" value="${movieCd }"> 
	<div id="result2">
		<h2>영화상세</h2>	
	</div>
	<script>
		let movie = $('#movieCd').val();
		console.log(movie);
		$.ajax({
			method : "GET",
			url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=03778b8e03b2f65d0d2c724260f2df8c&movieCd="+movie,
			
		}).done(function(msg) {
			let resultt = "";
			let short_url = msg.movieInfoResult.movieInfo;
				resultt += "<b>영화 제목 : "+short_url.movieNm+"</b>"
				resultt += "<p>제작연도: "+short_url.prdtYear+"</p>"
				resultt += "<p>상영시간 : "+short_url.showTm+"</p>"
				
			$("#result2").append(resultt);
		});
	</script> 
</body>
</html>