<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>双体系结业晚会</title>
    <!-- Bootstrap -->
    <style type="text/css">
        html {
          position: relative;
          min-height: 100%;
      }
      body{padding-top: 100px;}
      .carousel img{
        width: 100%
    }
    .carousel{
        height: 400px;
        background-color: #000;
        margin-bottom: 50px;
    }
    .carousel .item{
        background-color: #000;
        height: 400px;
    }
    .footer {
        margin-top: 100px;
        position: absolute;
        bottom: 0;
        width: 100%;
        /* Set the fixed height of the footer here */
        height: 60px;
        background-color:black;
    }
    .container .text-muted {
      margin: 20px 0;
  }
  #checkin span{margin: 10px;font-size: 20px;}
  .main{background-color: white;height: 100px;}
  #current_content{color: blue;font-size: 80px;}
  .game_btn span{font-size:30px;display: inline-block;width: 180px;height: 60px;line-height: 60px;background-color: red;color: #fff;text-align: center;border-radius: 5px;cursor: pointer; margin-bottom: 70px;}
  .game_btn span:hover{font-size:30px;display: inline-block;width: 180px;height: 60px;line-height: 60px;background-color:#B0AE06;color: #fff;text-align: center;border-radius: 5px;cursor: pointer; }
  #goodluck span{margin-left: 20px;}
  #goodluck {font-size: 20px;margin-bottom: 70px;}
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
        <div class="row">
            <div class="col-sm-9">
                <h1>已签到名单------------<span id="autoupdate">自动刷新：关</span></h1>
                <div id="checkin">

                </div>
                <div class="main">
                 <div id="current_content"></div>
             </div>
             <div class="game_btn">
                <span id="begin">开  始</span>
                <span id="stop">停  止</span>
            </div>
            <div id="showresult">
            </div>
        </div>
        <div class="col-sm-3">
            <h3>获奖名单：</h3>
            <ul id="goodluck" class="list-group">
                <li class="list-group-item">唐伟<span>2016-06-19 1:29</span></li>
                <li class="list-group-item">This is a test!</li>
                <li class="list-group-item">This is a test!</li>
                <li class="list-group-item">This is a test!</li>
                <li class="list-group-item">This is a test!</li>
                <li class="list-group-item">This is a test!</li>
            </ul>
        </div>

    </div>
</div>

<%@include file="footer.jsp"%>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
    //var data=['唐伟','高明巧','张家豪','测试人','陈仲华','常俊超'];
    //$.getJSON("http://127.0.0.1/task/servlet/Registers",function(tempdata){
     //   data=tempdata;
    //    alert(data[0].name+"-"+data[1].name+"-"+data[2].name+"-"+data[3].name+"-"+data[4].name);
    //});
var timer=null;
var status=0;
var autoupdate=false;
updataname=null;
$("#autoupdate").click(function() {
    var childrenCount=$("#checkin").children().length;
    if(autoupdate){
        clearInterval(updataname);
        autoupdate=!autoupdate;
        $(this).css("color","black");
        $(this).html("自动刷新：关");
    }else{
        $(this).css("color","red");
        $(this).html("自动刷新：开");
        updataname=setInterval(function(){
            childrenCount=$("#checkin").children().length;
            $.get("http://127.0.0.1/task/servlet/Lottery?checkcode=david&exsistcount="+childrenCount+"", function(data){
              $("#checkin").append(data);
          });
        },500);
        autoupdate=!autoupdate;
    }
});
var random=0;
$("#begin").click( function () {
    var childrenCount=$("#checkin").children().length;
    status=1;
    clearInterval(timer);
        //定义一个定时器
        timer=setInterval(function(){
            random=Math.floor(Math.random()*childrenCount); //floor去取整
            current_content.innerHTML=$("#checkin").children().eq(random).text();
        },70);
    });
$("#stop").click( function () {
    if(status==1){
          /*  $.get("http://127.0.0.1/task/servlet/Lottery?checkcode=david", function(data){
              current_content.innerHTML=data;
          });*/
clearInterval(timer);
status=0;
$("#goodluck").append("<li class='list-group-item'>"+$("#checkin").children().eq(random).text()+"</li>");
}
});
</script>

</body>
</html>