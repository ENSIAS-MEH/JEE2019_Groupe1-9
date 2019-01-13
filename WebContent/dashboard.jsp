<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" prefix="og: http://ogp.me/ns#">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, maximum-scale=1.0" />
<meta name="description" content="The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!" />
<meta property='og:type' content='website' />
<meta property='og:url' content='https://gempixel.com/polls' />
<meta property='og:title' content='User Account - Premium Poll Script' />
<meta property='og:description' content='The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!' />
<title>User Account - Premium Poll Script</title>

<link href="https://gempixel.com/polls/themes/default/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/themes/default/style.css">
<link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/themes/default/css/widgets.css">
<link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/static/js/flat/_all.css">
<link rel="stylesheet" type="text/css" href="https://gempixel.com/polls/static/js/chosen.min.css">

<script type="text/javascript" src="https://gempixel.com/polls/static/js/jquery.min.js?v=1.11.0"></script>
<script type="text/javascript" src="https://gempixel.com/polls/static/js/chosen.min.js?v=0.8.5"></script>
<script type="text/javascript" src="https://gempixel.com/polls/static/js/icheck.min.js?v=1.0.1"></script>
<script type="text/javascript" src="https://gempixel.com/polls/static/js/jquery-ui.min.js?v=1.10.3"></script>
<script type="text/javascript" src="https://gempixel.com/polls/static/bootstrap.min.js"></script>
<script type="text/javascript" src="https://gempixel.com/polls/static/application.fn.js?v=1.0"></script>
<script>
      var appurl="https://gempixel.com/polls";
      var token="703dbf82c57d85152e84d99365a0494a";
            var max_count= 10;      
          </script>
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<form action="Controllerdashboard.jsp" method="post">
<header class="full">
<div class="navbar" role="navigation">
<div class="container-fluid">
<div class="row">
<div class="col-md-2">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
<span class="glyphicon glyphicon-align-justify"></span>
</button>
<a class="navbar-brand" href="https://gempixel.com/polls">Premium Poll Script</a>
</div>
</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav navbar-right">
<li><a href="https://gempixel.com/polls/upgrade" class="active">Upgrade</a></li>
<li><a href="https://gempixel.com/polls/create" class="active">Create your Poll</a></li>
<li><a href="https://gempixel.com/polls/user/logout">Logout</a></li>
</ul>
</div>
</div>
</div>
</div>
</header>
<section>
<div class="container-fluid">
<div class="row">
<div class="col-md-2 sidebar">
<div class="sidebar-holder">
<div class="box-holder profile">
<div class="row">
<div class="col-md-3 avatar"><img src="https://www.gravatar.com/avatar/062da5078de84305d043fb6a1d21ddd5?s=150" alt="Gravatar"></div>
<div class="col-md-9">
<a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="94fffcf5f0fdf9bae7f5f2f5f5d4f3f9f5fdf8baf7fbf9">[email&#160;protected]</a>
</div>
</div>
</div>
<form action="https://gempixel.com/polls/user/search" class="search" id="poll_search_form">
<div class="input-group">
<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
<input type="text" class="form-control" id="poll_search_q" placeholder="Search of a poll">
</div>
</form>
<ul class="nav nav-sidebar">
<li><a href="https://gempixel.com/polls/user" class="active"><span class="glyphicon glyphicon-home"></span> Dashboard</a></li>
<li><a href="https://gempixel.com/polls/user/active"><span class="glyphicon glyphicon-th-list"></span> Active Polls</a></li>
<li><a href="https://gempixel.com/polls/user/expired"><span class="glyphicon glyphicon-time"></span> Expired Polls</a></li>
<li><a href="https://gempixel.com/polls/user/settings"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
</ul>
<h3>Account info <span class="label label-primary pull-right">Free</span></h3>
<div class="stats">
<p><span>0</span> Polls</p>
<p><span>0</span> Votes</p>
</div>
</div>
</div>
<div class="col-md-10 content">
<div class='ads ad728'><img src="http://placehold.it/728x90/E8117F/FFFFFF"></div>
<div class='btn-group'>
<button type='button' class='btn btn-primary' id='select_all'>Select All</button>
<button type='button' class='btn btn-danger' id='delete_all'>Delete All</button>
</div><br><br>
<form action='https://gempixel.com/polls/user/delete' id='delete_all_form' method='post'>
<ul class='poll-list'></ul><input type='hidden' name='token' value='b334bbe96c62af26780af74cc1e01579a18c6da6' /></form> </div>
</div>
</div>
</section>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type="text/javascript" src="https://gempixel.com/polls/static/application.js?v=1.0"></script>
</form>
</body>
</html>