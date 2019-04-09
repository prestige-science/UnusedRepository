@extends('template')

@section('body')
<div>
	<?php
    if(version_compare(PHP_VERSION, '7.2.0', '>=')) {
        error_reporting(E_ALL ^ E_NOTICE ^ E_WARNING);
    }

    $jsonAccount= file_get_contents("http://192.168.43.44:9090/v1/account");
            $dataAccount=json_decode($jsonAccount);

	// $jsonTransaction=file_get_contents("http://192.168.43.44:9090/v1/transaction");
 //            $dataTransaction=json_decode($jsonTransaction);

 	if (count($dataAccount)) {
        foreach ($dataAccount as $account) {
            if ($account->id_user == $_GET['id']) {
                echo "ID : " . $account->id . "<br>";
                echo "ID User : " . $account->id_user . "<br>";
                echo "ID Bank : " . $account->id_bank . "<br>";
                echo "Amount : " . $account->amount . "<br>";
                echo "Type Transaction :" . $account->type . "<br>";
                echo "Note : " . $account->note . "<br>";
                echo "Date & Time : " . $account->created . "<br>";
                echo "<br>";

                $id_account = (int)$account->id;
                
                $cITransaction = curl_init();
                curl_setopt($cITransaction, CURLOPT_SSL_VERIFYPEER, false);
                curl_setopt($cITransaction, CURLOPT_RETURNTRANSFER, true);
                curl_setopt($cITransaction, CURLOPT_URL, 'http://192.168.43.44:9090/v1/transaction/1');
                $resultTransaction = curl_exec($cITransaction);
                curl_close($cITransaction);
                $transaction = json_decode($resultTransaction);

                echo "ID : " . $transaction->id . "<br>";
                echo "ID Account : " .$transaction->id_account . "<br>";
                echo "ID Receiver : " .$transaction->id_receiver . "<br>";
                echo "Code : " .$transaction->code . "<br>";
                echo "Serial : " .$transaction->serial . "<br>";
                echo "<br>";
                
            }
            
        }
        // foreach ($dataTransaction as $transaction) {
        //     echo "ID : " . $transaction->id . "<br>";
        //     echo "ID Account : " .$transaction->id_account . "<br>";
        //     echo "ID Receiver : " .$transaction->id_receiver . "<br>";
        //     echo "Code : " .$transaction->code . "<br>";
        //     echo "Serial : " .$transaction->serial . "<br>";
        //     echo "<br>";
        // }
    }
    	?>
</div>
@stop
