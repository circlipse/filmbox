<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>안녕하세요</h1>
	
	<h2>영화 전체 정보 뽑는 테스트 - 나중에 삭제할 것</h2>
	<ul id="result">
	</ul>

		<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>		
	
	<script>
		$.ajax({
			method : "GET",
			url : "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=03778b8e03b2f65d0d2c724260f2df8c&targetDt=20210825",
			data : {
				weekGb : "0"
			}
		}).done(function(msg) {
			let resultt ="";
				let short_url = msg.boxOfficeResult.weeklyBoxOfficeList[0];
				
				resultt += "<li> ";
				resultt += "<a href='/imageView/"+short_url.movieNm+"'> ";
				
				resultt += "<p>박스오피스 종류 : "+short_url.boxofficeType+"</p>"
				resultt += "<p> 상영기간 : "+short_url.showRange+"</p>"
				resultt += "<p>연도,주차 : "+short_url.yearWeekTime+"</p>"
				resultt += "<p>순번 : "+short_url.rnum+"</p>"
				resultt += "<p>박스오피스 순위 : "+short_url.rank+"</p>"
				resultt += "<p>전일대비증감분 : "+short_url.rankInten+"</p>"
				resultt += "<p>신규집입여부 : "+short_url.rankOldAndNew+"</p>"
				resultt += "<b>영화 코드 : "+short_url.movieCd+"</b><br>"
				resultt += "<b>영화 제목 : "+short_url.movieNm+"</b>"
				resultt += "<p>개봉일 : "+short_url.openDt+"</p>"
				resultt += "<p>매출액 : "+short_url.salesAmt+"</p>"
				resultt += "<p> 해당일자 상영작의 매출총액 대비 해당 영화 매출비율 : "+short_url.salesShare+"</p>"
				resultt += "<p>전일대비 매출액 증감분 : "+short_url.salesInten+"</p>"
				resultt += "<p>전일대비 매출액 증감비율 : "+short_url.salesChange+"</p>"
				resultt += "<p>누적매출액 : "+short_url.salesAcc+"</p>"
				resultt += "<p>해당일 관객 수 : "+short_url.audiCnt+"</p>"
				resultt += "<p>전일 대비 관객 수 증감분 : "+short_url.audiInten+"</p>"
				resultt += "<p>전일 대비 관객 수 증감비율 : "+short_url.audiChange+"</p>"
				resultt += "<p>누적관객수 : "+short_url.audiAcc+"</p>"
				resultt += "<p>해당일자에 상영한 스크린 수 : "+short_url.scrnCnt+"</p>"
				resultt += "<p>해당일자에 상영된 횟수 : "+short_url.showCnt+"</p>"

				resultt += "</a></li>"

			
			$("#result").append(resultt);
			console.log(resultt);
		});
	</script>

</body>
</html>