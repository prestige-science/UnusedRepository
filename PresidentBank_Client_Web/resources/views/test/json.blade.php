@extends('template')

@section('body')
<div>
<?php
    $json=file_get_contents("http://10.10.84.59:9090/user");
            $data =  json_decode($json);
 	if (count($data)) {
            foreach ($data as $d) {
            	echo $d->id . "<br>";
                echo $d->email . "<br>";
                echo $d->password . "<br>";
                echo $d->token . "<br>";
                echo $d->created . "<br>";
                echo $d->updated . "<br>";
                echo "<br>";
            }
        }
    ?>
</div>


 
@stop