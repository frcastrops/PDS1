<?php
$url = "http://localhost:8080/create/user";
$json = file_get_contents($url);
$data = json_decode($json, true);
?>