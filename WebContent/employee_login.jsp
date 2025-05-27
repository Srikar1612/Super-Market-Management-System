<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
<link href=
"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="shortcut icon" href=
"https://cdn-icons-png.flaticon.com/512/295/295128.png">
    <script src=
"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src=
"https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="CSS/login.css">
<link rel="stylesheet" href="CSS/color/employee_login.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
</head>
<body>
<h1><i class="fa-solid fa-address-card"></i> Employee Login</h1>
<form action="Employee_Login" method="post">
<div class="details" >
<label>Employee ID: </label>
<input type="text" id="E_id" name="E_id" class="form-control" required><br><br>
<label>Password: </label>
<input type="password" id="Password" name="Password" class="form-control" required><br><br>
<div class="submit">
<input type="submit" value="submit">
</div>
</div>
</form>
</body>
</html>