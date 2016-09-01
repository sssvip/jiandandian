<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>双体系结业晚会</title>
<!-- Bootstrap -->
<style type="text/css">
html {
	position: relative;
	min-height: 100%;
}

body {
	padding-top: 100px;
}

.carousel img {
	width: 100%
}

.carousel {
	height: 400px;
	background-color: #000;
	margin-bottom: 50px;
}

.carousel .item {
	background-color: #000;
	height: 400px;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	/* Set the fixed height of the footer here */
	height: 60px;
	background-color: black;
}

.container .text-muted {
	margin: 20px 0;
}
#randomcodeimg{
	cursor:pointer;
}
</style>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
      <![endif]-->
</head>
<body>

	<%@include file="nav.jsp"%>

	<div class="container">
		<form action="register.jsp" class="form-horizontal">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">学号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="username"
						placeholder="text">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码(身份证后位)</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password"
						placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<label for="randomcode" class="col-sm-2 control-label">验证码</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="randomcode"
						placeholder="text">
				</div>
				<div class="col-sm-1">
					<img id="randomcodeimg" src="<%=request.getContextPath()%>/servlet/RandomCode"
						onclick="JavaScript:this.src='<%=request.getContextPath()%>/servlet/RandomCode?tm='+Math.random()"
						title="点击刷新">
				</div>
			</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">签到</button>
		</div>
	</div>
	</form>
	</div>

	<%@include file="footer.jsp"%>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>