<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String paths=request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+"/";
%>
<!DOCTYPE html>
<!--
BeyondAdmin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.4
Version: 1.4
Purchase: http://wrapbootstrap.com
-->

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
    <meta charset="utf-8" />
    <title>保险系统</title>
    <base href="<%=basePath%>">
    <meta name="description" content="Dashboard" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">
    <!--Basic Styles(基础样式)-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="#" rel="stylesheet" />
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <link href="assets/css/weather-icons.min.css" rel="stylesheet" />
    <!--Beyond styles(样式)-->
    <link id="beyond-link" href="assets/css/beyond.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/demo.min.css" rel="stylesheet" />
      <link href="assets/css/fonts.css" rel="stylesheet" type="text/css">
    <link href="assets/css/typicons.min.css" rel="stylesheet" />
    <link href="assets/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="#" rel="stylesheet" type="text/css" />
    <link href="policyJs/jedate/skin/loading.css" rel="stylesheet" />
    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <!-- 皮肤脚本:这个脚本在头部皮肤和rtl支持加载脚本 -->
    <script src="assets/js/skins.min.js"></script>
    <script type="text/javascript" src="assets/login_style/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="policyJs/PJLoad.js"></script>
    <script type="text/javascript" src="policyJs/cookie_util.js"></script>
    <script type="text/javascript" src="assets/lmx_js/lmx.js"></script>
    <script type="text/javascript" src="policyJs/loadMenu.js"></script>
    <script type="text/javascript">
	function cookieTest(){
	   var cookieArray=document.cookie.split("; ");
	     var cookie=new Object();
	     for (var i=0;i<cookieArray.length;i++){
	    	 if(cookieArray[i]==""){
	    		 location.reload();//刷新当前页面
	    	 }
	      }
	}
	</script>
