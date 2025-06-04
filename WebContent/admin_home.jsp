<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" /><link rel="stylesheet" href="WEB-INF/CSS/index.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="CSS/admin_home.css" rel="stylesheet">
  <script type="text/javascript" src="JS/Toggle.js"></script>
  <script type="text/javascript" src="JS/admin_home.js"></script>
</head>
<body>
<div class="container">
<ul class="nav nav-tabs nav-fill">
<li><a href="#Home">home</a></li>
<li class="has-sub"><a href="#Employee">Employee</a>
<ul class="sub-menu">
<li><a href="#EmployeeAdd"><i class="fa-solid fa-user-plus"></i> Add</a></li>
<li><a href="#EmployeeDel"><i class="fa-solid fa-user-minus"></i> Delete</a></li>
<li><a href="#EmployeeManage"><i class="fa-solid fa-users"></i> Manage</a></li>
</ul>
</li>
<li class="has-sub"><a href="#Customer">Customer</a>
<ul class="sub-menu">
<li><a href="#CustomerAdd"><i class="fa-solid fa-user-plus"></i> Add</a></li>
<li><a href="#CustomerDel"><i class="fa-solid fa-user-minus"></i> Delete</a></li>
<li><a href="#CustomerManage"><i class="fa-solid fa-users"></i> Manage</a></li>
</ul>
</li>
<li class="has-sub"><a href="#Inventory">Inventory</a>
<ul class="sub-menu">
<li><a href="#ProductAdd"><i class="fa-solid fa-cart-plus"></i> Add</a></li>
<li><a href="#ProductDel"><i class="fa-solid fa-cart-shopping"></i> Delete</a></li>
<li><a href="#ProductManage"><i class="fa-solid fa-cart-shopping"></i> Manage</a></li>
</ul>
</li>
<li class="has-sub"><a href="#Sales">Sales</a></li>
</ul>
</div>
<div id="Home" class="tab-section active"> 
<h1>Admin Dashboard</h1>
<div class="grid">
<div class="card">
<h3>Sales Summary</h3>
<p>Daily Sales: Rs. <span id="dailySales">0</span></p>
<p>Monthly Sales: Rs. <span id="monthlySales">0</span></p>
<p>Weekly Sales: Rs. <span id="weeklySales">0</span></p>
</div>
<div class="card">
<h3>Inventory Alerts</h3>
<p>Low Stock: <span id="lowStock">0</span></p>
<p>Out of Stock: <span id="outOfStock">0</span></p>
</div>
<div id="card">
<h3>Recent Transactions</h3>
<ul id="Recent Transactions"></ul>
</div>
<div id="card">
<h3>Quick Actions</h3>
<input type="button" value="Add New Employee" class="Quick-Action-Button" data-target="#EmployeeAdd">
<input type="button" value="Add New Product">
<input type="button" value="View Sales Report">
<input type="button" value="Generate Invoice">
</div>
<div id="card">
<h3>Top Selling Products</h3>
<ul id="topProducts"></ul>
</div>
<div>
<h3>Recent Activity</h3>
<ul id="activityLog"></ul>
</div>
</div>
</div>
<div id="EmployeeAdd" class="tab-section">
<h3>Add Employee</h3>
<form action="EmployeeAdd" method="post">
<label>Employee ID:</label>
<input type="text" id="e_ID" name="e_ID" class="form-control">
<label>Name:</label>
<input type="text" id="e_Name" name="e_Name" class="form-control">
<label>Phone:</label>
<input type="tel" id="e_Phone" name="e_Phone" class="form-control">
<label>Email:</label>
<input type="email" id="e_Email" name="e_Email" class="form-control">
<label>Age:</label>
<input type="number" id="e_Age" name="e_Age" class="form-control">
<label>Gender:</label><br>
<label>Male:</label>
<input type="radio" name="e_Gender" name="e_Gender" id=Male Value="Male">
<label>Female:</label>
<input type="radio" name="e_Gender" name="e_Gender" id=Female Value=Female><br>
<label>Password:</label>
<input type="password" id="e_Pass" name="e_Pass" class="form-control"><br><br>
<input type="submit" value="submit">
</form>
</div>
<div id="EmployeeDel" class="tab-section">
<h3>Delete Employee</h3>
<form action="EmployeeDel" method="post">
<label>Employee ID:</label>
<input type="text" id="de_ID" name="de_ID" class="form-control" onInput="fetchDetails()">
<label>Name:</label>
<input type="text" id="de_Name" name="de_Name" class="form-control" disabled>
<label>Phone:</label>
<input type="tel" id="de_Phone" name="de_Phone" class="form-control" disabled>
<label>Email:</label>
<input type="email" id="de_Email" name="de_Email" class="form-control" disabled>
<label>Age:</label>
<input type="number" id="de_Age" name="de_Age" class="form-control" disabled>
<input type="submit" value="submit" onClick="return conf()">
</form>
</div>
<div id="EmployeeManage" class="tab-section">
<h3>Manage Employee</h3>
<table id="employeeList">
</table>
</div>
</body>
</html>
