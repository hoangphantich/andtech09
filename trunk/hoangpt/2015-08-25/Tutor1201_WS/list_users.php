<?php
//echo '{"users": [{"name":"hoang", "age":12, "nation":"Vietnam"}]}';
//connect database
$pdo = new PDO('mysql:host=localhost;dbname=users;charset=utf8', 'root', '123456789');

//read database
$query = "SELECT * FROM users";
$users = $pdo->query($query, PDO::FETCH_OBJ)->fetchAll();

//export to json
echo json_encode($users);