</head>
<!-- /Head -->
<!-- Body -->
<body onclick="cookieTest()">
    <!-- Loading Container -->
    <div class="loading-container">
        <div class="loader"></div>
    </div>
    <!--  /Loading Container -->
    <!-- 导航栏 -->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="navbar-container">
                <!-- Navbar Barnd -->
                <div class="navbar-header pull-left">
                    <a href="javascript:;" class="navbar-brand">
                        <small>
                            <img id="mainLogo" src="assets/img/logo.png" alt="" />
                        </small>
                    </a>
                </div>
                <!-- /Navbar Barnd -->
                <!-- Sidebar Collapse -->
                <div class="sidebar-collapse" id="sidebar-collapse">
                    <i class="collapse-icon fa fa-bars"></i>
                </div>
                <div class="sidebar-collapse" id="sidebar-collapse">
                    <i class="collapse-icon fa fa-bars"></i>
                </div>
                <!-- /Sidebar Collapse -->
                <!-- Account Area and Settings --->
                <div class="navbar-header pull-right">
                    <div class="navbar-account">
                        <ul class="account-area">
                        	<li>
                        		<a>
                        			<div class="avatar">
                        				<i class="icon  glyphicon glyphicon-bell"></i>
                        			</div>
                        		</a>
                        	</li>
                        	<li>
                        	<!-- 投放公告的重要信息 -->
                        		<a  id="headerBulletin">
									<!--<marquee scrollamount=2 width=30% height=20 direction="left"><i class="icon fa" id="headerBulletin"></i></marquee>
                        			<div id="marqueeMain" style="width:400px; position:relative; white-space:nowrap; overflow:hidden; height:100%;"> 
										<div id="noticeList" style="position:absolute; top:0; height:20px;"><i class="icon fa" id="AheaderBulletin"></i></div> 
									</div>
                        			-->
                        		</a>
                        	</li>
                            <li>
                                <a class="login-area dropdown-toggle" data-toggle="dropdown">
                                     <div class="avatar" title="账号信息">
                                        <img src="assets/img/avatars/adam-jansen.jpg">
                                    </div>
                                    <section>
                                        <h2><span class="profile"><span style="width: 80px">
                                       333
                                       </span></span></h2>
                                       <div style="display: none;" id="currentUserCustomerID" name="222">
                                       </div>
                                    </section>
                                </a>
                                <!--Login Area Dropdown-->
                                <ul class="pull-right dropdown-menu dropdown-arrow dropdown-login-area">
                                    <li class="email"><a>111</a></li>
                                    <!--Avatar Area-->
                                    <li>
                                        <div class="avatar-area">
                                            <img src="assets/img/avatars/adam-jansen.jpg" class="avatar" onclick="getcookie();">
                                            <span class="caption">Change Photo</span>
                                        </div>
                                    </li>
                                    <!--Avatar Area-->
                                    <li class="edit">
                                        <a href="javascript:;" class="pull-right">主题</a>
                                    </li>
                                    <!--Theme Selector Area-->
                                    <li class="theme-area">
                                        <ul class="colorpicker" id="skin-changer">
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#5DB2FF;" rel="assets/css/skins/blue.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#2dc3e8;" rel="assets/css/skins/azure.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#03B3B2;" rel="assets/css/skins/teal.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#53a93f;" rel="assets/css/skins/green.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#FF8F32;" rel="assets/css/skins/orange.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#cc324b;" rel="assets/css/skins/pink.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#AC193D;" rel="assets/css/skins/darkred.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#8C0095;" rel="assets/css/skins/purple.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#0072C6;" rel="assets/css/skins/darkblue.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#585858;" rel="assets/css/skins/gray.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#474544;" rel="assets/css/skins/black.min.css"></a></li>
                                            <li><a class="colorpick-btn" href="javascript:;" style="background-color:#001940;" rel="assets/css/skins/deepblue.min.css"></a></li>
                                        </ul>
                                    </li>
                                    <!--/Theme Selector Area-->
                                    <li class="dropdown-footer">
                                        <a href="exit.do">退出系统 </a>
                                    </li>
                                </ul>
                                <!--/Login Area Dropdown-->
                            </li>
                            <!-- /Account Area -->
                            <!--Note: notice that setting div must start right after account area list.
                            no space must be between these elements-->
                            <!-- Settings -->
                        </ul><div class="setting">
                            <a id="btn-setting" title="Setting" href="javaScript:;">
                                <i class="icon glyphicon glyphicon-cog"></i>
                            </a>
                        </div><div class="setting-container">
                            <label title="固定导航">
                                <input type="checkbox" id="checkbox_fixednavbar">
                                <span class="text">导航</span>
                            </label>
                            <label title="固定侧栏">
                                <input type="checkbox" id="checkbox_fixedsidebar">
                                <span class="text">侧栏</span>
                            </label>
                            <label title="固定路径">
                                <input type="checkbox" id="checkbox_fixedbreadcrumbs">
                                <span class="text">路径</span>
                            </label>
                            <label title="固定页首">
                                <input type="checkbox" id="checkbox_fixedheader">
                                <span class="text">页首 </span>
                            </label>
                        </div>
                        <!-- Settings -->
                    </div>
                </div>
                <!-- /Account Area and Settings -->
            </div>
        </div>
    </div>
    <!-- /内容栏---（主容器） -->
    <!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">
            <!-- Page Sidebar -->
            <div class="page-sidebar" id="sidebar">
                <!-- Sidebar Menu -->
                		<!-- 加载菜单列表-->
                <!-- /Sidebar Menu -->
            </div>
            <div class="page-content">
                <!-- Page Breadcrumb (页眉)-->
                <!-- /Page Breadcrumb -->
                <!-- Page Header-->
                <div class="page-header position-relative">
                	<ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a style="cursor:pointer" id="main" onclick="pageJumpLoad(this)">主页</a>
                        </li>
                        <li class="active" id="page_path" name="home"></li><!-- 这个是一个空格 -->
                        <li id="page_title" name="main"></li>
                    </ul>
                    <div class="header-buttons">
                        <a class="sidebar-toggler" style="cursor:pointer">
                            <i class="fa fa-arrows-h"></i>
                        </a>
                        <a class="refresh" id="refresh-toggler" style="cursor:pointer" onclick="fresh_page();">
                            <i class="glyphicon glyphicon-refresh"></i>
                        </a>
                        <a class="fullscreen" id="fullscreen-toggler" style="cursor:pointer">
                            <i class="glyphicon glyphicon-fullscreen"></i>
                        </a>
                    </div>
                </div>

                <!-- Page Body -->
                <div class="page-body" id="pageMain">
                	<!-- 加载表格内容 -->
                </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->

        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>
    <!--Success Modal(成功时弹出的提醒框)-->
    <div id="modal-success" class="modal modal-message modal-success fade" style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <i class="glyphicon glyphicon-check"></i>
                </div>
                <div class="modal-title"></div>
                <div class="modal-body" id="model_success_message"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal" onclick="alert_success_ok()">OK</button>
                </div>
            </div> <!-- / .modal-content -->
        </div> <!-- / .modal-dialog -->
    </div>
    <!--End Success Modal Templates-->
    	<!--错误时弹出的提醒框-->
    <div id="modal-warning" class="modal modal-message modal-warning fade" style="display: none;" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <i class="fa fa-warning"></i>
                </div>
                <div class="modal-title"></div>
                <div class="modal-body" id="alert_text"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="alert_Warning_ok()">OK</button>
                </div>
            </div> <!-- / .modal-content -->
        </div> <!-- / .modal-dialog -->
    </div>
    <script type="text/javascript">
    	loadMenu();//加载菜单栏
    </script>
    <!--Basic Scripts(基本的脚本)-->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/slimscroll/jquery.slimscroll.min.js"></script>
    <!--Beyond Scripts(Beyond的脚本)-->
    <script src="assets/js/beyond.js"></script>
    <!--Page Related Scripts(页面相关的脚本)-->
    <script src="assets/js/toastr/toastr.js"></script>
    <!--Sparkline Charts Needed Scripts-->
    <script src="assets/js/charts/sparkline/jquery.sparkline.js"></script>
    <script src="assets/js/charts/sparkline/sparkline-init.js"></script>
    <script type="text/javascript">
    $("#pageMain").empty();
    $("#pageMain").load("home.do");
    </script>
    <div class="" id="fad_in"></div>
<script type="text/javascript">
	$(document).keydown(function(event){
	if(event.keyCode==13){
	$("#btn_FindBYData").click();
	}
	})
</script>
<script type="text/javascript">
insuranceCache();
</script>
</body>
<!--  /Body -->
<!--  -->
<!-- Mirrored from beyondadmin-v1.4.s3-website-us-east-1.amazonaws.com/ by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 07 May 2015 08:22:34 GMT -->
</html>
