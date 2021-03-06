<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link href="css/commons.css" rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div id="app">

		<div class="header">
			<h1 class="site_logo">
				<a href="menu2">ユーザー 購入完了 購入履歴</a>
			</h1>



			<div class="user">
				<p class="user_name">
					<c:if test="${not empty user}">
						<p>${user.getName()}</p>
					</c:if>
				</p>
				<form class="logout_form" action="logout" method="get">
					<button class="logout_btn" type="submit">
						<img src="images/ドアアイコン.png">ログアウト
					</button>
				</form>
			</div>
		</div>

		<hr>




		<table>
			<div class="caption">
				<p>
					検索結果：
					<c:if test="${not empty productListnum}">
						<p>${productListnum}</p>
					</c:if>
					件
				</p>
			</div>

			<thead>
				<tr>
					<th>商品</th>
					<th>商品名</th>
					<th>単価</th>

					<th>再購入</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="product" items="${productList}">
					<tr>
						<td><img src="images/${ product.img }" /></td>
						<td>${ product.name }</td>
						<td>${ product.price }</td>



						<td><a class="detail_btn"
							href="./detailuser?productId=${ product.productId}">再購入</a></td>


					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>
	<footer></footer>

	<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
	<script>
		const vie = new Vue({
			el : "#app",
			data : {
				products : [ {
					ID : "10001",
					name : "マッキー(黒)",
					price : 160,
					category : "筆記具",
				}, {
					ID : "10002",
					name : "電卓",
					price : 935,
					category : "オフィス機器",
				}, {
					ID : "10003",
					name : "ホッチキス芯",
					price : 220,
					category : "事務消耗品",
				}, {
					ID : "10004",
					name : "Campus(5冊組)",
					price : 220,
					category : "紙製品",
				}, {
					ID : "10005",
					name : "地球儀",
					price : 160,
					category : "雑貨",
				}, {
					ID : "10006",
					name : "ロジカルノート(5冊組)",
					price : 386,
					category : "紙製品",
				}, {
					ID : "10007",
					name : "レジスター",
					price : 130,
					category : "オフィス用品",
				}, {
					ID : "10008",
					name : "カドケシ",
					price : 150,
					category : "筆記具",
				}, {
					ID : "10009",
					name : "アラビックヤマト",
					price : 200,
					category : "事務用品",
				}, {
					ID : "10010",
					name : "粘土",
					price : 160,
					category : "雑貨",
				}, ]
			}
		})
	</script>
</body>
</html>
