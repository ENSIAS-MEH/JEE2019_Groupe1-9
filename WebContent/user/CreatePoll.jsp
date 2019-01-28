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
<meta property='og:title' content='Create your poll for free - Premium Poll Script' />
<meta property='og:description' content='The best poll script that you will ever find on the internet. It comes packed with tones of awesome features. Give it a try!' />
<title>Create your poll for free - Azerf Poll</title>

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
    <link href="../themes/default/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../themes/default/style.css">
    <link rel="stylesheet" type="text/css" href="../themes/default/css/widgets.css">
    <link rel="stylesheet" type="text/css" href="../static/js/flat/_all.css">
    <link rel="stylesheet" type="text/css" href="../static/js/chosen.min.css">

    <script type="text/javascript" src="../static/js/jquery.min.js?v=1.11.0"></script>
    <script type="text/javascript" src="../static/js/chosen.min.js?v=0.8.5"></script>
    <script type="text/javascript" src="../static/js/icheck.min.js?v=1.0.1"></script>
    <script type="text/javascript" src="../static/js/jquery-ui.min.js?v=1.10.3"></script>
    <script type="text/javascript" src="../static/bootstrap.min.js"></script>
    <script type="text/javascript" src="../static/application.fn.js?v=1.0"></script>
<script>
      var appurl="https://gempixel.com/polls";
      var token="703dbf82c57d85152e84d99365a0494a";
            var max_count= 10;      
          </script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans|Ubuntu+Mono|Droid+Sans+Mono|Montez' rel='stylesheet' type='text/css'>
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class='dark'>
<div>
<form action="ControllerCreatpoll" method="post">
<header>
<div class="navbar" role="navigation">
<div class="container">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
<span class="glyphicon glyphicon-list"></span>
</button>
<div class="site_logo">
<a class="navbar-brand" href="https://gempixel.com/polls">Premium Poll Script</a>
</div>
</div>
<div class="navbar-collapse collapse">
<ul class="nav navbar-nav pull-right">
<li><a href="https://gempixel.com/polls/user/register" class="active">Get Started</a></li>
<li><a href="https://gempixel.com/polls/user/login">Login</a></li>
</ul>
</div>
</div>
</div>
</header>
<section>
<div class="container create">
<div class="row">
<div class="col-md-5">
<div class="box-holder">
<form role="form" class="live_form" id="create-poll" method="post" action="https://gempixel.com/polls/create">
<div id="container_questions" class="tabbed">
<div class="form-group">
<label for="questions">Your Poll</label>
<span class="help-block">Description:</span>
<input type="text" class="form-control" id="description" name="description">
<span class="help-block">Duration:</span>
<input type="text" class="form-control" id="duration" name="duration">
<span class="help-block">Category:</span>
<input type="text" class="form-control" id="category" name="category">
<span class="help-block">Type:</span>
<input type="text" class="form-control" id="type" name="type">
</div>
<div class="form-group" id="widget_answers">
<label>Choices</label>
<span class="help-block">Leave fields empty to ignore options. No HTML allowed. Invalid answers will be ignored.</span>
<ul id="sortable">
<li id="poll_sort_1">
<div class="input-group">
<span class="input-group-addon"><i class="glyphicon glyphicon-move"></i></span>
<input type="text" class="form-control" name="option[]">
</div>
</li>
<li id="poll_sort_2">
<div class="input-group">
<span class="input-group-addon"><i class="glyphicon glyphicon-move"></i></span>
<input type="text" class="form-control" name="option[]">
</div>
</li>
<li id="poll_sort_3">
<div class="input-group">
<span class="input-group-addon"><i class="glyphicon glyphicon-move"></i></span>
<input type="text" class="form-control" name="option[]">
</div>
</li>
</ul>
</div>

<input type="submit"  value="create" name="actionn"  /> 
<input type="submit"  value="creat" name="actionn"  /> 

