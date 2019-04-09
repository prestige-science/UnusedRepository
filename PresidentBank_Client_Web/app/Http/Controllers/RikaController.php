<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class RikaController extends Controller
{
    public function index(){
    	return view('rika.index');
    }
}
