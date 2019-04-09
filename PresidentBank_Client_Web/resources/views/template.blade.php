<!DOCTYPE html>
<html class="backend">
    <head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <title>President Bank</title>
	    <meta name="author" content="pampersdry.info">
	    <meta name="description" content="Adminre is a clean and flat backend and frontend theme build with twitter bootstrap">
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	    
		@yield('css')
</head>
<body>
	@yield('head')
	@yield('body')
	@yield('foot')

@yield('js')
	<script type="text/javascript" src="{{ asset('asset/javascript/frontend/jquery-3.3.1') }}"></script>
</body>
</html>