<a href="#" id="add-field" class="btn btn-transparent"><small>Add choice</small></a>
</div>
<div id="customize" class="tabbed">
<ul class="form_opt" data-id="share" data-callback="update_share">
<li class="label">Sharing <small>Allows users to share and embed poll.</small>
</li>
<li><a href="#" class="last" data-value="0">No</a></li>
<li><a href="#" class="first current" data-value="1">Yes</a></li>
</ul>
<input type="hidden" name="share" id="share" value="1">
<ul class="form_opt" data-id="results" data-callback="update_results_button">
<li class="label">Show Results <small>Allows users to view results.</small>
</li>
<li><a href="#" class="last" data-value="0">No</a></li>
<li><a href="#" class="first current" data-value="1">Yes</a></li>
</ul>
<input type="hidden" name="results" id="results" value="1">
<ul class="form_opt" data-id="choice" data-callback="update_choice_type">
<li class="label">Multiple Choices <small>Allows users to choose more than one option.</small>
</li>
<li><a href="#" class="last current" data-value="0">No</a></li>
<li><a href="#" class="first" data-value="1">Yes</a></li>
</ul>
<input type="hidden" name="choice" id="choice" value="0">
<ul class="form_opt" data-id="choice" data-callback="update_choice_type">
<li class="label">Multiple Votes <small>Allows users to vote more than once</small>
</li>
<li><a href="https://gempixel.com/polls/upgrade" class='pull-right round'>Upgrade</a></li>
</ul>
<div class="form-group">
<label for="pass">Password <a href="https://gempixel.com/polls/upgrade" class='pull-right'><small>(Upgrade)</small></a></label>
<input type="text" class="form-control" id="pass" placeholder="Please upgrade to a premium package to unlock this feature." disabled>
</div>
<div class="form-group">
<label for="expires">Expires in</label>
<select id="expires" name="expires">
<option value="0">Never</option>
<option value="1h">1 hour</option>
<option value="5h">5 hours</option>
<option value="1d">1 day</option>
<option value="5d">5 days</option>
<option value="1w">1 week</option>
<option value="5w">5 weeks</option>
</select>
</div>
<button type="button" data-id="container_questions" class="btn btn-success tabs">&larr; Questions</button>
<button type="button" data-id="theme" class="btn btn-primary tabs pull-right">Theme &rarr;</button>
</div>
<div id="theme" class="tabbed">
<h3>Simple</h3>
<ul class="themes">
<li class="dark"><a href="#" data-class="dark">Dark</a></li>
<li class="light"><a href="#" data-class="light">Light</a></li>
<li class="blue"><a href="#" data-class="blue" class="current">Blue</a></li>
<li class="red"><a href="#" data-class="red">Red</a></li>
<li class="green"><a href="#" data-class="green">Green</a></li>
<li class="yellow"><a href="#" data-class="yellow">Yellow</a></li>
</ul>
<h3>Boxed</h3>
<ul class="themes">
<li class="dark"><a href="#" data-class="bs dark">Dark</a></li>
<li class="light"><a href="#" data-class="bs light">Light</a></li>
<li class="blue"><a href="#" data-class="bs blue">Blue</a></li>
<li class="red"><a href="#" data-class="bs red">Red</a></li>
<li class="green"><a href="#" data-class="bs green">Green</a></li>
<li class="yellow"><a href="#" data-class="bs yellow">Yellow</a></li>
</ul>
<h3>Inline</h3>
<ul class="themes">
<li class="dark"><a href="#" data-class="is dark">Dark</a></li>
<li class="light"><a href="#" data-class="is light">Light</a></li>
<li class="blue"><a href="#" data-class="is blue">Blue</a></li>
<li class="red"><a href="#" data-class="is red">Red</a></li>
<li class="green"><a href="#" data-class="is green">Green</a></li>
<li class="yellow"><a href="#" data-class="is yellow">Yellow</a></li>
</ul>
<input type="hidden" name="theme" value="" id="poll_theme_value">
<br>
<div class="form-group">
<label for="background">Custom Image Background URL</label>
<input type="text" class="form-control" name="background" value="" id="background" placholder="e.g. http://mysite.com/background.png">
</div>
<div class="form-group">
<label for="font">Font</label>
<select id="font" name="font" class="choose_font">
<option value="null">Default</option>
<option value="open_sans">Open Sans</option>
<option value="ubuntu_mono">Ubuntu Mono</option>
<option value="droid_sans_mono">Droid Sans Mono</option>
<option value="montez">Montez</option>
</select>
</div>
<button type="button" data-id="customize" class="btn btn-success tabs">&larr; Customize</button>
<input type='hidden' name='token' value='8fe8fcb4107a8ea8521590b076cdeaf69d047a81' /> <button type="submit" class="btn btn-primary pull-right">Create</button>
</div>
</form>
</div>
</div>

<div class="col-md-7">
<div id="poll_widget">
<a href="#embed" id="poll_embed">Embed</a>
<div id="poll_embed_holder" class="live_form">
<div class="input-group">
<span class="input-group-addon">Share</span>
<input type="text" class="form-control" value="Your permalink will show up here">
</div>
<div class="input-group">
<span class="input-group-addon">Embed</span>
<input type="text" class="form-control" value="Your embed code will show up here">
</div>
<div class="input-group">
<a href="#" class="btn btn-transparent">Share on Twitter</a>
<a href="#" class="btn btn-transparent">Share on Facebook</a>
</div>
</div>
<div id="poll_question">
<h3>Question</h3>
</div>
<ul id="poll_answers"></ul>
<div id="poll_button">
<button class="btn btn-widget">Vote</button>
<button class="btn btn-widget" id="view_results_button">View Results</button>
<span class="branding pull-right">
Powered by <a href="https://gempixel.com/polls">Premium Poll Script</a>
</span>
</div>
</div>
<div class='ads ad468'><img src="http://placehold.it/468x60/E8117F/FFFFFF"></div> </div>
</div>
</div>
</section> <section>
<div class="container">
<footer class="row">
<div class="pull-right footer">
<div class="languages">
<a href="#lang" class="active" id="show-language"><i class="glyphicon glyphicon-globe"></i> Language</a>
<div class="langs">
<a href='?lang=en'>English</a><a href='?lang=jp'>Japanese</a><a href='?lang=de'>German</a><a href='?lang=vn'>Vietnamese</a><a href='?lang=it'>Italian</a><a href='?lang=kr'>Korean</a><a href='?lang=ro'>Romanian</a><a href='?lang=tu'>Turkish</a><a href='?lang=ru'>Russian</a><a href='?lang=es'>Spanish</a><a href='?lang=sw'>Swedish</a><a href='?lang=fr'>French</a> </div>
</div>
</div>
<p>&copy; 2019 <a href="https://gempixel.com/polls">Premium Poll Script</a></p>
</footer>
</div>
</section>
<script type="text/javascript" src="https://gempixel.com/polls/static/application.js?v=1.0"></script>

</form>
</div>
</body>
</html>