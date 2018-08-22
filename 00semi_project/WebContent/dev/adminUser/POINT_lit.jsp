<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h4>적립금 및 사용내역</h4>
    <div class="tbl-breakdown">
        <table summary="주문날짜, 적립금, 포인트만료날짜에 대한 정보 제공">
            <caption>적립금 상세 내역</caption>
            <colgroup>
                <col span="2" width="50%" />
            </colgroup>
            <thead>
                <tr>
	                <th scope="col">구분</th>
	                <th scope="col">내용</th>
                </tr>
            </thead>
            <tbody>

                <tr class="tooltip_list">
                	<th scope="row">
						<strong>사용가능한 적립금</strong>
						
					</th>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- 적립금 상세 내역 Table End -->
    <div class="box-inner">
            <strong class="period">조회기간</strong>
            <span id="period_wrap"></span>
            <p>
                <label for="startdate">시작일 입력</label><input type="text" id="startdate" name="startdate" value="2018-05-21" /> ~
                <label for="enddate">종료일 입력</label><input type="text" id="enddate" name="enddate" value="2018-08-21" />
                <button type="button" id="btn_search" class="round inblack"><span>조회하기</span></button>
            </p>
        </div>

		<table summary="상품명, 결제금액, 적립일, 적립금액 표기">
			<caption>주문내역 리스트</caption>
			<colgroup>
				<col width="18%"/>
				<col width="18%">
				<col width="18%">
				<col width="18%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">주문번호</th>
					<th scope="col">유저번호</th>
					<th scope="col">주문날짜</th>
					<th scope="col">적립금</th>
					<th scope="col">포인트만료날짜</th>
				</tr>
			</thead>
			<tbody>
                <tr>
                    <td colspan="4" class="nodata">내역이 존재하지 않습니다.</td>
                </tr>
			</tbody>
		</table>
</body>
</html>