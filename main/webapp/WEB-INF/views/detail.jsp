<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<!-- <html> -->
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>



	<div class="header">
		<h1 class="site_logo">
			<a href="menu">管理者ダーツショッピング</a>
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

	<div class="update">
		<div class="form_body">
			<div class="img_block">
				<img src="images/${ productdetail.img}" class="product_img"><br>
			</div>
			<form:form action="detail" method="get" modelAttribute="detail">
				<fieldset class="label-130 product_block">
					<p class="error">エラーメッセージ</p>
					<div>
						<label>商品ID</label>
						<form:input type="text" path="productId" class="base-text" />
					</div>
					<div>
						<label>商品名</label>
						<form:input type="text" path="name"
							value="${ productdetail.name }" class="base-text" />
					</div>
					<div>
						<label>単価</label>
						<form:input type="text" path="price"
							value="${ productdetail.price }" class="base-text" />
					</div>
					<div>
						<label>カテゴリ</label>
						<form:input type="text" path="categoryId"
							value="${ productdetail.categoryId }" class="base-text" />
					</div>
					<div>
						<label>画像</label>
						<form:input type="text" path="img" value="${ productdetail.img }"
							class="base-text" />
					</div>
					<div>
						<label>商品説明</label>
						<textarea name="description" class="base-text"
							style="background-color: rgb(209, 209, 209);">

            </textarea>
					</div>
				</fieldset>
				<div>
					<div class="btns">
						<input type="button" name="buy" onclick="openModal()" value="購入"
							class="basic_btn" />

						<form:button name="delete">削除</form:button>
						<form:button name="update">編集</form:button>
						<a href="menu" class="cancel_btn">戻る</a>
					</div>
					<div id="modal">
						<p class="modal_message">購入しますか？</p>
						<div class="btns">
							<button type="submit" class="basic_btn" name="buy">購入</button>
							<button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div id="fadeLayer"></div>
</body>
</html>
<script src="./js/commons.js"></script>