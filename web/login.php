<?php
$login = $_POST['login'];
$senha = $_POST['senha'];

$data = array("login" => $login, "senha" => $senha);
$data_string = json_encode($data);

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "http://localhost:8080/auth/user",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => $data_string,
  CURLOPT_HTTPHEADER => array(
    "Content-Type: application/json",
    "Content-Length: " . strlen($data_string)
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
    header('Location: relatorioevasao.php');
    exit;
    } else {
        echo "<script>";
                echo "alert('Erro ao logar');";
                echo "window.location.href = 'index.php';";
                echo "</script>";
    }
}
?>