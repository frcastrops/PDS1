<?php
$data = array(
  "userEmail" => $_POST['userEmail'],
  "userName" => $_POST['userName'],
  "userPassword" => $_POST['userPassword'],
  "userType" => $_POST['userType'],
);

$data_json = json_encode($data);

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "http://localhost:8080/create/user",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => $data_json,
  CURLOPT_HTTPHEADER => array(
    "Content-Type: application/json",
    "Content-Length: " . strlen($data_json)
  ),
));
class RequestResponse
{
    public $success;
    public $destination;
    function __construct($success, $destination)
    {
    $this->success = $success;
    $this->destination = $destination;
    }
}

$response = curl_exec($curl);

$err = curl_error($curl);

curl_close($curl);

if ($err) {
  echo "cURL Error #:" . $err;
} else {
    $httpCode = curl_getinfo($curl, CURLINFO_HTTP_CODE);
    if($httpCode == 200) {
    header('Location: usuarios.php');
    exit;
    } else {
        echo "<script>";
        echo "alert('Erro ao cadastrar usuário');";
        echo "window.location.href = 'usuarios.php';";
        echo "</script>";
    }
}
?>