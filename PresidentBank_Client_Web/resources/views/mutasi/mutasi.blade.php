@extends('template')

@section('body')
<div>
	<?php

    $jsonAccount= file_get_contents("http://192.168.43.44:9090/account");
            $dataAccount=json_decode($jsonAccount);

	$jsonTransaction=file_get_contents("http://192.168.43.44:9090/transaction");
            $dataTransaction=json_decode($jsonTransaction);

 	if (count($dataAccount)) {
            foreach ($dataAccount as $account) {
            //echo $account->id;
            echo "ID User : " . $account->idUser . "<br>";
            echo "ID Bank : " . $account->idBank . "<br>";
            echo "Amount : " . $account->amount . "<br>";
            echo "Type Transaction :" . $account->type . "<br>";
            echo "Note : " . $account->note . "<br>";
            echo "Date & Time : " . $account->created . "<br>";
            echo "<br>";

            }
        }
     if (count($dataTransaction)) {
            foreach ($dataTransaction as $transaction) {
            echo "ID : " . $transaction->id . "<br>";
            echo "ID Account : " .$transaction->idAccount . "<br>";
            echo $transaction->idReceiver . "<br>";
            echo $transaction->code . "<br>";
            echo $transaction->serial . "<br>";
            echo "<br>";
            }
        }
    	?>
</div>
@stop
